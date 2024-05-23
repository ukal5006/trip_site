<template>
  <div class="noticeContainer">
    <div class="board">
      <div class="boardTitle">공지사항</div>
      <NoticeBoardComponent :data="useBoard.noticePage.notice" />
      <div class="pagination">
        <!-- <button @click="prevPage" :disabled="isPrevDisabled">이전</button> -->
        <span
          v-for="page in pageNumbers"
          :key="page"
          @click="goToPage(page)"
          :class="{ active: page === useBoard.noticePage.pageInfo.curPage }"
        >
          {{ page }}
        </span>
        <!-- <button @click="nextPage" :disabled="isNextDisabled">다음</button> -->
      </div>
    </div>
  </div>
</template>

<script setup>
import NoticeBoardComponent from '@/components/NoticeBoardComponent.vue';
import { useBoardStore } from '@/stores/board.js';
import { computed } from 'vue';

const useBoard = useBoardStore();
console.log(useBoard.noticePage.notice);
const prevPage = () => {
  if (useBoard.pageInfo.curPage > 1) {
    useBoard.loadNoticePage(useBoard.noticePage.pageInfo.curPage - 1);
  }
};

const nextPage = () => {
  if (
    useBoard.noticePage.pageInfo.curPage <
    useBoard.noticePage.pageInfo.totalPages
  ) {
    useBoard.loadNoticePage(useBoard.pageInfo.curPage + 1);
  }
};

const goToPage = (page) => {
  useBoard.loadNoticePage(page);
};

const isPrevDisabled = computed(
  () => useBoard.noticePage.pageInfo.curPage === 1
);
const isNextDisabled = computed(
  () =>
    useBoard.noticePage.pageInfo.curPage ===
    useBoard.noticePage.pageInfo.totalPages
);

const pageNumbers = computed(() => {
  const start = useBoard.noticePage.pageInfo.startPage;
  const end = useBoard.noticePage.pageInfo.endPage;
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
