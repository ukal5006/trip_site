<script setup>
import BoardHeaderComponent from "@/components/BoardHeaderComponent.vue";
import BoardComponent from "@/components/BoardComponent.vue";
import { useBoardStore } from "@/stores/board.js";
import { RouterLink } from "vue-router";

const { noticeAll } = useBoardStore();
</script>

<template>
  <div>공지사항</div>
  <div class="noticeContainer">
    <BoardHeaderComponent />
    <RouterLink
      v-for="boardInfo in noticeAll"
      :key="boardInfo.no"
      :to="{ name: 'noticeDetail', params: { boardId: boardInfo.no } }"
    >
      <BoardComponent :board="boardInfo" />
    </RouterLink>
  </div>
</template>

<style scoped>
.noticeContainer {
  background-color: wheat;
}
a {
  text-decoration-line: none;
  color: black;
}
</style>
