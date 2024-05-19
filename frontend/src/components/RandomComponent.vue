<script setup>
import { ref, watch } from 'vue';
import axios from 'axios';
import { useDataInfoStore } from '@/stores/dataInfo';

const dataType = useDataInfoStore().dataType;
const props = defineProps({
  random: Object,
});

watch(props, () => {
  loadData();
});

const randomDatas = ref('');
const URL = 'http://192.168.10.93:9999/attraction/';
const loadData = async () => {
  console.log('데이터 슛!');
  try {
    const response = await axios.get(
      `${URL}${props.random.type}/${props.random.areaTitle}`
    );
    console.log(response.data);
    randomDatas.value = response.data;
  } catch (error) {
    console.error(error);
  }
};
loadData();
</script>

<template>
  <div class="itemsContainer">
    <div class="item" v-for="data in randomDatas" :key="data">
      <div class="imgWrapper">
        <img class="contentImg" :src="data?.firstImage" alt="" />
      </div>
      <div class="infoContainer">
        <div class="title">{{ data?.title }}</div>
        <div class="address">{{ data?.addr1 }}</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.itemsContainer {
  display: flex;
  /* height: 1000px; */
  justify-content: space-between;
  padding: 10px;
}

.item {
  width: 300px;
  height: 350px;
}
.imgWrapper {
  width: 100%;
  height: 80%;
}
.infoContainer {
  width: 100%;
  height: 20%;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
}
.contentImg {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 20px;
}
</style>
