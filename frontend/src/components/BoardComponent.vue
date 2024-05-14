<script setup>
defineProps({
  board: Object,
});
</script>

<template>
  <div class="boardItem">
    <span class="boardItemNo">{{ board.no }}.</span>
    <span class="boardItemWriter">{{ board.writer }}</span>
    <span class="boardItemTitle">{{ board.title }}</span>
    <span class="boardItemContent">{{ board.content }}</span>
  </div>
</template>

<style scoped>
.boardItem {
  height: 50px;
  margin-top: 20px;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  /* margin: 0px auto; */
}
.boardItemNo {
  width: 100px;
}
.boardItemWriter {
  width: 100px;
}
.boardItemTitle {
  width: 200px;
}
.boardItemContent {
  width: 500px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  word-break: break-all;
}
</style>
