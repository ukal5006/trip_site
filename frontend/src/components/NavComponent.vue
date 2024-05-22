<script setup>
import { RouterLink } from 'vue-router';
import { useMemberStore } from '@/stores/member.js';
import { ref, computed } from 'vue';

const linkList = ref([
  {
    name: 'home',
    title: '홈',
  },
  {
    name: 'thema',
    title: '테마',
  },
  {
    name: 'area',
    title: '지역',
  },
  {
    name: 'map',
    title: '여행지도',
  },
  {
    name: 'community',
    title: '커뮤니티',
  },
]);

const showLinkList = computed(() => {
  if (!useMemberStore().user) {
    return [
      ...linkList.value,
      {
        name: 'login',
        title: '로그인',
      },
    ];
  } else {
    return [
      ...linkList.value,
      {
        name: 'mypage',
        title: '마이페이지',
      },
      {
        name: 'logout',
        title: '로그아웃',
      },
    ];
  }
});
</script>

<template>
  <div class="linkContainer">
    <div class="linkWrapper" v-for="link in showLinkList" :key="link.name">
      <template v-if="link.name == 'id'">
        <RouterLink class="link" :to="{ name: `mypage` }">
          {{ link.title }}
        </RouterLink></template
      >
      <template v-else-if="link.name == 'logout'">
        <div @click="useMemberStore().logout" class="logoutBtn">
          {{ link.title }}
        </div></template
      >
      <template v-else
        ><RouterLink class="link" :to="{ name: link.name }">
          {{ link.title }}
        </RouterLink></template
      >
    </div>
  </div>
</template>

<style scoped>
.linkContainer {
  min-width: 500px;
  display: flex;
  justify-content: space-around;
  align-items: center;
  margin: 20px auto;

  /* justify-content: space-between; */
  /* align-items: center; */
}
/* .linkWrapper {
  margin: 20px 30px;
} */
.link {
  font-size: 24px;
  text-decoration-line: none;
  color: black;
  transition: 0.3s;
}
.link:hover {
  font-weight: bold;
  text-decoration-line: underline;
  text-underline-offset: 8px;
}

.logoutBtn {
  cursor: pointer;
}
</style>
