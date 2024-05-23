<script setup>
import { useMemberStore } from '@/stores/member';
import { useRouter } from 'vue-router';

function isOver19(birthdayString) {
  // 생년을 문자열에서 추출
  const birthYear = parseInt(birthdayString.substring(0, 4), 10);
  // 현재 연도 가져오기
  const currentYear = new Date().getFullYear();

  // 나이 계산
  const age = currentYear - birthYear;

  // 19세 이상인지 확인
  return age >= 19;
}

const useMember = useMemberStore();
const router = useRouter();
const goIn = () => {
  router.replace({ name: 'brewery' });
};
const goOut = () => {
  router.replace({ name: 'thema' });
};

if (useMember.user != null) {
  if (isOver19(useMember.user.birth)) {
    goIn();
  }
}
</script>

<template>
  <div class="ageCheckContainer">
    <div class="ageMarkWrapper">
      <div class="ageMark">19</div>
    </div>
    <div class="ageContentContainer">
      <div class="ageContent">
        저희 여행가려행은 올바른 음주문화를 지향합니다.
        <br />모든 방문객이 안전하고 즐거운 여행을 할 수 있도록, 특히 청소년
        여러분이 건강하고 올바른 음주 문화를 이해하고 실천할 수 있도록
        격려하고자 합니다. <br />현재의 작은 결정이 미래의 큰 변화를 가져올 수
        있습니다.
      </div>
      <div class="btnContainer">
        <div class="goIn" @click="goIn">양조장 보러가기</div>
        <div class="goOut" @click="goOut">19세 미만 나가기</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.ageCheckContainer {
  width: 100vw;
  /* height: 100vh; */
  display: flex;
  flex-direction: column;
  align-items: center;
}
.ageMarkWrapper {
  background-color: tomato;
  width: 500px;
  height: 500px;
  display: flex;
  justify-content: center;
  align-items: center;
  box-sizing: border-box;
  padding: 40px;
  border-radius: 50%;
}
.ageMark {
  width: 500px;
  height: 100%;
  background-color: white;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 350px;
  box-sizing: border-box;
  padding-top: 30px;
}
.ageContentContainer {
  margin-top: 20px;
  width: 500px;
  height: 300px;
  background-color: whitesmoke;
  box-sizing: border-box;
  padding: 20px;
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.btnContainer {
  div {
    padding: 10px;
    text-align: center;
    font-size: 40px;
    border-radius: 10px;
    cursor: pointer;
    color: black;
    font-weight: 700;
    text-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white;
  }
}
.goIn {
  background-color: rgb(10, 160, 73);
  margin-bottom: 10px;
}
.goOut {
  background-color: tomato;
}
.ageContent {
  font-size: 20px;
}
</style>
