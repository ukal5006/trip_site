import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

export const useBoardStore = defineStore('board', () => {
  const URL = 'http://192.168.10.93:9999';
  const noticeTop = ref([]);
  const noticeAll = ref([]);
  const publicTop = ref([]);
  const publicAll = ref([]);

  async function fetchNoticeTop() {
    const response = await axios.get('/api/noticeTop');
    noticeTop.value = response.data;
  }

  async function fetchPublicTop() {
    const response = await axios.get('/api/userTop');
    publicTop.value = response.data;
  }
  async function fetchNotice() {
    const response = await axios.get('/api/notice');
    noticeTop.value = response.data;
  }

  async function fetchPublic() {
    const response = await axios.get(`${URL}/notice/contentList`);
    publicTop.value = response.data;
  }

  return {
    noticeTop,
    publicTop,
    noticeAll,
    publicAll,
    fetchNoticeTop,
    fetchPublicTop,
    fetchNotice,
    fetchPublic,
  };
});
