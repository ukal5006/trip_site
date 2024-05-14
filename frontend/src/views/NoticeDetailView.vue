<script setup>
import { useBoardStore } from "@/stores/board.js";
import { useRoute } from "vue-router";
import { ref } from "vue";
import BoardDetailComponent from "@/components/BoardDetailComponent.vue";

const { noticeAll } = useBoardStore();
const route = useRoute();
const boardId = ref(route.params.boardId);
</script>

<template>
  <BoardDetailComponent :board="noticeAll[boardId]" />
</template>

<style scoped></style>
