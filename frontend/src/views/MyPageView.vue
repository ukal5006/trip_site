<script setup>
import { useMemberStore } from '@/stores/member';
import { RouterView } from 'vue-router';

const userInfo = useMemberStore().user;

const userInfoList = [
  { title: '아이디', value: userInfo.userId },
  { title: '이름', value: userInfo.userName },
];
//수정, 탈퇴
</script>

<template>
  <div class="mypageContainer">
    <h1 class="mypageTitle">마이 페이지</h1>
    <div class="infoContainer">
      <div class="item" v-for="item in userInfoList">
        <span> {{ item.title }}</span>
        <input type="text" v-model="item.value" />
      </div>
    </div>
    <!-- <div class="btnContainer">
      <div class="update">수정하기</div>
      <div class="reset">되돌리기</div>
    </div> -->
  </div>
</template>

<style scoped>
.mypageContainer {
  display: flex;
  flex-direction: column;
  height: 1000px;
}

.mypageTitle {
  font-size: 40px;
  text-align: center;
  margin-bottom: 20px;
}

.btnContainer {
  display: flex;
  justify-content: space-around;
  div {
    width: 70px;
    height: 20px;
    padding: 15px 10px;
    color: white;
    font-size: 20px;
    cursor: pointer;
    border-radius: 10px;
  }
}
.update {
  background-color: rgb(39, 168, 69);
}
.reset {
  background-color: rgb(219, 53, 68);
}
</style>
