<script setup>
import { useSettingStore } from '@/stores/setting.js';
import SliderComponent from '@/components/SliderComponent.vue';

const setting = useSettingStore();
setting.changeBoxColor('rgb(240,227,255)');
</script>

<template>
  <div class="homeConainer">
    <h1>HomeView</h1>
    <SliderComponent />
  </div>
</template>

<style scoped>
.homeConainer {
  background-color: wheat;
}
</style>
