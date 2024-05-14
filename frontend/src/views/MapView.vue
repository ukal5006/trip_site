<script setup>
import { useSettingStore } from "@/stores/setting";

const setting = useSettingStore();
setting.changeBoxColor("rgb(241,255,227)");
</script>
<template>
    <h1>Map</h1>
</template>

<style scoped></style>
