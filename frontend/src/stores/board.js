import { computed, ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

export const useBoardStore = defineStore('board', () => {
  const mainURL = import.meta.env.VITE_URL;
  //홈 화면 게시글
  //유저 좋아요순 5개
  const userBoardGood = ref();
  const userBoardGoodURL = 'userBoard/orderGood';
  const loadUserBoardGood = () => {
    axios
      .get(`${mainURL}${userBoardGoodURL}`)
      .then((response) => (userBoardGood.value = response.data));
  };
  loadUserBoardGood();

  //유저 조회수순 5개
  const userBoardRead = ref();
  const userBoardReadURL = 'userBoard/orderRead';
  const loadUserBoardRead = () => {
    axios
      .get(`${mainURL}${userBoardReadURL}`)
      .then((response) => (userBoardRead.value = response.data));
  };
  loadUserBoardRead();

  //날자 포멧 변경 함수
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

    if (isToday) {
      // 시간이 두 자리 숫자가 되도록 포맷팅
      const hours = String(date.getUTCHours()).padStart(2, '0');
      const minutes = String(date.getUTCMinutes()).padStart(2, '0');
      return `${hours}:${minutes}`;
    } else {
      // 연도, 월, 일을 추출 및 포맷팅
      const year = date.getUTCFullYear();
      const month = String(date.getUTCMonth() + 1).padStart(2, '0'); // 월은 0부터 시작하므로 +1 필요
      const day = String(date.getUTCDate()).padStart(2, '0');
      return `${year}.${month}.${day}`;
    }
  }
  function formatDateHour(isoString) {
    // ISO 문자열을 Date 객체로 변환
    const date = new Date(isoString);

    // 연도, 월, 일, 시간, 분 추출
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0'); // 월은 0부터 시작하므로 1을 더해줌
    const day = String(date.getDate()).padStart(2, '0');
    const hours = String(date.getHours()).padStart(2, '0');
    const minutes = String(date.getMinutes()).padStart(2, '0');

    // 원하는 형식으로 문자열 생성
    return `${year}.${month}.${day} ${hours}:${minutes}`;
  }

  //커뮤니티 화면 게시글
  //공지사항 5개
  const noticeTop = ref();
  const noticeTopURL = 'notice/orderDate';
  const loadNoticeTop = () => {
    axios
      .get(`${mainURL}${noticeTopURL}`)
      .then((response) => (noticeTop.value = response.data));
  };
  loadNoticeTop();

  //공공게시판 5개
  const userBoardTop = ref();
  const userBoardTopURL = 'userBoard/orderDate';
  const loadUserBoardTop = () => {
    axios
      .get(`${mainURL}${userBoardTopURL}`)
      .then((response) => (userBoardTop.value = response.data));
  };
  loadUserBoardTop();

  //공지사항 전부
  const notice = ref([]);
  const noticeURL = 'notice';
  const loadNotice = () => {
    axios
      .get(`${mainURL}${noticeURL}`)
      .then((response) => (notice.value = response.data));
  };
  loadNotice();

  //공지사항 인덱스 찾기
  const findNoticeIndex = (noticeId) => {
    const index = notice.value.findIndex((item) => item.noticeId == noticeId);
    return index;
  };
  const findNoticeByIndex = (noticeId) => {
    const index = findNoticeIndex(noticeId);
    if (index != -1) {
      return notice.value[index];
    }
    return null;
  };
  const findPreNotice = (noticeId) => {
    const index = findNoticeIndex(noticeId) - 1;
    if (index != -1) {
      return notice.value[index];
    }
    return null;
  };
  const findPostNotice = (noticeId) => {
    const index = findNoticeIndex(noticeId) + 1;
    if (index != notice.value.length) {
      return notice.value[index];
    }
    return null;
  };

  //공지사항 하나
  const noticeOne = ref();
  const noticeOneURL = 'notice/';
  const loadNoticeOne = (id) => {
    axios
      .get(`${mainURL}${noticeOneURL}${id}`)
      .then((response) => (noticeOne.value = response.data));
  };

  //공공게시판 하나
  const publicOne = ref();
  const publicOneURL = 'userBoard/';
  const loadPublicOne = (id) => {
    axios
      .get(`${mainURL}${publicOneURL}${id}`)
      .then((response) => (publicOne.value = response.data));
  };

  //공공게시판 전부
  const userBoard = ref();
  const userBoardURL = 'userBoard';
  const loadUserBoard = () => {
    axios
      .get(`${mainURL}${userBoardURL}`)
      .then((response) => (userBoard.value = response.data));
  };
  loadUserBoard();
  const userBoardPage = ref();
  const loadUserBoardPage = (page) => {
    axios
      .get(`${mainURL}userBoard/list?page=${page}`)
      .then((response) => (userBoardPage.value = response.data))
      .then((response) => console.log(userBoardPage.value));
  };
  loadUserBoardPage(1);

  const noticePage = ref();
  const loadNoticePage = (page) => {
    axios
      .get(`${mainURL}notice/list?page=${page}`)
      .then((response) => (noticePage.value = response.data))
      .then((response) => console.log(noticePage.value));
  };
  loadNoticePage(1);

  //공공게시판 인덱스 찾기
  const findPublicIndex = (postId) => {
    const index = userBoard.value.findIndex((item) => item.postId == postId);
    return index;
  };
  const findPublicByIndex = (postId) => {
    const index = findPublicIndex(postId);
    if (index != -1) {
      return userBoard.value[index];
    }
    return null;
  };
  const findPrePublic = (postId) => {
    const index = findPublicIndex(postId) - 1;
    if (index != -1) {
      return userBoard.value[index];
    }
    return null;
  };
  const findPostPublic = (postId) => {
    const index = findPublicIndex(postId) + 1;
    if (index != userBoard.value.length) {
      return userBoard.value[index];
    }
    return null;
  };

  // 댓글
  const comment = ref();

  const commentURL = 'comment?postId=';
  const loadComment = (postId) => {
    axios
      .get(`${mainURL}${commentURL}${postId}`)
      .then((response) => (comment.value = response.data));
  };

  //미리보기
  const hoveredItem = ref(null);

  const showPreview = (item) => {
    hoveredItem.value = item;
  };

  const hidePreview = () => {
    hoveredItem.value = null;
  };

  const boardType = ref(0);
  const setBoardNotice = () => (boardType.value = 1);
  const setBoardPublic = () => (boardType.value = 0);
  return {
    userBoardGood,
    userBoardRead,
    formatDate,
    formatDateHour,
    noticeTop,
    userBoardTop,
    hoveredItem,
    showPreview,
    hidePreview,
    notice,
    userBoard,
    noticeOne,
    loadNoticeOne,
    publicOne,
    loadPublicOne,
    findNoticeByIndex,
    findPreNotice,
    findPostNotice,
    findPublicByIndex,
    findPrePublic,
    findPostPublic,
    boardType,
    setBoardNotice,
    setBoardPublic,
    loadUserBoard,
    loadNotice,
    userBoardPage,
    loadUserBoardPage,
    noticePage,
    loadNoticePage,
  };
});
