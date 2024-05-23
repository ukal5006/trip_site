<script setup>
import axios from 'axios';
import { onMounted, onUnmounted, ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
function formatDate(input) {
  // 입력 문자열을 Date 객체로 변환
  const date = new Date(input);

  // 현재 날짜
  const now = new Date();

  // 오늘인지 확인 (연, 월, 일이 모두 같은지 확인)
  const isToday =
    date.getUTCFullYear() === now.getUTCFullYear() &&
    date.getUTCMonth() === now.getUTCMonth() &&
    date.getUTCDate() === now.getUTCDate();

  const year = date.getUTCFullYear();
  const month = String(date.getUTCMonth() + 1).padStart(2, '0'); // 월은 0부터 시작하므로 +1 필요
  const day = String(date.getUTCDate()).padStart(2, '0');
  return `${year}.${month}.${day}`;
}
const data = ref([]);
const URL = import.meta.env.VITE_URL;
let start = 1;
let end = 8;
console.log(`${URL}festival/inRange?startIdx=${start}&endIdx=${end}`);
const loadData = () => {
  axios
    .get(`${URL}festival/inRange?startIdx=${start}&endIdx=${end}`)
    .then((response) => {
      data.value.push(...response.data);
    });
};
loadData();

const handleScroll = () => {
  // window.scrollY: 스크롤된 수직 거리
  // document.documentElement.clientHeight: 뷰포트의 높이
  // document.documentElement.scrollHeight: 문서의 전체 높이
  if (
    window.scrollY + document.documentElement.clientHeight >=
    document.documentElement.scrollHeight
  ) {
    start = end + 1;
    end += 4;
    loadData();
  }
};

onMounted(() => {
  // 컴포넌트가 마운트 되었을 때 스크롤 이벤트 리스너 추가
  window.addEventListener('scroll', handleScroll);
});

onUnmounted(() => {
  // 컴포넌트가 언마운트 될 때 스크롤 이벤트 리스너 제거
  window.removeEventListener('scroll', handleScroll);
});

const clickHandler = (link) => {
  window.open(link, '_blank');
};
</script>

<template>
  <div class="festivalContainer">
    <div
      class="festivalItem"
      v-for="item in data"
      @click="clickHandler(item.homePage)"
    >
      <div class="festivalImage">
        <img
          :src="
            item.imgUrl == ''
              ? 'https://koueitrading.com/global/wp-content/uploads/2020/10/noimg-575x380.png'
              : item.imgUrl
          "
        />
      </div>
      <div class="festivalInfo">
        <div class="festivalTitle">{{ item.title }}</div>
        <div class="festivalDate">
          {{ formatDate(item.startDate) }} ~
          {{ formatDate(item.endDate) }}
        </div>
        <div class="festivalPlace">{{ item.institution }}</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.festivalContainer {
  padding: 20px;
  box-sizing: border-box;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}
.festivalItem {
  width: 430px;
  height: 570px;
  margin: 10px;
  padding: 20px;
  box-sizing: border-box;
  border: 1px solid lightgray;
  border-radius: 20px;
  background-color: whitesmoke;
  cursor: pointer;
}
.festivalImage {
  img {
    width: 390px;
    height: 400px;
    background-color: white;
  }
}
.festivalInfo {
  margin-top: 20px;
  box-sizing: border-box;
  border: 1px solid lightgray;
  padding: 10px;
  background-color: white;
}
.festivalTitle {
  font-size: 20px;
  font-weight: 700;
  margin-bottom: 10px;
}
.festivalDate {
  font-size: 18px;
  margin-bottom: 10px;
}
.festivalPlace {
  font-size: 18px;
  color: gray;
  max-width: 390px;
  overflow: hidden;
  text-wrap: nowrap;
  text-overflow: ellipsis;
}
</style>
