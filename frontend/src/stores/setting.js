import { ref } from 'vue';
import { defineStore } from 'pinia';

export const useSettingStore = defineStore('setting', () => {
  const boxColor = ref('');
  const changeBoxColor = (color) => {
    boxColor.value = color;
  };
  return { boxColor, changeBoxColor };
});
