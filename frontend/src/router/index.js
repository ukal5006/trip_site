import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import ThemaView from "@/views/ThemaView.vue";
import AreaView from "@/views/AreaView.vue";
import MapView from "@/views/MapView.vue";
import LoginView from "@/views/LoginView.vue";
import CommunityView from "@/views/CommunityView.vue";
import NoticeView from "@/views/NoticeView.vue";
import PublicView from "@/views/PublicView.vue";
import MyPageView from "@/views/MyPageView.vue";
import NoticeDetailView from "@/views/NoticeDetailView.vue";
import PublicDetailView from "@/views/PublicDetailView.vue";
import PublicWriteView from "@/views/PublicWriteView.vue";
import { useMemberStore } from "@/stores/member";
import MountainThemaView from "@/views/MountainThemaView.vue";
import BreweryThemaView from "@/views/BreweryThemaView.vue";
import EatThemaView from "@/views/EatThemaView.vue";
const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: "/",
            name: "home",
            component: HomeView,
        },
        {
            path: "/thema",
            name: "thema",
            component: ThemaView,
        },
        {
            path: "/thema/mountain",
            name: "mountain",
            component: MountainThemaView,
        },
        {
            path: "/thema/brewery",
            name: "brewery",
            component: BreweryThemaView,
        },
        {
            path: "/thema/eat",
            name: "eat",
            component: EatThemaView,
        },
        {
            path: "/area",
            name: "area",
            component: AreaView,
        },
        {
            path: "/map",
            name: "map",
            component: MapView,
        },
        {
            path: "/login",
            name: "login",
            component: LoginView,
        },
        {
            path: "/community",
            name: "community",
            component: CommunityView,
        },
        {
            path: "/community/notice",
            name: "notice",
            component: NoticeView,
        },
        {
            path: "/community/notice/:boardId",
            name: "noticeDetail",
            component: NoticeDetailView,
        },
        {
            path: "/community/public",
            name: "public",
            component: PublicView,
        },
        {
            path: "/community/notice/:boardId",
            name: "publicDetail",
            component: PublicDetailView,
        },
        {
            path: "/mypage",
            name: "mypage",
            component: MyPageView,
        },
        {
            path: "/write",
            name: "write",
            component: PublicWriteView,
        },
    ],
});

router.beforeEach((to, from) => {
    if (to.name == "notice" && useMemberStore().id == "") {
        alert("공지사항은 회원만 볼 수 있습니다.");
        return false;
    }
});

router.beforeEach((to, from) => {
    if (to.name == "write" && useMemberStore().id == "") {
        alert("글 작성은 회원만 할 수 있습니다.");
        return false;
    }
});

export default router;
