<template>
  <div class="noticeContainer">
    <div class="board">
      <div class="boardTitle">자유게시판</div>
      <PublicBoardComponent :data="useBoardStore().userBoardPage.userBoard" />
      <div class="pagination">
        <!-- <button @click="prevPage" :disabled="isPrevDisabled">이전</button> -->
        <span
          v-for="page in pageNumbers"
          :key="page"
          @click="goToPage(page)"
          :class="{
            active: page === useBoardStore().userBoardPage.pageInfo.curPage,
          }"
        >
          {{ page }}
        </span>
        <!-- <button @click="nextPage" :disabled="isNextDisabled">다음</button> -->
      </div>
    </div>
  </div>
</template>

<script setup>
import PublicBoardComponent from '@/components/PublicBoardComponent.vue';
import { useBoardStore } from '@/stores/board.js';
import { computed } from 'vue';

const useBoard = useBoardStore().userBoardPage;
console.log(useBoard);
const prevPage = () => {
  if (useBoard.pageInfo.curPage > 1) {
    useBoardStore().loadUserBoardPage(useBoard.pageInfo.curPage - 1);
  }
};

const nextPage = () => {
  if (useBoard.pageInfo.curPage < useBoard.pageInfo.totalPages) {
    useBoardStore().loadUserBoardPage(useBoard.pageInfo.curPage + 1);
  }
};

const goToPage = (page) => {
  useBoardStore().loadUserBoardPage(page);
};

const isPrevDisabled = computed(
  () => useBoardStore().userBoardPage.pageInfo.curPage === 1
);
const isNextDisabled = computed(
  () =>
    useBoard.pageInfo.curPage ===
    useBoardStore().userBoardPage.pageInfo.totalPages
);

const pageNumbers = computed(() => {
  const start = useBoard.pageInfo.startPage;
  const end = useBoard.pageInfo.endPage;
  return Array.from({ length: end - start + 1 }, (_, i) => start + i);
});
</script>

<style scoped>
.noticeContainer {
}
.board {
  display: flex;
  flex-direction: column;
  width: 1000px;
  margin-bottom: 20px;
  /* align-items: center; */
}
.boardTitle {
  font-size: 30px;
  margin-bottom: 10px;
  text-align: center;
}
.boardHeader {
  display: flex;
  height: 45px;
  align-items: center;
  border-top: 2px solid black;
  border-bottom: 2px solid black;
  div {
    font-size: 20px;
    font-weight: 700;
  }
}
.headerTitle,
.itemTitle {
  width: 55%;
  text-align: center;
}
.headerWriter,
.itemWriter {
  width: 20%;
}
.headerWriteDate,
.writeDate {
  width: 15%;
  text-align: center;
}
.headerReadCount,
.readCount {
  width: 10%;
  text-align: center;
}
.boardItem {
  display: flex;
  align-items: center;
  height: 37px;
  border-bottom: 1px solid gray;
}
a {
  text-decoration-line: none;
  color: black;
}
.pagination {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}
.pagination span {
  margin: 0 5px;
  cursor: pointer;
}
.pagination span.active {
  font-weight: bold;
  text-decoration: underline;
}
.pagination button {
  margin: 0 10px;
}
</style>
