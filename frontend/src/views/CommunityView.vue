<script setup>
import BoardComponent from "@/components/BoardComponent.vue";
import BoardHeaderComponent from "@/components/BoardHeaderComponent.vue";
import { useBoardStore } from "@/stores/board.js";
import { onMounted } from "vue";
import { useSettingStore } from "@/stores/setting";

const setting = useSettingStore();
setting.changeBoxColor("rgb(85,203,205)");

const { noticeTop, publicTop } = useBoardStore();
const boardList = [
    {
        name: "notice",
        title: "공지사항",
    },
    {
        name: "public",
        title: "공공게시판",
    },
];
const board = useBoardStore();

const getBoardData = (boardName) => {
    if (boardName === "notice") {
        return noticeTop;
    } else if (boardName === "public") {
        return publicTop;
    }
    return []; // 해당하지 않는 경우 빈 배열 반환
};

// onMounted(async () => {
//   board.fetchNoticeTop();
//   board.fetchPublicTop();
//   board.fetchNotice();
//   board.fetchPublic();
// });
</script>

<template>
    <div class="communityConainter">
        <h1>커뮤니티</h1>
        <div v-for="board in boardList" :key="board.name" class="board" :class="board.name">
            <div class="communitiyHeader">
                <span class="boardTitle">{{ board.title }}</span>
                <span class="boardDetail">
                    <RouterLink class="boardLink" :to="{ name: board.name }"> + </RouterLink>
                </span>
            </div>
            <div class="communityContent">
                <BoardHeaderComponent />
                <BoardComponent
                    v-for="boardInfo in getBoardData(board.name)"
                    :key="boardInfo.no"
                    :board="boardInfo"
                />
            </div>
        </div>
    </div>
</template>

<style scoped>
.board {
    height: 400px;
    background-color: rgb(165, 216, 235);
    padding: 10px;
    margin-top: 15px;
    border-radius: 15px;
}

.communitiyHeader {
    display: flex;
    justify-content: space-between;
}
.boardTitle {
    font-size: 20px;
}
.boardDetail {
    font-size: 20px;
}
.boardLink {
    text-decoration: none;
    color: black;
}
/* .communityContent {
} */
</style>
