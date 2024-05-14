import { ref } from "vue";
import { defineStore } from "pinia";

export const useSettingStore = defineStore("setting", () => {
    const boxColor = ref("rgb(0, 0, 255)");
    const changeBoxColor = (color) => {
        boxColor.value = color;
    };
    return { boxColor, changeBoxColor };
});
