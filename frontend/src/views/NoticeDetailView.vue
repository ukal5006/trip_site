<script setup>
import { useBoardStore } from '@/stores/board.js';
import { useRoute, useRouter } from 'vue-router';
import { computed, onMounted, ref, watch } from 'vue';
import { useMemberStore } from '@/stores/member';
import axios from 'axios';
const useMember = useMemberStore();
const useBoard = useBoardStore();
const route = useRoute();
const router = useRouter();
let boardId = route.params.boardId;
const notice = ref();

useBoard.loadNoticeOne(boardId);

const commentInput = ref('');
const commentLength = computed(() => commentInput.value.length);
const commentSubmit = () => {
  console.log(commentInput.value);
};

const preBoard = ref();
const postBoard = ref();

notice.value = useBoard.findNoticeByIndex(boardId);
preBoard.value = useBoard.findPreNotice(boardId);
postBoard.value = useBoard.findPostNotice(boardId);
onMounted(async () => {
  // console.log('마운트됨');
  notice.value = await useBoard.findNoticeByIndex(boardId);
  preBoard.value = await useBoard.findPreNotice(boardId);
  postBoard.value = await useBoard.findPostNotice(boardId);

  watch(
    () => route.params.boardId,
    async (newBoardId) => {
      notice.value = await useBoard.findNoticeByIndex(newBoardId);
      preBoard.value = await useBoard.findPreNotice(newBoardId);
      postBoard.value = await useBoard.findPostNotice(newBoardId);
      // console.log('노티스 바뀜...');
    }
  );
});

const goNoticeList = () => {
  router.push({ name: 'notice' });
};

const goPre = async () => {
  await router.push({
    name: 'noticeDetail',
    params: { boardId: preBoard.value.noticeId },
  });

  // 라우터 이동 후 데이터 업데이트
  notice.value = await useBoard.findNoticeByIndex(preBoard.value.noticeId);
  preBoard.value = await useBoard.findPreNotice(preBoard.value.noticeId);
  postBoard.value = await useBoard.findPostNotice(preBoard.value.noticeId);
};

const goPost = async () => {
  await router.push({
    name: 'noticeDetail',
    params: { boardId: postBoard.value.noticeId },
  });

  // 라우터 이동 후 데이터 업데이트
  notice.value = await useBoard.findNoticeByIndex(postBoard.value.noticeId);
  preBoard.value = await useBoard.findPreNotice(postBoard.value.noticeId);
  postBoard.value = await useBoard.findPostNotice(postBoard.value.noticeId);
};

const writeNotice = () => {
  useBoard.setBoardNotice();
  router.push({ name: 'write' });
};

const deleteNotice = () => {
  // console.log(notice?.value?.userId);
  // console.log(notice?.value);
  axios
    .delete(`${import.meta.env.VITE_URL}notice/delete`, {
      data: {
        content: notice?.value.content,
        noticeId: notice?.value.noticeId,
        noticeTitle: notice?.value.noticeTitle,
        userId: notice?.value.userId,
      },
    })
    .then((response) => {
      useBoard.loadNoticePage(1);
      alert('성공적으로 삭제됐습니다.');
      router.replace({ name: 'notice' });
    });
};
</script>

<template>
  <div class="detailContainer">
    <div class="contentCotainer">
      <div class="title">{{ notice?.noticeTitle }}</div>
      <div class="contentTop">
        <div class="writeInfo">
          <div class="writer">{{ notice?.userId }}</div>
          <div class="boardInfo">
            <div class="writeDate">
              {{ useBoard.formatDateHour(notice?.writeDate) }}
            </div>
            <div class="readCount">조회 {{ notice?.readCount }}</div>
          </div>
        </div>
        <div class="commentCount">댓글 0</div>
      </div>

      <div class="content">{{ notice?.content }}</div>
      <!-- <div class="userSearch">{{  }}님의 게시글 더보기</div> -->
    </div>
    <!--  -->
    <div class="btnContainer">
      <div
        v-if="useMember.user?.admin == 1"
        class="writeBtn"
        @click="writeNotice"
      >
        글쓰기
      </div>
      <div
        v-if="useMember.user?.userId == notice?.userId"
        class="updateBtn"
        @click="writeNotice"
      >
        수정
      </div>
      <div
        v-if="useMember.user?.userId == notice?.userId"
        class="deleteBtn"
        @click="deleteNotice"
      >
        삭제
      </div>
      <div class="listBtn" @click="goNoticeList">목록</div>
    </div>
    <!--  -->
    <div class="aroundContainer">
      <div class="aroundTitle">공지사항 다른 글</div>
      <div class="preBoard aroundBoard" v-if="preBoard != null" @click="goPre">
        <div class="aroundContentTitle">{{ preBoard?.noticeTitle }}</div>
        <div class="aroundContentWriter">{{ preBoard?.userId }}</div>
        <div class="aroundContentWriteDate">
          {{ useBoard.formatDate(preBoard?.writeDate) }}
        </div>
      </div>
      <div class="nowBoard aroundBoard">
        <div class="aroundContentTitle">
          {{ notice?.noticeTitle }}
        </div>
        <div class="aroundContentWriter">{{ notice?.userId }}</div>
        <div class="aroundContentWriteDate">
          {{ useBoard.formatDate(notice?.writeDate) }}
        </div>
      </div>
      <div
        class="postBoard aroundBoard"
        v-if="postBoard != null"
        @click="goPost"
      >
        <div class="aroundContentTitle">{{ postBoard?.noticeTitle }}</div>
        <div class="aroundContentWriter">{{ postBoard?.userId }}</div>
        <div class="aroundContentWriteDate">
          {{ useBoard.formatDate(postBoard?.writeDate) }}
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
    cursor: pointer;
    margin-left: 10px;
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
/* 55 20 15 10 */
</style>
