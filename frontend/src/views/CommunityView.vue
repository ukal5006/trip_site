<script setup>
import { RouterLink } from 'vue-router';
import { useBoardStore } from '@/stores/board.js';
import NoticeBoardComponent from '@/components/NoticeBoardComponent.vue';
import PublicBoardComponent from '@/components/PublicBoardComponent.vue';

const useBoard = useBoardStore();
</script>

<template>
  <div class="communityConainter">
    <div class="communityTitle">커뮤니티</div>
    <div class="board">
      <div class="boardTop">
        <div class="boardTitle">공지사항</div>
        <div class="boardDetail">
          <RouterLink :to="{ name: 'notice' }">더보기 ></RouterLink>
        </div>
      </div>
      <NoticeBoardComponent :data="useBoard.noticeTop" />
    </div>
    <div class="board">
      <div class="boardTop">
        <div class="boardTitle">자유게시판</div>
        <div class="boardDetail">
          <RouterLink :to="{ name: 'public' }">더보기 ></RouterLink>
        </div>
      </div>
      <PublicBoardComponent :data="useBoard.userBoardTop" />
    </div>
    <!-- <div v-if="useBoard.hoveredItem" class="preview">
      <h3>미리보기</h3>
      <p>{{ useBoard.hoveredItem.content }}</p>
    </div> -->
  </div>
</template>

<style scoped>
.communityConainter {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.communityTitle {
  font-size: 40px;
  margin-bottom: 20px;
}
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
}
.preview {
  position: absolute; /* 미리보기를 절대 위치로 설정하여 원하는 위치에 배치 */
  top: 50%; /* 상단에서 50% 떨어진 곳에 위치 */
  left: 50%; /* 왼쪽에서 50% 떨어진 곳에 위치 */
  transform: translate(-50%, -50%); /* 정확한 중앙 위치로 조정 */
  width: 80%; /* 미리보기의 너비를 전체 너비의 80%로 설정 */
  padding: 20px; /* 내용과 테두리 사이에 여백 추가 */
  background-color: #f9f9f9; /* 배경색 설정 */
  border: 1px solid #ddd; /* 테두리 설정 */
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 그림자 효과 추가 */
  z-index: 1000; /* 다른 요소 위에 미리보기가 표시되도록 z-index 설정 */
}

.preview h3 {
  margin-top: 0;
  color: #333; /* 제목 색상 설정 */
  font-size: 24px; /* 제목 폰트 크기 설정 */
}

.preview p {
  color: #666; /* 문단 색상 설정 */
  font-size: 16px; /* 문단 폰트 크기 설정 */
}
</style>
