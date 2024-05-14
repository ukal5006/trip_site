<script setup>
import RandomComponent from './RandomComponent.vue';
defineProps({
  area: Object,
});
</script>

<template>
  <div class="areaRandomContainer">
    <div class="spotContainer travleSpot">
      <span class="areaTitle">
        {{ area.title }}
      </span>
      랜덤 여행지
      <RandomComponent :random="{ type: 'travel', areaName: area.name }" />
    </div>
    <div class="spotContainer eatSpot">
      <span class="areaTitle">
        {{ area.title }}
      </span>
      랜덤 맛집
      <RandomComponent :random="{ type: 'eat', areaName: area.name }" />
    </div>
  </div>
</template>

<style scoped>
.areaRandomContainer {
  padding: 10px;
}

.spotContainer {
  height: 300px;
  background-color: tomato;
  margin-top: 20px;
}
.areaTitle {
  font-size: 20px;
  font-weight: 700;
}
</style>
