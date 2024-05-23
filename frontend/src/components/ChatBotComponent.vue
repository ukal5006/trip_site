<script setup>
import axios from 'axios';
import { computed, ref } from 'vue';
import DotComponent from './DotComponent.vue';

const show = ref(false);
const userInput = ref('');
const inputLength = computed(() => userInput.value.length);
const userTextList = ref([]);
const AITextList = ref([]);

const nl2br = (str) => {
  return str.replace(/\n/g, '<br>');
};

const submit = () => {
  axios
    .get(`${import.meta.env.VITE_URL}bot/chat?prompt=${userInput.value}`)
    // .then((response) => AITextList.value.push(response.data));
    .then((response) => AITextList.value.push(nl2br(response.data)));
};

function handleKey(event) {
  // 유저가 엔터를 눌렀지만 쉬프트 키는 누르지 않았을 경우
  if (event.key === 'Enter' && !event.shiftKey) {
    event.preventDefault(); // 기본 동작인 줄바꿈을 방지
    userTextList.value.push(nl2br(userInput.value));
    submit();
    userInput.value = '';
  }
  // 쉬프트 + 엔터의 경우 기본적으로 줄바꿈이 실행됩니다.
}
const clickHandler = () => {
  show.value = !show.value;
};
</script>

<template>
  <div class="chatBotContainer">
    <div class="chatBotIcon" :class="{ off: show }" @click="clickHandler">
      AI
    </div>
    <div class="chatBotPop" :class="{ off: !show }">
      <div class="chatBotTop">
        <div class="closeBtn" @click="clickHandler">x</div>
      </div>
      <div class="chatContent">
        <div class="chatPart" v-for="(item, index) in userTextList">
          <div class="userTextList" v-html="item" />
          <div class="AITextList" :class="{ loading: !AITextList[index] }">
            <div class="loading" v-if="AITextList[index] == undefined">
              <DotComponent />
            </div>
            <template v-else>
              <div v-html="AITextList[index]"></div>
            </template>
          </div>
        </div>
      </div>
      <div class="chatInputWrapper">
        <textarea
          class="chatInput"
          maxlength="300"
          v-model="userInput"
          @keypress="handleKey"
        ></textarea>
        <div class="chatMax">({{ inputLength }}/300)</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.chatBotContainer {
}
.chatBotIcon {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 60px;
  cursor: pointer;
  width: 100px;
  height: 100px;
  background-color: rgb(255, 229, 150);
  color: rgb(73, 118, 123);
  border-radius: 50px;
  transition: transform 0.3s; /* 기본 상태에서도 트랜지션 설정 */
  &:hover {
    transform: scale(1.2);
  }
}
.chatBotPop {
  width: 400px;
  height: 720px;
  background-color: rgba(0, 0, 0, 0.5);
  border-radius: 10px;
  padding: 20px;
  box-sizing: border-box;
  position: relative;
}
.chatBotTop {
  /* background-color: black; */
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: flex-end;
  box-sizing: border-box;
  padding: 10px;
  border-radius: 10px;
}
.closeBtn {
  width: 15px;
  height: 15px;
  background-color: tomato;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 14px;
  color: tomato;
  cursor: pointer;
  &:hover {
    color: gray;
  }
}
.chatContent {
  margin-top: 20px;
  width: 360px;
  height: 480px;
  box-sizing: border-box;
  padding: 10px;
  overflow-y: scroll;
  /* border: 1px solid black; */
  /* border-radius: 10px; */
}
.chatPart {
  display: flex;
  flex-direction: column;
  div {
    border-radius: 7px;
  }
}
.userTextList {
  align-self: flex-end;
  background-color: #ffd630;
  padding: 5px 10px;
  margin-bottom: 10px;
}
.AITextList {
  display: flex;
  align-self: flex-start;
  background-color: whitesmoke;
  padding: 5px 10px;
  margin-bottom: 10px;
}
.chatInputWrapper {
  margin-top: 20px;
  width: 360px;
  height: 140px;
  background-color: whitesmoke;
  border-radius: 10px;
}
.chatInput {
  padding: 10px;
  box-sizing: border-box;
  border: none;
  width: 360px;
  height: 120px;
  background-color: rgba(0, 0, 0, 0);
  outline: none;
  resize: none;
}
.chatMax {
  display: flex;
  justify-content: flex-end;
  font-size: 14px;
  padding-right: 10px;
}
.off {
  display: none;
}
.loading {
  box-sizing: border-box;
  padding-left: 10px;
  padding-top: 5px;
  width: 45px;
  height: 25px;
}
</style>
