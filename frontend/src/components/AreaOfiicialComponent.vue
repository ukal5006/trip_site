<script setup>
import { useAreaStore } from '@/stores/area';
import { computed } from 'vue';
const props = defineProps({
  area: Object,
});

const areaInfo = computed(() => {
  return useAreaStore().areas[props.area.name];
});
</script>

<template>
  <div class="officialContainer">
    <span class="areaTitle">{{ area.title }}</span>
    <span>지역 문화관광 홈페이지 바로가기</span> <br />
    <div class="areaContainer">
      <a
        :href="areaItem.link"
        target="_blank"
        class="areaItem"
        v-for="areaItem in areaInfo"
        :key="areaItem"
      >
        {{ areaItem.name }}
      </a>
    </div>
  </div>
</template>

<style scoped>
.officialContainer {
  border: 1px solid grey;
  border-radius: 10px;
  padding: 10px;
  margin-bottom: 30px;
}
.areaTitle {
  font-size: 20px;
  font-weight: 700;
  margin-right: 5px;
}
.areaContainer {
  display: flex;
  flex-wrap: wrap;
  margin-left: 10px;
}
.areaItem {
  background-color: whitesmoke;
  width: 60px;
  font-size: 16px;
  margin: 10px;
  padding-top: 5px;
  text-align: center;
  border-radius: 5px;
  color: gray;
  transition-duration: 0.3s;
  &:hover {
    color: black;
  }
}
</style>
