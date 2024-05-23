<script setup>
import { useBoardStore } from '@/stores/board';
import { useRouter } from 'vue-router';
const useBoard = useBoardStore();

defineProps({
  data: Object,
});

const router = useRouter();
const goDetail = (id) => {
  router.push({ name: 'noticeDetail', params: { boardId: id } });
};
</script>

<template>
  <div class="board">
    <div class="boardHeader">
      <div class="headerTitle">제목</div>
      <div class="headerWriter">작성자</div>
      <div class="headerWriteDate">작성일</div>
      <div class="headerReadCount">조회수</div>
    </div>
    <div class="boardList">
      <div
        class="boardItem"
        @mouseover="useBoard.showPreview(item)"
        @mouseleave="useBoardStore.hidePreview"
        @click="goDetail(item.noticeId)"
        v-for="item in data"
      >
        <div class="itemTitle">{{ item.noticeTitle }}</div>
        <div class="itemWriter">{{ item.userId }}</div>
        <div class="writeDate">{{ useBoard.formatDate(item.writeDate) }}</div>
        <div class="readCount">{{ item.readCount }}</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.board {
  display: flex;
  flex-direction: column;
  width: 1000px;
  margin-bottom: 20px;
  /* align-items: center; */
}
.boardTop {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.boardTitle {
  font-size: 30px;
  margin-bottom: 10px;
}
.boardDetail {
  a {
    color: gray;
  }
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
  cursor: pointer;
}
</style>
