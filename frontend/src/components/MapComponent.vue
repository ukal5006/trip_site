<script setup>
import axios from 'axios';
import { onMounted, computed, ref, watch } from 'vue';
import { KakaoMap, KakaoMapMarker } from 'vue3-kakao-maps';

//http://192.168.10.93:9999/attraction/inRange?latitude=37.5665&longitude=126.9780&level=3
const URL = 'http://192.168.10.93:9999/attraction/inRange?';
const level = ref('3');
const btnOpen = ref(true);
const detailOpen = ref(true);
const btnHandler = () => {
  btnOpen.value = !btnOpen.value;
};
const detailHandler = () => {
  detailOpen.value = false;
};
const map = ref();

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
    loadData(center.getLat(), center.getLng(), level.value);
  });
};

// 서버로부터 데이터를 로드하는 함수입니다. 위도와 경도를 인자로 받습니다.
const loadData = (lat, lng, level) => {
  axios
    .get(`${URL}latitude=${lat}&longitude=${lng}&level=${level}`)
    .then((response) => {
      // 서버로부터 받은 데이터로 로직 처리
      console.log(lat);
      console.log(lng);
      console.log(level);
      console.log(response);
      // 예: 받아온 데이터를 기반으로 마커 추가, 지도 정보 갱신 등
    })
    .catch((error) => {
      console.error('Error fetching data: ', error);
    });
};

const btnContent = computed(() => {
  return btnOpen.value ? 'fa fa-chevron-left' : 'fa fa-chevron-right';
});

watch(coordinate.value, () => {
  console.log('지도 좌표 변경');
});
</script>

<template>
  <KakaoMap
    :lat="coordinate.lat"
    :lng="coordinate.lng"
    :draggable="true"
    width="100%"
    height="700"
    @onLoadKakaoMap="onLoadKakaoMap"
    :level
  >
    <KakaoMapMarker
      :lat="coordinate.lat"
      :lng="coordinate.lng"
    ></KakaoMapMarker>
  </KakaoMap>
  <div class="mapContentContainer" :class="{ close: !btnOpen, open: btnOpen }">
    <div class="leftSide">
      <div class="seletCatagory"></div>
      <div class="places"></div>
    </div>
    <div class="detailPlace" :class="{ none: !detailOpen }">
      <div class="detailBtn" @click="detailHandler">X</div>
    </div>
    <div @click="btnHandler" class="controllBtn">
      <i :class="btnContent"></i>
    </div>
  </div>
</template>

<style scoped>
.mapContentContainer {
  display: flex;
  position: relative;
  top: -700px;
  z-index: 1;
  height: 700px;
  width: fit-content;
  transition: 0.3s ease-in-out;
  /* transform: translateX(0); */
  /* background-color: white; */
}
.leftSide {
  width: 400px;
  height: 700px;
  background-color: white;
  /* background-color: rgba(0, 0, 0, 0.5); */
  display: flex;
}
.detailPlace {
  position: relative;
  width: 400px;
  height: 700px;
  background-color: white;
  /* background-color: rgba(0, 0, 0, 0.5); */
}
.detailBtn {
  position: absolute;
  top: 10px;
  right: 10px;
  font-size: 30px;
  color: gray;
  cursor: pointer;
}
.controllBtn {
  position: relative;
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
  transform: translateX(calc(-100% + 25px));
}
.open {
  transform: translateX(0);
}
.none {
  display: none;
}
</style>
