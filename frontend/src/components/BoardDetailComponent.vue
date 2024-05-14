<script setup>
defineProps({
  board: Object,
});
</script>

<template>
  <div class="boardItem">
    <span class="boardItemNo">{{ board.no }}번째 글</span>
    <span class="boardItemTitle">제목 : {{ board.title }}</span>
    <span class="boardItemWriter">글쓴이 : {{ board.writer }}</span>
    <span class="boardItemContent">내용 : {{ board.content }}</span>
  </div>
</template>

<style scoped>
.boardItem {
  /* margin: 10px auto; */
  display: flex;
  flex-direction: column;
  height: 400px;
  justify-content: center;
  background-color: wheat;
  border-radius: 20px;
  padding: 0px 20px;
}
.boardItemNo {
  font-size: 40px;
  margin-bottom: 20px;
}
.boardItemTitle {
  font-size: 40px;
  margin-bottom: 20px;
}
.boardItemWriter {
  font-size: 30px;
  margin-bottom: 20px;
}
.boardItemContent {
  font-size: 20px;
}
</style>
