<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useMemberStore } from '@/stores/member.js';
import { useRouter } from 'vue-router';
import { useBoardStore } from '@/stores/board';

const router = useRouter();

const useMember = useMemberStore();
const useBoard = useBoardStore();
const inputTitle = ref('');
const inputContent = ref('');

if (useMember.user == null) {
  alert('글쓰기는 회원만 가능합니다. 로그인을 하고 다시 시도해 주세요.');
  router.go(-1);
}

const reset = () => {
  inputTitle.value = '';
  inputContent.value = '';
};
const submit = () => {
  console.log(useMember.user.userId);
  console.log(inputTitle.value);
  console.log(inputContent.value);
  if (useBoard.boardType == 0) {
    axios
      .post(`${import.meta.env.VITE_URL}userBoard/write`, {
        userId: useMember.user.userId,
        title: inputTitle.value,
        content: inputContent.value,
        postType: 1,
      })
      .then((response) => {
        alert('글이 성공적으로 작성됐습니다.');
        useBoard.loadUserBoard();
        useBoard.loadUserBoardPage(1);
        router.replace({ name: 'public' });
      });
  } else {
    console.log(useMember.user.userId);
    console.log(inputTitle.value);
    console.log(inputContent.value);
    axios
      .post(`${import.meta.env.VITE_URL}notice/write`, {
        userId: useMember.user.userId,
        noticeTitle: inputTitle.value,
        content: inputContent.value,
      })
      .then((response) => {
        alert('글이 성공적으로 작성됐습니다.');
        useBoard.loadNotice();
        useBoard.loadNoticePage(1);
        router.replace({ name: 'notice' });
      })
      .catch((error) => console.log(error));
  }
};
const goList = () => {
  if (useBoard.boardType == 0) {
    router.replace({ name: 'public' });
  } else {
    router.replace({ name: 'notice' });
  }
};
</script>
<template>
  <div>
    <div class="writeTop">
      <div class="writeHeader">글쓰기</div>
      <div class="writeBtn">
        <div class="resetBtn" @click="reset">초기화</div>
        <div class="submitBtn" @click="submit">등록</div>
        <div class="listBtn" @click="goList">목록</div>
      </div>
    </div>
    <div class="writeContainer">
      <div class="writeTitleWrapper">
        <input
          placeholder="제목을 입력해주세요."
          type="text"
          class="writeTitle"
          v-model="inputTitle"
        />
      </div>
      <div class="writeContentWrapper">
        <textarea
          class="writeContent"
          placeholder="내용을 입력해주세요."
          v-model="inputContent"
        ></textarea>
      </div>
    </div>
  </div>
</template>

<style scoped>
.writeTop {
  display: flex;
  align-items: center;
  border-bottom: 1px solid black;
  padding-bottom: 20px;
  box-sizing: border-box;
  justify-content: space-between;
  margin-bottom: 20px;
}
.writeHeader {
  font-size: 27px;
  font-weight: 600;
}
.writeBtn {
  display: flex;
  div {
    font-size: 15px;
    font-weight: 700;
    padding: 10px;
    box-sizing: border-box;
    border-radius: 8px;
    cursor: pointer;
  }
}
.resetBtn {
  color: white;
  background-color: rgb(255, 60, 49);
  margin-right: 10px;
}
.submitBtn {
  color: rgb(10, 160, 73);
  background-color: rgb(232, 249, 236);
  margin-right: 10px;
}
.listBtn {
  background-color: rgb(239, 240, 242);
}
.writeContainer {
  box-sizing: border-box;
  padding: 20px;
  border: 1px solid lightgray;
  border-radius: 10px;
}

.writeTitleWrapper {
  background-color: rgb(245, 246, 248);
  border: 1px solid none;
  height: 40px;
  padding: 10px;
  box-sizing: border-box;
  border-radius: 10px;
  margin-bottom: 20px;
  margin-top: 20px;
}
.writeTitle {
  background-color: rgb(245, 246, 248);
  outline: none;
  border: none;
  font-size: 16px;
  width: 100%;
}
.writeContentWrapper {
  background-color: rgb(245, 246, 248);
  border: 1px solid none;
  height: 400px;
  padding: 10px;
  box-sizing: border-box;
  border-radius: 10px;
  margin-bottom: 20px;
}
.writeContent {
  background-color: rgb(245, 246, 248);
  outline: none;
  border: none;
  font-size: 15px;
  width: 100%;
  resize: none;
  height: 100%;
}
</style>
