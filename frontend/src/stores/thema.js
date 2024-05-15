// import { ref } from "vue";
import { defineStore } from 'pinia';

export const useThemaStore = defineStore('themas', () => {
  const themas = [
    {
      name: 'brewery',
      title: '함께 떠나는 우리술 여행',
      content1: '전국에 있는 양조장에 방문하여 우리술을 직접 만들어보고',
      content2: '다양한 체험 프로그램을 경험해 보세요.',
      img: 'https://img.maisonkorea.com/2023/06/msk_6490195606b54.jpg',
    },
    {
      name: 'mountain',
      title: '자연과 하나되는 순수한 기쁨, 산 여행',
      content1: '우리나라 곳곳에 자리한 아름다운 산들을 탐방하며',
      content2: '몸과 마음의 건강을 동시에 챙겨보세요.',
      img: 'https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/202111/04/480408b2-383a-4b04-92c8-6f737e8d60f4.jpg',
    },
    {
      name: 'eat',
      title: '미각과 발길을 사로잡는 맛집 탐방',
      content1: '전국 각지의 맛집을 방문하여, 각 지역의 대표 음식과',
      content2: '매력적인 음식의 맛과 향이 가득한 여행에 여러분을 초대합니다.',
      img: 'https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/3rWZ/image/rXpMIl8sMxtoBzR1PL6OHK1KxLw.jpg',
    },
  ];
  return { themas };
});
