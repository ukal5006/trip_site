<script setup>
import BoardHeaderComponent from '@/components/BoardHeaderComponent.vue';
import BoardComponent from '@/components/BoardComponent.vue';
import { useBoardStore } from '@/stores/board.js';
import { useRouter } from 'vue-router';
import { onMounted } from 'vue';

const { publicAll } = useBoardStore();
const router = useRouter();
const write = () => {
  router.push({ name: 'write' });
};
// let publicAll;
// onMounted(() => {
//   publicAll = useBoardStore.fetchPublic();
// });
</script>

<template>
  <div>공공게시판</div>
  <div class="publicContainer">
    <BoardHeaderComponent />
    <RouterLink
      v-for="boardInfo in publicAll"
      :key="boardInfo.no"
      :to="{ name: 'publicDetail', params: { boardId: boardInfo.no } }"
    >
      <BoardComponent :board="boardInfo" />
    </RouterLink>
    <div class="btnWapper">
      <button class="write" @click="write">글쓰기</button>
    </div>
  </div>
</template>

<style scoped>
/* .publicContainer {
  background-color: wheat;
} */
a {
  text-decoration-line: none;
  color: black;
}

.btnWapper {
  display: flex;
  justify-content: right;
  padding: 10px;
}

.write {
  font-size: 20px;
  background-color: beige;
  border-color: azure;
  border-radius: 8px;
}
</style>
