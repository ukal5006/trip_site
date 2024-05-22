<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();
const contentId = route.params.contentId;
const data = ref();
const URL = 'http://192.168.10.93:9999/attraction/list/';
console.log(contentId);
axios
  .get(`${URL}${contentId}`)
  .then((response) => (data.value = response.data[0]));

const navigateToDetail = (id) => {
  window.open(`${window.location.origin}/detail/${id}`, '_blank');
};
</script>

<template>
  <div class="detailContainer">
    <div class="contentTop">
      <div class="contentId">{{ 'No. ' + data.contentId }}</div>
      <div class="contentView">조회수 : {{ data.readCount + '회' }}</div>
    </div>
    <div class="contentMid">
      <div class="contentTitle">제목 : {{ data.title }}</div>
      <div class="contentAddr">주소: {{ data.addr1 }}</div>
      <div class="contentImage">
        <img
          class="img"
          :src="
            data.firstImage == ''
              ? 'https://koueitrading.com/global/wp-content/uploads/2020/10/noimg-575x380.png'
              : data.firstImage
          "
          alt=""
          decoding="async"
        />
      </div>
      <div class="contentOverview">내용 : {{ data.overview }}</div>
    </div>
    <div class="contentBot">여기 뭘 넣어야할까?</div>
  </div>
</template>

<style scoped>
.detailContainer {
  padding: 20px;
  width: 900px;
  margin: 0px auto;
}
.contentTop {
  margin-bottom: 20px;
  display: flex;
  justify-content: space-between;
}
.contentMid {
  margin-bottom: 20px;
}
.contentTitle {
  margin-bottom: 10px;
  font-size: 25px;
}
.contentAddr {
  margin-bottom: 10px;
  font-size: 20px;
}
.contentImage {
  width: 500px;
  height: 700px;
  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    content-visibility: auto;
  }
}
</style>
