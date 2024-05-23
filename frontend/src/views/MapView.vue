<script setup>
import { useSettingStore } from '@/stores/setting';
import MapComponent from '@/components/MapComponent.vue';

const setting = useSettingStore();
setting.changeBoxColor('rgb(225,245,196)');
</script>
<template>
  <MapComponent class="mapMain" />
</template>

<style scoped>
.mapMain {
  border-top: 1px solid black;
  height: 100px;
  width: 100%;
  position: relative;
  box-sizing: border-box;
}
</style>
