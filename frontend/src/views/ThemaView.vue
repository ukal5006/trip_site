<script setup>
import ThemaComponent from '@/components/ThemaComponent.vue';
import { useSettingStore } from '@/stores/setting';

const setting = useSettingStore();
setting.changeBoxColor('rgb(255,247,235)');

const themas = [
  {
    name: 'agecheck',
    title: '함께 떠나는 우리술 여행',
    content1: '전국에 있는 양조장에 방문하여 우리술을 직접 만들어보고',
    content2: '다양한 체험 프로그램을 경험해 보세요.',
    img: 'https://img.maisonkorea.com/2023/06/msk_6490195606b54.jpg',
  },
  {
    name: 'festival',
    title: '전국 방방곡곡에서 열리는 축제 여행',
    content1: '전국의 다채로운 축제와 함께',
    content2: '행복하고 즐거운 여행 되세요!',
    img: 'https://cdn.hankyung.com/photo/202310/AA.34726185.1.jpg',
  },
  // {
  //     name: "eat",
  //     title: "미각과 발길을 사로잡는 맛집 탐방",
  //     content1: "전국 각지의 맛집을 방문하여, 각 지역의 대표 음식과",
  //     content2: "매력적인 음식의 맛과 향이 가득한 여행에 여러분을 초대합니다.",
  //     img: "https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/3rWZ/image/rXpMIl8sMxtoBzR1PL6OHK1KxLw.jpg",
  // },
];
</script>

<template>
  <div class="themaContainer">
    <h1 class="themaViewTitle">다채로운 즐거움이 가득한</h1>
    <h1 class="themaViewTitle">테마가 있는 여행을 즐겨보세요.</h1>
    <ThemaComponent v-for="thema in themas" :key="thema.name" :thema="thema" />
  </div>
</template>

<style scoped>
.themaContainer {
  padding: 10px 0px;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
}

.themaViewTitle {
  font-size: 30px;
  font-weight: 600;
}
</style>
