<script setup>
defineProps({
  area: Object,
});
</script>

<template>
  <div class="areaRecommendContainer">
    <div class="areaTitle">{{ area.title }}</div>
    <div class="recommendContentContainer">
      <!-- <div class="recommendItem" v-for="" :key=""></div> -->
      <div class="recommendItem">1</div>
      <div class="recommendItem">2</div>
      <div class="recommendItem">3</div>
    </div>
  </div>
</template>

<style scoped>
/* .areaRecommendContainer {
  margin-top: 10px;
} */
.areaTitle {
  font-size: 30px;
  margin-bottom: 30px;
}
.recommendContentContainer {
  display: flex;
  justify-content: space-evenly;
  margin-bottom: 30px;
}
.recommendItem {
  width: 300px;
  height: 350px;
  background-color: antiquewhite;
  border-radius: 10px;
}
</style>
