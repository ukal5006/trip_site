<script setup>
import { ref } from 'vue';
import AreaRecommendComponet from '@/components/AreaRecommendComponent.vue';
import AreaOfiicialComponent from '@/components/AreaOfiicialComponent.vue';
import AreaRandomComponent from '@/components/AreaRandomComponent.vue';
import { useSettingStore } from '@/stores/setting';

const setting = useSettingStore();
setting.changeBoxColor('rgb(211, 245, 255)');
const areaList = [
  {
    name: 'seoul',
    title: '서울',
    img: 'https://cdn-icons-png.flaticon.com/512/760/760069.png',
  },
  {
    name: 'incheon',
    title: '인천',
    img: 'https://us.123rf.com/450wm/iamcitrus/iamcitrus1610/iamcitrus161000014/63869399-airport-building-plane-is-landing-line-icon.jpg?ver=6',
  },
  {
    name: 'deajeon',
    title: '대전',
    img: 'https://i.namu.wiki/i/HIBsVgaBuErpqgNJOIUGAJ99NukWoerkumzqA4xg18vA-fUpwxwjS7iZyQGw2BoPGqyauCK6zGF9Zqi35niSeg.webp',
  },
  {
    name: 'deagu',
    title: '대구',
    img: 'https://i.ibb.co/5Yw2c6f/deagu.jpg',
  },
  {
    name: 'gyeonggi',
    title: '경기',
    img: 'https://cdn-icons-png.flaticon.com/512/4976/4976190.png',
  },
  {
    name: 'busan',
    title: '부산',
    img: 'https://cdn-icons-png.flaticon.com/512/2090/2090184.png',
  },
  {
    name: 'ulsan',
    title: '울산',
    img: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQilFhFv_gfo461cgNqm_aKtQpSk7CzhpitwrkOT2HOPQ&s',
  },
  {
    name: 'gwangju',
    title: '광주',
    img: 'https://cdn-icons-png.flaticon.com/512/8995/8995579.png',
  },
  {
    name: 'gangwon',
    title: '강원',
    img: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRkAtor3a-L90anZVUAyCqtOzbrq5-Dm_iZPea_gwn7FQ&s',
  },
  {
    name: 'jeju',
    title: '제주',
    img: 'https://cdn-icons-png.flaticon.com/512/4918/4918411.png',
  },
];
const selectedArea = ref({
  name: 'seoul',
  title: '서울',
});

const clickArea = (area) => {
  selectedArea.value.name = area.name;
  selectedArea.value.title = area.title;
};
</script>

<template>
  <div>
    <h1 class="info">대한민국 지역 정보</h1>
    <h1 class="info">어디까지 알고있니?</h1>
    <div class="areaContainer">
      <div
        class="areaWrapper"
        v-for="area in areaList"
        :key="area"
        @click="clickArea(area)"
      >
        <div class="areaImg">
          <img :src="area.img" />
        </div>
        <span>{{ area.title }}</span>
      </div>
    </div>
    <AreaRecommendComponet :area="selectedArea" />
    <AreaOfiicialComponent :area="selectedArea" />
    <AreaRandomComponent :area="selectedArea" />
  </div>
</template>

<style scoped>
.info {
  font-size: 30px;
  margin: 10px 0px;
}

.areaContainer {
  width: 1000px;
  display: flex;
  justify-content: space-around;
  margin: 40px auto;
}
.areaWrapper {
  width: 75px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.areaWrapper:hover {
  cursor: pointer;
}
.areaWrapper:hover .areaImg {
  box-shadow: 2px 2px 1px gray;
}

.areaImg {
  width: 75px;
  height: 75px;
  border-radius: 50%;
  margin-bottom: 10px;
}

.areaTitle {
  font-size: 30px;
  font-weight: 700;
  margin-top: 40px;
}
img {
  width: 100%;
  height: 100%;
  border-radius: 50%;
}

/* .areaContentContainer {
} */
</style>
