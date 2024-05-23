<script setup></script>

<template>
  <div class="detailContainer">
    <div class="contentTop">
      <!-- {{ data }} -->
      <div class="contentId">{{ 'No. ' + data?.contentId }}</div>
      <div class="contentView">조회수 : {{ data?.readCount + '회' }}</div>
    </div>
    <div class="contentMid">
      <div class="contentTitle">제목 : {{ data?.title }}</div>
      <div class="contentAddr">주소: {{ data?.addr1 }}</div>
      <div class="contentImage">
        <img
          class="img"
          :src="
            data?.firstImage == ''
              ? 'https://koueitrading.com/global/wp-content/uploads/2020/10/noimg-575x380.png'
              : data?.firstImage
          "
          alt=""
          decoding="async"
        />
      </div>
      <div class="contentOverview">{{ data?.overview }}</div>
    </div>
    <div class="contentBot">
      <div class="reviewItem" v-for="item in reviewData">
        <div class="userId">유저 아이디 : {{ item.userId }}</div>
        <div class="rate">유저 평점 : {{ item.rate }}</div>
        <div class="content">리뷰 내용 : {{ item.content }}</div>
        <div class="good">좋아요 : {{ item.good }}</div>
        <div class="bad">싫어요 : {{ item.bad }}</div>
        <div class="writeDate">작성 일자 : {{ item.writeDate }}</div>
        <div class="updateDate">수정 날짜 : {{ item.updateDate }}</div>
      </div>
    </div>
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
  width: 1000px;
  /* height: 700px; */
  margin-bottom: 10px;
  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    content-visibility: auto;
  }
}
</style>
