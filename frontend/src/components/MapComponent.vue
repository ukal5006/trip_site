<script setup>
import axios from 'axios';
import { onMounted, computed, ref, watch } from 'vue';
import { KakaoMap, KakaoMapMarker } from 'vue3-kakao-maps';
import { useDataInfoStore } from '@/stores/dataInfo.js';

//http://192.168.10.93:9999/attraction/inRange?latitude=37.5665&longitude=126.9780&level=3
const URL = 'http://192.168.10.93:9999/attraction/inRange?';
const level = ref('3');
const btnOpen = ref(true);
const detailInfo = ref();
const detailOpen = ref(false);
const btnHandler = () => {
  btnOpen.value = !btnOpen.value;
};
const detailOn = (contentId) => {
  detailOpen.value = true;
  detailInfo.value = contentId;
};
const detailOff = () => {
  detailOpen.value = false;
};
const map = ref();

const allItemList = ref();

const dataInfo = useDataInfoStore();
// 사용자의 현재 위치를 받아오기 위한 함수
const getUserLocation = () => {
  console.log('위치받아오기');
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(
      (position) => {
        // 사용자의 현재 위치를 받아와 coordinate ref를 업데이트합니다.
        coordinate.value.lat = position.coords.latitude;
        coordinate.value.lng = position.coords.longitude;
      },
      () => {
        console.error('Error: The Geolocation service failed.');
        alert(
          '위치 액세스가 거부되어있습니다. 위치를 중심으로 보고 싶으시면 위치 액세스를 허용해 주세요.'
        );
      }
    );
  } else {
    console.error("Error: Your browser doesn't support Geolocation.");
  }
};

const coordinate = ref({
  lat: 37.566826, // 기본 좌표 (서울 시청)
  lng: 126.9786567,
});

const catagoryClickHandler = (catagoryIndex) => {
  mapCatagory[catagoryIndex].isActive = !mapCatagory[catagoryIndex].isActive;
};

getUserLocation();

onMounted(() => {
  console.log('마운트됨');
  console.log(coordinate.value);
});

const onLoadKakaoMap = (mapRef) => {
  map.value = mapRef;

  // 지도 드래그 종료 이벤트 리스너 추가
  window.kakao.maps.event.addListener(map.value, 'dragend', function () {
    // 현재 지도의 중심 좌표를 가져옵니다
    const center = map.value.getCenter();
    console.log('맵 드래그했음');
    loadData(center.getLat(), center.getLng(), level.value);
  });
};

// 서버로부터 데이터를 로드하는 함수입니다. 위도와 경도를 인자로 받습니다.
const loadData = (lat, lng, level) => {
  axios
    .get(`${URL}latitude=${lat}&longitude=${lng}&level=${level}`)
    .then((response) => {
      // 서버로부터 받은 데이터로 로직 처리
      // console.log(lat);
      // console.log(lng);
      // console.log(level);
      // console.log(response);
      allItemList.value = response.data;
      console.log(allItemList.value);
      // 예: 받아온 데이터를 기반으로 마커 추가, 지도 정보 갱신 등
    })
    .catch((error) => {
      console.error('Error fetching data: ', error);
    });
};
const itemList = ref();
watch(allItemList, () => {
  if (allItemList.value != null) {
    itemList.value = allItemList.value.filter((item) =>
      dataInfo.getIsActive(item.contentTypeId)
    );
  } else {
    itemList.value = null;
  }
});
watch(dataInfo.mapCatagory, () => {
  if (allItemList.value != null) {
    itemList.value = allItemList.value.filter((item) =>
      dataInfo.getIsActive(item.contentTypeId)
    );
  }
});

const btnContent = computed(() => {
  return btnOpen.value ? 'fa fa-chevron-left' : 'fa fa-chevron-right';
});

watch(coordinate.value, () => {
  console.log('지도 좌표 변경');
});

const mapCatagory = dataInfo.mapCatagory;
const getTypeTitle = dataInfo.getTypeTitle;

const navigateToDetail = (id) => {
  window.open(`${window.location.origin}/detail/${id}`, '_blank');
};
</script>

<template>
  <div>
    <KakaoMap
      :lat="coordinate.lat"
      :lng="coordinate.lng"
      :draggable="true"
      width="100%"
      height="calc(100vh - 60px)"
      @onLoadKakaoMap="onLoadKakaoMap"
      :level
    >
      <KakaoMapMarker
        :lat="coordinate.lat"
        :lng="coordinate.lng"
      ></KakaoMapMarker>
    </KakaoMap>
    <div
      class="mapContentContainer"
      :class="{ close: !btnOpen, open: btnOpen }"
    >
      <div class="leftSide">
        <div class="userPlaceInfoContainer">
          <div class="userAddr">대전 대덕구</div>
        </div>
        <div class="selectCatagory">
          <div
            class="catagory"
            v-for="(catagoryInfo, index) in mapCatagory"
            :key="index"
            @click="catagoryClickHandler(index)"
          >
            <i
              class="fa"
              :class="catagoryInfo.icon"
              :style="{
                color: catagoryInfo.isActive ? catagoryInfo.color : 'gray',
              }"
              aria-hidden="true"
            ></i>
            <span :class="{ isActive: catagoryInfo.isActive }">{{
              catagoryInfo.title
            }}</span>
          </div>
        </div>
        <div class="placeListContainer">
          <div
            v-for="place in itemList"
            class="placeItem"
            @click="detailOn(place)"
          >
            <div class="placeImage">
              <img
                :src="
                  place.firstImage == ''
                    ? 'https://koueitrading.com/global/wp-content/uploads/2020/10/noimg-575x380.png'
                    : place.firstImage
                "
              />
            </div>
            <div class="placeContent">
              <div class="placeInfoContainer">
                <div class="placeTitle">{{ place.title }}</div>
                <div class="placeType">
                  {{ getTypeTitle(place.contentTypeId) }}
                </div>
              </div>
              <div class="placeAddr">{{ place.addr1 }}</div>
              <div class="bookmarkBtn">
                <i class="fa fa-bookmark placeBookmark" aria-hidden="true"></i>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="detailPlace" :class="{ none: !detailOpen }">
        <div class="detailBtn" @click="detailOff">X</div>
        <div class="detailInfo" @click="navigateToDetail(detailInfo.contentId)">
          <div class="detailImg">
            <img
              :src="
                detailInfo?.firstImage == ''
                  ? 'https://koueitrading.com/global/wp-content/uploads/2020/10/noimg-575x380.png'
                  : detailInfo?.firstImage
              "
            />
          </div>
          <div class="detailInfoContainer">
            <div class="detailTitle">
              {{ detailInfo?.title }}
            </div>
            <div class="detailAddr">{{ detailInfo?.addr1 }}</div>
            <div class="detailOverview">
              {{ detailInfo?.overview }}
            </div>
          </div>
        </div>
        <!-- <div class="reviewContainer">
          <div class="reviewBtn">
            <div class="reviewListBtn">리뷰</div>
            <div class="reviewAddBtn">리뷰남기기</div>
          </div>
          <div class="reviewList"></div>
          <div class="reviewAdd"></div>
        </div> -->
      </div>
      <div @click="btnHandler" class="controllBtn">
        <i :class="btnContent"></i>
      </div>
    </div>
  </div>
</template>

<style scoped>
.mapContentContainer {
  display: flex;
  position: absolute;
  top: 0px;
  z-index: 1;
  height: calc(100vh - 60px);
  width: fit-content;
  transition: 0.3s ease-in-out;
}
.leftSide {
  width: 400px;
  height: 100%;
  background-color: white;
}
.userPlaceInfoContainer {
  height: 100px;
  display: flex;
  align-items: center;
  justify-content: center;
  /* box-shadow: 0 0 0 1px gray inset; */
}
.userAddr {
  font-size: 28px;
  font-weight: 700;
  /* margin-left: 20px; */
}
.selectCatagory {
  height: 150px;
  display: flex;
  flex-wrap: wrap;
  border-top: 1px solid grey;
  border-bottom: 1px solid grey;
}
.catagory {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
  width: 80px;
  cursor: pointer;
  color: gray;
  /* border-radius: 10px;
  box-shadow: 0 0 0 1px gray inset; */
}
.fa {
  margin-bottom: 5px;
  font-size: 40px;
}
.placeListContainer {
  height: calc(100vh - 60px - 250px);
  overflow-y: scroll;
  box-sizing: border-box;
}
.placeItem {
  height: 120px;
  cursor: pointer;
  border-bottom: 1px solid grey;
  display: flex;
  align-items: center;
  justify-content: space-evenly;
}
.placeImage {
  width: 100px;
  height: 100px;
  border-radius: 5px;
  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-radius: 5px;
  }
}
.placeContent {
  width: 250px;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
}

.placeInfoContainer {
  display: flex;
  align-items: center;
}
.placeTitle {
  overflow: hidden;
  white-space: nowrap;
  max-width: 180px;
  text-overflow: ellipsis;
  margin-right: 10px;
  font-size: 20px;
}

.placeType {
  font-size: 14px;
  color: gray;
}
.placeAddr {
  font-size: 20px;
  max-width: 250px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
.placeBookmark {
  font-size: 20px;
  color: gray;
}
.detailPlace {
  position: relative;
  width: 400px;
  height: 100%;

  /* background-color: rgba(0, 0, 0, 0.5); */
  background-color: whitesmoke;
}
.detailBtn {
  position: absolute;
  top: 10px;
  right: -30px;
  font-size: 30px;
  color: gray;
  cursor: pointer;
  background-color: aliceblue;
  width: 30px;
  height: 30px;
  text-align: center;
}
.detailInfo {
  cursor: pointer;
  img {
    width: 100%;
    height: 300px;
    object-fit: cover;
  }
}
.detailInfoContainer {
  padding: 10px;
  height: 200px;
}
.detailTitle {
  font-size: 30px;
  margin-bottom: 10px;
}
.detailAddr {
  font-size: 20px;
  margin-bottom: 10px;
}
.detailOverview {
  font-size: 17px;
  /* overflow: hidden; */
  /* white-space: nowrap; */
  max-width: 500px;
  max-height: 200px;
  text-overflow: ellipsis;
}
.reviewContainer {
  background-color: tomato;
  height: 380px;
}
.reviewBtn {
  display: flex;
  width: 100%;
  padding: 10px 0px;
  background-color: white;
  div {
    width: 50%;
    font-size: 20px;
    text-align: center;
    border-left: 1px solid black;
  }
}
.controllBtn {
  position: absolute;
  right: -30px;
  top: 50%;
  transform: translateY(-50%);
  height: 50px;
  background-color: whitesmoke;
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
  font-size: 40px;
  display: flex;
  cursor: pointer;
  align-items: center;
  width: 30px;
}
.close {
  transform: translateX(calc(-100%));
}
.open {
  transform: translateX(0);
}
.none {
  display: none;
}
.isActive {
  font-weight: 700;
  color: black;
}
</style>
