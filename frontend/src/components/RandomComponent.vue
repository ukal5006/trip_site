<script setup>
import { ref } from "vue";

const props = defineProps({
    random: Object,
});

const randomDatas = ref([1, 2, 3, 4]);
</script>

<template>
    <div class="itemsContainer">
        <div class="item" v-for="randomData in randomDatas" :key="randomData">
            <div class="imgWrapper">사진</div>
            <div class="infoContainer">
                <div class="title">제목</div>
                <div class="address">주소</div>
            </div>
        </div>
    </div>
</template>

<style scoped>
.itemsContainer {
    display: flex;
    height: inherit;
    justify-content: space-between;
    padding: 10px;
}

.item {
    width: 220px;
    height: 250px;
    background-color: aqua;
    border-radius: 10px;
}
.imgWrapper {
    width: 100%;
    height: 70%;
    background-color: yellow;
}
.infoContainer {
    width: 100%;
    height: 30%;
    background-color: blueviolet;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: center;
}
</style>
