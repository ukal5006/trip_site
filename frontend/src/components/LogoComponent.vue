<script setup>
import { RouterLink } from 'vue-router';
</script>

<template>
  <RouterLink :to="{ name: 'home' }">
    <img src="@/asset/triplogo.png" alt="" />
  </RouterLink>
</template>

<style scoped>
a {
  font-size: 50px;
  margin-bottom: 20px;
  text-decoration-line: none;
  color: black;
  img {
    width: 200px;
  }
}
</style>
