<script setup>
import { onMounted, ref } from "vue";
import { RouterView } from "vue-router";
import HeaderComponent from "@/components/HeaderComponent.vue";
import { useSettingStore } from "./stores/setting";

const hasScrolled = ref(false); // 스크롤 여부에 따른 반응형 변수
const handleScroll = () => {
    if (window.scrollY > 0) {
        hasScrolled.value = true;
    } else {
        hasScrolled.value = false;
    }
};

onMounted(() => {
    window.addEventListener("scroll", handleScroll);
});
</script>

<template>
    <header :class="{ scrolled: hasScrolled }">
        <HeaderComponent />
    </header>
    <div class="backgroundBox" :style="{ backgroundColor: useSettingStore().boxColor }"></div>
    <main>
        <RouterView />
    </main>
</template>

<style scoped>
header {
    width: 100vw;
    position: fixed;
    left: 50%;
    transform: translate(-50%, 0);
    transition: background-color 0.3s; /* 부드러운 전환 효과 */
}
main {
    padding-top: 60px;
    width: 1000px;
    margin: 0px auto;
}

.backgroundBox {
    width: 100vw;
    height: 600px;
    position: absolute;
    top: 0;
    left: 0;
    z-index: -1;
    transition: background-color 0.3s;
}

/* 스크롤됐을 때 적용될 스타일 */
.scrolled {
    background-color: white; /* 원하는 배경색으로 변경하세요 */
    box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -2px rgba(0, 0, 0, 0.06);
}
</style>
