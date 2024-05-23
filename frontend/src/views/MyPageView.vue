<script setup>
import { useMemberStore } from '@/stores/member';
import { useBoardStore } from '@/stores/board';
import { RouterView } from 'vue-router';

const userInfo = useMemberStore().user;
const useBoard = useBoardStore();

//수정, 탈퇴
</script>

<template>
  <div class="mypageContainer">
    <div class="mypageTitle">마이 페이지</div>
    <div class="basicInfo">
      <div class="infoTitle">기본 정보</div>
      <div class="userId">
        <div class="title">아이디</div>
        <div>{{ userInfo.userId }}</div>
      </div>
      <div class="userName">
        <div class="title">이름</div>
        <div>{{ userInfo.userName }}</div>
      </div>
      <div class="birth">
        <div class="title">생일</div>
        <div>{{ useBoard.formatDate(userInfo.birth) }}</div>
      </div>
      <div class="admin" v-if="userInfo?.admin == 1">
        <div>해당 유저는 관리자입니다.</div>
      </div>
      <!-- <div>
        <div class="title"></div>
        비밀번호 : {{ userInfo.userPwd }}
      </div> -->
    </div>
    <div class="contactInfo">
      <div class="infoTitle">연락처 정보</div>
      <div class="userEmail">
        <div class="title">이메일</div>
        <div>{{ userInfo.userEmail }}</div>
      </div>
      <div class="userPhone">
        <div class="title">휴대전화</div>
        <div>{{ userInfo.userPhone }}</div>
      </div>
    </div>
    <div class="btnContainer">
      <div class="update">수정</div>
      <div class="delete">삭제</div>
    </div>
  </div>
</template>

<style scoped>
.mypageContainer {
  display: flex;
  flex-direction: column;
  width: 600px;
}
.mypageTitle {
  display: flex;
  justify-content: center;
  font-size: 40px;
}
.basicInfo,
.contactInfo {
  border: 1px solid lightgray;
  box-sizing: border-box;
  padding: 30px;
  border-radius: 20px;
  margin-top: 20px;
}
.infoTitle {
  font-size: 25px;
  margin-bottom: 20px;
}
.userId,
.userName,
.birth,
.userEmail,
.userPhone,
.admin {
  display: flex;
  box-sizing: border-box;
  padding: 10px 15px;
  border-bottom: 1px solid gray;
}
.title {
  display: flex;
  align-items: center;
  width: 190px;
  font-size: 14px;
  color: gray;
}
.title + div {
  display: flex;
  align-items: center;
  font-size: 20px;
}
.btnContainer {
  margin-top: 10px;
  display: flex;
  margin-bottom: 20px;
  justify-content: flex-end;
  font-size: 20px;
  border: none;
  div {
    padding: 10px;
    border-radius: 10px;
    color: white;
    cursor: pointer;
  }
}
.update {
  background-color: rgb(10, 160, 73);
  margin-right: 20px;
}
.delete {
  background-color: tomato;
}
.admin {
  display: flex;
  justify-content: center;
  color: tomato;
}
</style>
