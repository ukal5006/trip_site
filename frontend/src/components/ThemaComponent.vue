<script setup>
import { useRouter } from "vue-router";

const props = defineProps({
    thema: Object,
});

const router = useRouter();
const clickHandler = (themaName) => {
    router.push({ name: themaName });
};

const backgroundStyle = {
    backgroundImage: `linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url('${props.thema.img}')`,
    backgroundRepeat: "no-repeat",
    backgroundSize: "cover",
    backgroundPosition: "center",
};
</script>

<template>
    <div class="themaContainer" @click="clickHandler(thema.name)" :style="backgroundStyle">
        <h1 class="title">{{ thema.title }}</h1>
        <h1 class="content">{{ thema.content1 }}</h1>
        <h1 class="content">{{ thema.content2 }}</h1>
    </div>
</template>

<style scoped>
.themaContainer {
    height: 500px;
    width: 100%;
    cursor: pointer;
    color: rgb(255, 255, 255);
    position: relative;
    border-radius: 40px;
}

.title,
.content {
    position: relative;
    z-index: 1;
}

.title {
    font-size: 30px;
    font-weight: 700;
    margin-bottom: 10px;
    top: 100px;
}

.content {
    font-size: 18px;
    margin-bottom: 5px;
    font-weight: 700;
    top: 150px;
}
</style>
