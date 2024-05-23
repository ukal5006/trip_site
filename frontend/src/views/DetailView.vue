<script setup>
import axios from 'axios';
import { computed, ref } from 'vue';
import { useRoute } from 'vue-router';
import { useBoardStore } from '@/stores/board.js';
import { useMemberStore } from '@/stores/member.js';

const useBoard = useBoardStore();
const route = useRoute();
const contentId = route.params.contentId;
const data = ref();
const useMember = useMemberStore();
// const data = ref({
//   title: '제목',
//   readCount: 10,
//   overview: '설명',
// });
// const URL = 'http://192.168.10.93:9999/attraction/list/'
const URL = `${import.meta.env.VITE_URL}attraction/list/`;
axios
  .get(`${URL}${contentId}`)
  .then((response) => (data.value = response.data[0]));
const reviewData = ref();
// const reviewData = ref([
//   {
//     content: '리뷰내용1',
//     userId: '글쓴이',
//     rate: 5,
//     writeDate: '2024.05.23',
//   },
//   {
//     content: '리뷰내용2',
//     userId: '글쓴이',
//     rate: 3,
//     writeDate: '2024.05.23',
//   },
// ]);
const reviewURL = `${import.meta.env.VITE_URL}review?contentId=`;
axios
  .get(`${reviewURL}${contentId}`)
  // .then((response) => console.log(response));
  .then((response) => (reviewData.value = response.data));
const reviewCount = computed(() => {
  if (reviewData.value != null) {
    return reviewData.value.length;
  } else {
    return 0;
  }
});
const reviewInput = ref('');
const reviewLength = computed(() => {
  return reviewInput.value.length;
});

const reviewWrite = () => {
  if (useMember.user == null) {
    alert('리뷰는 로그인을 해야 남길 수 있습니다.');
    return;
  }
  console.log(`${import.meta.env.VITE_URL}review/write`);
  console.log(contentId);
  console.log(useMember.user.userId);
  console.log(reviewInput.value);
  axios
    .post(`${import.meta.env.VITE_URL}review/write`, {
      contentId: contentId,
      userId: useMember.user.userId,
      rate: 5,
      content: reviewInput.value,
    })
    // .then((response) => console.log(response));
    .then((response) => {
      reviewInput.value = '';
      axios
        .get(`${reviewURL}${contentId}`)
        // .then((response) => console.log(response));
        .then((response) => (reviewData.value = response.data));
    })
    .catch((error) => console.log(error));
};
</script>

<template>
  <div class="detailContainer">
    <div class="contentCotainer">
      <div class="title">{{ data?.title }}</div>
      <div class="contentTop">
        <div class="writeInfo">
          <div class="boardInfo">
            <div class="readCount">조회 {{ data?.readCount }}</div>
          </div>
        </div>
        <div class="commentCount">리뷰 {{ reviewCount }}</div>
      </div>

      <div class="content">
        <div class="image">
          <img :src="data?.firstImage" alt="" />
        </div>
        <div class="overview">{{ data?.overview }}</div>
      </div>
    </div>
    <!--  -->
    <div class="commentCount">리뷰{{ reviewCount }}</div>
    <div class="commentContainer">
      <div class="commentTitle">리뷰</div>
      <div class="commentList">
        <div class="commentItem" v-for="item in reviewData">
          <div class="commentBtn" v-if="item.userId == useMember?.user?.userId">
            <div
              v-if="item.userId == useMember?.user?.userId"
              class="commentUpdate"
            >
              수정
            </div>
            <div
              v-if="item.userId == useMember?.user?.userId"
              class="commentDelete"
              @click="commentDelete(item)"
            >
              삭제
            </div>
          </div>
          <div class="commentUserId">{{ item.userId }}</div>
          <input
            class="commentContent"
            v-model="item.content"
            :disabled="editing"
          />
          <div class="commentRate">{{ item.rate }}점</div>
          <div class="commentDate">
            {{ useBoard.formatDateHour(item.writeDate) }}
          </div>
        </div>
      </div>
      <div class="commentInputContainer">
        <div class="userName" v-if="useMember?.user != null">
          {{ useMember.user?.userId }}
        </div>
        <div class="userName" v-else></div>
        <textarea
          class="commentInput"
          placeholder="리뷰를 남겨보세요"
          v-model="reviewInput"
        ></textarea>
        <div class="inputLength">
          {{ commentLength == 0 ? null : `${reviewLength}/300` }}
        </div>
        <div
          class="submitBtn"
          @click="reviewWrite"
          :class="{
            active: commentLength > 0 ? true : false,
          }"
        >
          등록
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.detailContainer {
  width: 1000px;
  padding: 20px;
  box-sizing: border-box;
  border: 1px solid lightgray;
  border-radius: 5px;
}
.title {
  font-size: 30px;
  margin-bottom: 10px;
}
.contentTop {
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 13px;
}
.writer {
  font-weight: 700;
  margin-bottom: 10px;
}
.boardInfo {
  display: flex;
  color: gray;
}
.writeDate {
  margin-right: 10px;
}
.content {
  margin-top: 20px;
  border-top: 1px solid lightgray;
  padding-top: 20px;
  box-sizing: border-box;
  padding-bottom: 20px;
  margin-bottom: 20px;
  border-bottom: 1px solid lightgray;
}
.commentCount {
  font-size: 13px;
  margin-bottom: 20px;
}
.commentTitle {
  font-size: 18px;
  font-weight: 700;
  margin-bottom: 10px;
}
.commentItem {
  margin-bottom: 10px;
  border-bottom: 1px solid lightgray;
  position: relative;
  * {
    margin-bottom: 5px;
  }
}
.commentUserId {
  font-size: 14px;
  font-weight: 700;
}
.commentContent {
  font-size: 15px;
  outline: none;
  border: none;
  width: 800px;
  background-color: white;
}
.commentDate {
  color: gray;
  font-size: 13px;
}
.commentInputContainer {
  position: relative;
  border: 2px solid lightgray;
  border-radius: 5px;
  box-sizing: border-box;
  padding: 10px;
}
.userName {
  font-size: 14px;
  font-weight: 700;
  margin-bottom: 10px;
}
.commentInput {
  width: 100%;
  /* max-height: 200px; */
  outline: none;
  border: none;
  resize: none;
}
.inputLength {
  position: absolute;
  top: 10px;
  right: 10px;
  font-size: 13px;
  color: gray;
}
.submitBtn {
  position: absolute;
  bottom: 10px;
  right: 10px;
  color: gray;
  padding: 10px;
  font-size: 14px;
  font-weight: 600;
  border-radius: 9px;
  cursor: pointer;
}
.btnContainer {
  display: flex;
  justify-content: end;
  font-size: 14px;
  font-weight: 700;
  margin-top: 10px;
  div {
    box-sizing: border-box;
    padding: 10px;
    border-radius: 7px;
    margin-left: 10px;
    cursor: pointer;
  }
}
.writeBtn {
  color: rgb(27, 163, 78);
  background-color: rgb(232, 249, 236);
}
.updateBtn {
  background-color: #1685f2;
  color: white;
}
.deleteBtn {
  background-color: rgb(255, 60, 49);
  color: white;
}
.listBtn {
  background-color: rgb(239, 240, 242);
}
.aroundContainer {
  margin-top: 20px;
  box-sizing: border-box;
  padding: 10px;
}
.aroundTitle {
  font-size: 17px;
  font-weight: 700;
  margin-bottom: 10px;
}
.aroundBoard {
  display: flex;
  font-size: 14px;
  height: 40px;
  align-items: center;
  box-sizing: border-box;
  padding: 10px;
}
.aroundContentTitle {
  width: 75%;
}
.aroundContentWriter {
  width: 15%;
  color: #676767;
}
.aroundContentWriteDate {
  width: 10%;
  color: #676767;
  text-align: end;
}
.nowBoard {
  border-top: 1px solid lightgray;
  border-bottom: 1px solid lightgray;
  background-color: rgb(249, 249, 250);
  font-weight: 700;
}
.active {
  color: rgb(27, 163, 78);
  background-color: rgb(232, 249, 236);
}
.postBoard,
.preBoard {
  cursor: pointer;
}
.commentBtn {
  /* width: 80px; */
  /* height: 50px; */
  right: 0px;
  bottom: 0px;
  position: absolute;
  display: flex;
  align-items: center;
  div {
    padding: 5px;
    margin-bottom: 0px;
    border-radius: 8px;
    font-size: 13px;
    cursor: pointer;
    color: white;
  }
}
.commentUpdate {
  margin-right: 5px;
  background-color: #1685f2;
}
.commentDelete {
  background-color: rgb(255, 60, 49);
}
.noEdit {
}
.image {
  display: flex;
  justify-content: center;
  img {
  }
  margin-bottom: 20px;
}
.overview {
  font-size: 20px;
}
/* 55 20 15 10 */
</style>
