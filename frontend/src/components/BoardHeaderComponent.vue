<script setup></script>

<template>
  <div class="boardHeader">
    <span class="boardHeaderNo">No.</span>
    <span class="boardHeaderWriter">글쓴이</span>
    <span class="boardHeaderTitle">제목</span>
    <span class="boardHeaderContent">내용</span>
  </div>
</template>

<style scoped>
.boardHeader {
  display: flex;
  justify-content: space-evenly;
  height: 20px;
  margin-top: 10px;
  font-size: 20px;
  color: gray;
}
.boardHeaderNo {
  width: 100px;
}
.boardHeaderWriter {
  width: 100px;
}
.boardHeaderTitle {
  width: 200px;
}
.boardHeaderContent {
  width: 500px;
}
</style>
