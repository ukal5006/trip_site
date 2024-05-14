<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useMemberStore } from '@/stores/member.js';

const title = ref('');
const content = ref('');
const id = useMemberStore().id;

const submit = () => {
  const url = 'http://192.168.10.93:9999/notice/write';
  const data = {
    title: title.value,
    content: content.value,
    id: id,
  };
  axios.post(url, { data });
};
</script>
<template>
  <div class="writeContainer">
    <div class="titleContainer">
      제목 : <input class="title" type="text" v-model="title" />
    </div>
    <div class="contentContainer">
      내용 : <textarea class="content" type="text" v-model="content" />
    </div>
    <div class="btnWapper">
      <button @click="submit">제출</button>
    </div>
  </div>
</template>

<style scoped>
.writeContainer {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.titleContainer {
  width: 300px;
  font-size: 30px;
  display: flex;
  align-items: center;
}
.title {
  width: 200px;
  height: 40px;
}
.contentContainer {
  width: 300px;
  height: 310px;
  display: flex;
  font-size: 30px;
}
.content {
  width: 200px;
  height: 300px;
}
</style>
