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
      <RandomComponent
        :random="{
          type: 'randomList',
          areaName: area.name,
          areaTitle: area.title,
        }"
      />
    </div>
    <div class="spotContainer eatSpot">
      <span class="areaTitle">
        {{ area.title }}
      </span>
      랜덤 맛집
      <RandomComponent
        :random="{
          type: 'randomRestaurant',
          areaName: area.name,
          areaTitle: area.title,
        }"
      />
    </div>
  </div>
</template>

<style scoped>
.areaRandomContainer {
  padding: 10px;
}

.spotContainer {
  height: 370px;
  margin-top: 20px;
  border: 1px solid black;
  border-radius: 10px;
  padding: 10px;
}
.areaTitle {
  font-size: 20px;
  font-weight: 700;
}
</style>
