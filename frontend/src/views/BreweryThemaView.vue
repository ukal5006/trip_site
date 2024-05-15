<script setup>
import { useThemaStore } from '@/stores/thema.js';
import { useAreaStore } from '@/stores/area.js';
import { ref } from 'vue';

const breweryThema = useThemaStore().themas[0];
const areaList = useAreaStore().breweryAreaList;
const seletedArea = ref(areaList[0]);
const seleteHandler = (index) => {
  seletedArea.value = areaList[index];
};
</script>

<template>
  <div class="breweryContainer">
    <h1 class="title">{{ breweryThema.title }}</h1>
    <h1 class="content">{{ breweryThema.content1 }}</h1>
    <h1 class="content">{{ breweryThema.content2 }}</h1>
    <div class="breweryInfoContainer">
      <div class="areaContainer">
        <div
          class="areaItem"
          v-for="(area, index) in areaList"
          :key="area.name"
          @click="seleteHandler(index)"
        >
          {{ area.title }}
        </div>
      </div>
      <h1 class="seletedAreaTitle">{{ seletedArea.title }}</h1>
      <div class="breweryListContainer">
        <div class="brewery">{{ seletedArea.name }}술집1</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.breweryContainer {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
  /* width: 1000px; */
}
.title {
  font-size: 30px;
  font-weight: 700;
}
.content {
  font-size: 18px;
  font-weight: 700;
  margin-top: 10px;
}
.breweryInfoContainer {
  display: flex;
  flex-direction: column;
  /* width: inherit; */
}
.areaContainer {
  display: flex;
  justify-content: space-evenly;
  width: 800px;
  border: 1px solid gray;
  padding: 20px;
  margin: 20px auto;
  border-radius: 10px;
  background-color: white;
}
.areaItem {
  width: 60px;
  height: 20px;
  padding-top: 5px;
  text-align: center;
  border-radius: 5px;
  transition-duration: 0.3s;
  &:hover {
    color: black;
    cursor: pointer;
  }
  color: gray;
  background-color: whitesmoke;
}
.seletedAreaTitle {
  margin: 20px auto;
  font-size: 30px;
}
.breweryListContainer {
}
</style>
