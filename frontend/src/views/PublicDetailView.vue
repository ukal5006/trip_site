<script setup>
import { useBoardStore } from '@/stores/board.js';
import { useRoute, useRouter } from 'vue-router';
import { computed, onMounted, ref, watch } from 'vue';
import { useMemberStore } from '@/stores/member';
import axios from 'axios';

const useBoard = useBoardStore();
const useMember = useMemberStore();
const route = useRoute();
const router = useRouter();
const boardId = route.params.boardId;
const userBoard = ref();
useBoard.loadPublicOne(boardId);
// 댓글
const comment = ref();
const commentCount = computed(() => {
  if (comment.value != null) {
    return comment.value.length;
  } else {
    return 0;
  }
});
const commentURL = `${import.meta.env.VITE_URL}comment?postId=`;
axios.get(`${commentURL}${boardId}`).then((response) => {
  comment.value = response.data;
});

const commentInput = ref('');
const commentLength = computed(() => commentInput.value.length);
const commentSubmit = () => {
  if (useMember.user == null) {
    alert('댓글은 로그인을 해야 남길 수 있습니다.');
  } else if (commentInput.value == '') {
    alert('댓글을 작성해 주세요.');
  } else {
    console.log(boardId);
    console.log(useMember.user.userId);
    console.log(commentInput.value);
    axios
      .post(`${import.meta.env.VITE_URL}comment/write`, {
        postId: boardId,
        userId: useMember.user.userId,
        comment: commentInput.value,
      })
      .then((response) => {
        alert('댓글 작성 완료!');
        commentInput.value = '';
        axios.get(`${commentURL}${boardId}`).then((response) => {
          comment.value = response.data;
        });
      })
      .catch((error) => console.log(error));
  }
  console.log(commentInput.value);
};

const preBoard = ref();
const postBoard = ref();
onMounted(() => {
  // console.log('마운트됨');
  userBoard.value = useBoard.findPublicByIndex(boardId);
  preBoard.value = useBoard.findPrePublic(boardId);
  postBoard.value = useBoard.findPostPublic(boardId);
});

const goPublicList = () => {
  router.push({ name: 'public' });
};

onMounted(async () => {
  // console.log('마운트됨');
  userBoard.value = await useBoard.findPublicByIndex(boardId);
  preBoard.value = await useBoard.findPrePublic(boardId);
  postBoard.value = await useBoard.findPostPublic(boardId);

  watch(
    () => route.params.boardId,
    async (newBoardId) => {
      userBoard.value = await useBoard.findPublicByIndex(newBoardId);
      preBoard.value = await useBoard.findPrePublic(newBoardId);
      postBoard.value = await useBoard.findPostPublic(newBoardId);
      axios.get(`${commentURL}${newBoardId}`).then((response) => {
        comment.value = response.data;
      });
    }
  );
});

const goPre = async () => {
  await router.push({
    name: 'publicDetail',
    params: { boardId: preBoard.value.noticeId },
  });

  // 라우터 이동 후 데이터 업데이트
  userBoard.value = await useBoard.findPublicByIndex(preBoard.value.postId);
  preBoard.value = await useBoard.findPrePublic(preBoard.value.postId);
  postBoard.value = await useBoard.findPostPublic(preBoard.value.postId);

  // 댓글 데이터를 갱신합니다.
  axios.get(`${commentURL}${preBoard.value.postId}`).then((response) => {
    comment.value = response.data;
  });
};

const goPost = async () => {
  await router.push({
    name: 'publicDetail',
    params: { boardId: postBoard.value.PublicId },
  });

  // 라우터 이동 후 데이터 업데이트
  userBoard.value = await useBoard.findPublicByIndex(postBoard.value.postId);
  preBoard.value = await useBoard.findPrePublic(postBoard.value.postId);
  postBoard.value = await useBoard.findPostPublic(postBoard.value.postId);

  // 댓글 데이터를 갱신합니다.
  axios.get(`${commentURL}${postBoard.value.postId}`).then((response) => {
    comment.value = response.data;
  });
};

const commentUpdate = () => {};
const commentDelete = (item) => {
  console.log(item.commentId);
  console.log(useMember.user.userId);
  axios
    .delete(`${import.meta.env.VITE_URL}comment/delete`, {
      data: {
        commentId: item.commentId,
        userId: useMember.user.userId,
      },
    })
    .then((response) => {
      // console.log(response);
      axios.get(`${commentURL}${boardId}`).then((response) => {
        comment.value = response.data;
      });
    })
    .catch((error) => {
      console.log(error);
    });
};
const writePublic = () => {
  useBoard.setBoardPublic();
  router.push({ name: 'write' });
};
const deletePublic = () => {
  // console.log(userBoard?.value?.userId);
  console.log(userBoard?.value);
  axios
    .delete(`${import.meta.env.VITE_URL}userBoard/delete`, {
      data: {
        postId: userBoard?.value.postId,
        userId: userBoard?.value.userId,
      },
    })
    .then((response) => {
      useBoard.loadUserBoardPage(1);
      useBoard.loadUserBoard();
      alert('성공적으로 삭제됐습니다.');
      router.replace({ name: 'public' });
    });
};
</script>

<template>
  <div class="detailContainer">
    <div class="contentCotainer">
      <div class="title">{{ userBoard?.title }}</div>
      <div class="contentTop">
        <div class="writeInfo">
          <div class="writer">{{ userBoard?.userId }}</div>
          <div class="boardInfo">
            <div class="writeDate">
              {{ useBoard.formatDateHour(userBoard?.writeDate) }}
            </div>
            <div class="readCount">조회 {{ userBoard?.readCount }}</div>
          </div>
        </div>
        <div class="commentCount">댓글{{ commentCount }}</div>
      </div>

      <div class="content">{{ userBoard?.content }}</div>
      <!-- <div class="userSearch">{{  }}님의 게시글 더보기</div> -->
      <div class="commentCount">댓글{{ commentCount }}</div>
      <div class="commentContainer">
        <div class="commentTitle">댓글</div>
        <div class="commentList">
          <div class="commentItem" v-for="item in comment">
            <div
              class="commentBtn"
              v-if="item.userId == useMember?.user?.userId"
            >
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
              v-model="item.comment"
              :disabled="editing"
            />
            <div class="commentDate">
              {{ useBoard.formatDateHour(item.writeDate) }}
            </div>
          </div>
        </div>
        <div class="commentInputContainer">
          <div class="userName" v-if="useMember.user != null">
            {{ useMember.user?.userId }}
          </div>
          <div class="userName" v-else></div>
          <textarea
            class="commentInput"
            placeholder="댓글을 남겨보세요"
            v-model="commentInput"
            maxlength="300"
          ></textarea>
          <div class="inputLength">
            {{ commentLength == 0 ? null : `${commentLength}/300` }}
          </div>
          <div
            class="submitBtn"
            @click="commentSubmit"
            :class="{
              active: commentLength > 0 ? true : false,
            }"
          >
            등록
          </div>
        </div>
      </div>
    </div>
    <!--  -->
    <div class="btnContainer">
      <div class="writeBtn" v-if="useMember.user != null" @click="writePublic">
        글쓰기
      </div>
      <div
        v-if="useMember.user?.userId == userBoard?.userId"
        class="updateBtn"
        @click="writeNotice"
      >
        수정
      </div>
      <div
        v-if="useMember.user?.userId == userBoard?.userId"
        class="deleteBtn"
        @click="deletePublic"
      >
        삭제
      </div>
      <div class="listBtn" @click="goPublicList">목록</div>
    </div>
    <!--  -->
    <div class="aroundContainer">
      <div class="aroundTitle">공공게시판 다른 글</div>
      <div class="preBoard aroundBoard" v-if="preBoard != null" @click="goPre">
        <div class="aroundContentTitle">{{ preBoard?.title }}</div>
        <div class="aroundContentWriter">{{ preBoard?.userId }}</div>
        <div class="aroundContentWriteDate">
          {{ useBoard.formatDate(preBoard?.writeDate) }}
        </div>
      </div>
      <div class="nowBoard aroundBoard">
        <div class="aroundContentTitle">
          {{ userBoard?.title }}
        </div>
        <div class="aroundContentWriter">{{ userBoard?.userId }}</div>
        <div class="aroundContentWriteDate">
          {{ useBoard.formatDate(userBoard?.writeDate) }}
        </div>
      </div>
      <div
        class="postBoard aroundBoard"
        v-if="postBoard != null"
        @click="goPost"
      >
        <div class="aroundContentTitle">{{ postBoard?.title }}</div>
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
/* 55 20 15 10 */
</style>
