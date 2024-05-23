import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/views/HomeView.vue';
import ThemaView from '@/views/ThemaView.vue';
import AreaView from '@/views/AreaView.vue';
import MapView from '@/views/MapView.vue';
import LoginView from '@/views/LoginView.vue';
import CommunityView from '@/views/CommunityView.vue';
import NoticeView from '@/views/NoticeView.vue';
import PublicView from '@/views/PublicView.vue';
import MyPageView from '@/views/MyPageView.vue';
import NoticeDetailView from '@/views/NoticeDetailView.vue';
import PublicDetailView from '@/views/PublicDetailView.vue';
import WriteView from '@/views/WriteView.vue';
import { useMemberStore } from '@/stores/member';
import MountainThemaView from '@/views/MountainThemaView.vue';
import BreweryThemaView from '@/views/BreweryThemaView.vue';
import EatThemaView from '@/views/EatThemaView.vue';
import FestivalThemaView from '@/views/FestivalThemaView.vue';
import JoinView from '@/views/JoinView.vue';
import DetailView from '@/views/DetailView.vue';
import AgeCheckView from '@/views/AgeCheckView.vue';
import IdFindView from '@/views/IdFindView.vue';
import PwdFindView from '@/views/PwdFindView.vue';
import { useBoardStore } from '@/stores/board';
// import PasswordCheckComponent from '@/components/PasswordCheckComponent.vue';
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/thema',
      name: 'thema',
      component: ThemaView,
    },
    {
      path: '/idfind',
      name: 'idfind',
      component: IdFindView,
    },
    {
      path: '/pwdfind',
      name: 'pwdfind',
      component: PwdFindView,
    },
    {
      path: '/thema/mountain',
      name: 'mountain',
      component: MountainThemaView,
    },
    {
      path: '/thema/brewery',
      name: 'brewery',
      component: BreweryThemaView,
    },
    {
      path: '/agecheck',
      name: 'agecheck',
      component: AgeCheckView,
    },
    {
      path: '/thema/eat',
      name: 'eat',
      component: EatThemaView,
    },
    {
      path: '/thema/festival',
      name: 'festival',
      component: FestivalThemaView,
    },
    {
      path: '/area',
      name: 'area',
      component: AreaView,
    },
    {
      path: '/join',
      name: 'join',
      component: JoinView,
    },
    {
      path: '/map',
      name: 'map',
      component: MapView,
    },
    {
      path: '/detail/:contentId',
      name: 'detail',
      component: DetailView,
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView,
    },
    {
      path: '/community',
      name: 'community',
      component: CommunityView,
    },
    {
      path: '/community/notice',
      name: 'notice',
      component: NoticeView,
    },
    {
      path: '/community/notice/:boardId',
      name: 'noticeDetail',
      component: NoticeDetailView,
    },
    {
      path: '/community/public',
      name: 'public',
      component: PublicView,
    },
    {
      path: '/community/public/:boardId',
      name: 'publicDetail',
      component: PublicDetailView,
    },
    {
      path: '/mypage',
      name: 'mypage',
      component: MyPageView,
    },
    {
      path: '/community/write',
      name: 'write',
      component: WriteView,
    },
  ],

  scrollBehavior(to, from, savedPosition) {
    // savedPosition이 있으면, 해당 위치로 스크롤합니다.
    if (savedPosition) {
      window.scrollTo({
        top: savedPosition.y,
        behavior: 'smooth',
      });
    } else {
      // savedPosition이 없으면, 페이지 맨 위로 스크롤합니다.
      window.scrollTo({
        top: 0,
        behavior: 'smooth',
      });
    }
  },
});

router.beforeEach((to, from) => {
  if (to.name == 'notice' && useMemberStore().id == '') {
    alert('공지사항은 회원만 볼 수 있습니다.');
    return false;
  }
});

router.beforeEach((to, from) => {
  if (to.name == 'write' && useMemberStore().id == '') {
    alert('글 작성은 회원만 할 수 있습니다.');
    return false;
  }
});

// 브루어리 성인인증
// router.beforeEach((to, from) => {
//     if (to.name == "mypage" && useMemberStore().id == "") {
//         alert("글 작성은 회원만 할 수 있습니다.");
//         return false;
//     }
// });

export default router;
