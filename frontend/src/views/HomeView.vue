<script setup>
import { useSettingStore } from '@/stores/setting.js';
import SliderComponent from '@/components/SliderComponent.vue';
import { ref } from 'vue';
import { useBoardStore } from '@/stores/board.js';
import LogoComponent from '@/components/LogoComponent.vue';
import { useRouter } from 'vue-router';

const useBoard = useBoardStore();

const router = useRouter();

const goDetail = (id) => {
  router.push({ name: 'publicDetail', params: { boardId: id } });
};

const setting = useSettingStore();
setting.changeBoxColor('rgb(129,227,239)');

const boardList = ref([
  {
    title: '님들 그거 아십니까?',
    writer: '최용훈',
    writeDate: '2024.03.22',
    readCount: 1008,
  },
  {
    title: '좋은데?',
    writer: '정경원',
    writeDate: '2024.03.22',
    readCount: 1003,
  },
  {
    title: '조오오오치~',
    writer: '한지훈',
    writeDate: '2024.03.22',
    readCount: 1002,
  },
  {
    title: 'CA나 더워',
    writer: '한지훈',
    writeDate: '2024.03.22',
    readCount: 1001,
  },
  {
    title: '싫은데~',
    writer: '정석영',
    writeDate: '2024.03.22',
    readCount: 1000,
  },
]);
</script>

<template>
  <div class="homeConainer">
    <div class="logo">
      <LogoComponent />
    </div>
    <SliderComponent />
    <!-- <div class="board">
      <div class="boardTitle">🆕 새로 추가된 관광지</div>
      <div class="boardHeader">
        <div class="headerTitle">제목</div>
        <div class="headerWriter">작성자</div>
        <div class="headerWriteDate">작성일</div>
        <div class="headerReadCount">조회수</div>
      </div>
      <div class="boardList">
        <div class="boardItem" v-for="item in boardList">
          <div class="itemTitle">{{ item.title }}</div>
          <div class="itemWriter">{{ item.writer }}</div>
          <div class="writeDate">{{ item.writeDate }}</div>
          <div class="readCount">{{ item.readCount }}</div>
        </div>
      </div>
    </div> -->
    <div class="board">
      <div class="boardTitle">🔥 인기글</div>
      <div class="boardHeader">
        <div class="headerTitle">제목</div>
        <div class="headerWriter">작성자</div>
        <div class="headerWriteDate">작성일</div>
        <div class="headerReadCount">조회수</div>
      </div>
      <div class="boardList">
        <div
          class="boardItem"
          @click="goDetail(item.postId)"
          v-for="item in useBoard.userBoardRead"
        >
          <div class="itemTitle">{{ item.title }}</div>
          <div class="itemWriter">{{ item.userId }}</div>
          <div class="writeDate">{{ useBoard.formatDate(item.writeDate) }}</div>
          <div class="readCount">{{ item.readCount }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.homeConainer {
  /* background-color: wheat; */
}
.logo {
  position: absolute;
  left: 50px;
  top: 20px;
}
.board {
  display: flex;
  flex-direction: column;
  margin-top: 30px;
  margin-bottom: 30px;
  /* align-items: center; */
}
.boardTitle {
  font-size: 40px;
  margin: 0px auto;
  margin-bottom: 15px;
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
