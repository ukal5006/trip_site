<script setup>
import axios from 'axios';
import { ref, watch } from 'vue';
import { useDataInfoStore } from '@/stores/dataInfo.js';

// const URL = 'http://192.168.10.93:9999/attraction/getTop3/';
const URL = `${import.meta.env.VITE_URL}attraction/getTop3/`;

const props = defineProps({
  area: Object,
});
const data = ref();

const loadData = () => {
  axios
    .get(`${URL}${props.area.title}`)
    .then((response) => {
      // 서버로부터 받은 데이터로 로직 처리
      data.value = response.data;
    })
    .catch((error) => {
      console.error('Error fetching data: ', error);
    });
};
loadData();
watch(props, () => {
  loadData();
});

const navigateToDetail = (id) => {
  window.open(`${window.location.origin}/detail/${id}`, '_blank');
};
</script>

<template>
  <div class="areaRecommendContainer">
    <div class="areaTitle">{{ area.title }}</div>
    <div class="recommendContentContainer">
      <div
        class="recommendItem"
        v-for="(item, index) in data"
        :key="index"
        @click="navigateToDetail(item.contentId)"
      >
        <div class="typeTitle">
          {{ useDataInfoStore().getTypeTitle(item.contentTypeId) }}
        </div>
        <div class="imgWrapper">
          <img
            class="img"
            :src="
              item.firstImage == ''
                ? 'https://koueitrading.com/global/wp-content/uploads/2020/10/noimg-575x380.png'
                : item.firstImage
            "
            alt=""
            decoding="async"
          />
        </div>
        <div class="itemTitle">{{ item.title }}</div>
        <div class="itemAddr">{{ item.addr1 }}</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
/* .areaRecommendContainer {
  margin-top: 10px;
} */
.areaTitle {
  font-size: 30px;
  font-weight: 700;
  margin-bottom: 30px;
}
.recommendContentContainer {
  display: flex;
  justify-content: space-evenly;
  margin-bottom: 30px;
}
.recommendItem {
  position: relative;
  width: 310px;
  height: 350px;
  background-color: whitesmoke;
  border-radius: 10px;
  cursor: pointer;
}
.typeTitle {
  position: absolute;
  background-color: rgb(51, 51, 51);
  width: 60px;
  height: 30px;
  color: rgb(240, 242, 244);
  display: flex;
  align-items: center;
  justify-content: center;
  top: 10px;
  left: 10px;
  border-top-left-radius: 50%;
  border-top-right-radius: 50%;
}

.imgWrapper {
  width: 100%;
  height: 300px;
  overflow: hidden;
}
.img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  content-visibility: auto;
}
.itemTitle {
  margin: 5px;
  font-size: 20px;
  max-width: 100%;
  text-wrap: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
.itemAddr {
  font-size: 15px;
  margin: 5px;
  max-width: 100%;
  text-wrap: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
