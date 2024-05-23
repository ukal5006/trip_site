<script setup>
import LogoComponent from '@/components/LogoComponent.vue';
import { ref } from 'vue';
import { useMemberStore } from '@/stores/member';
import { useSettingStore } from '@/stores/setting';
import axios from 'axios';
import { useRouter } from 'vue-router';

const router = useRouter();

const { setUser } = useMemberStore();

const inputId = ref('');
const inputPassword = ref('');
const login = async () => {
  try {
    const response = await axios.post(`${import.meta.env.VITE_URL}user/login`, {
      userId: inputId.value,
      userPwd: inputPassword.value,
    });
    console.log(response.data);
    setUser(response.data);
    router.replace('/');
  } catch (error) {
    const errorCode = error.response.request.status;
    if (errorCode === 401) {
      alert('Id 또는 Password가 잘못되었습니다.');
    } else {
      alert('서버에러');
    }
  }
};
</script>

<template>
  <div class="loginFlex">
    <LogoComponent />
    <div class="loginContainer">
      <h1 class="loginTitle">Welcome Back</h1>
      <div class="inputWrapper">
        <input
          class="input"
          type="text"
          placeholder="아이디"
          @keyup.enter="login"
          v-model="inputId"
        />
      </div>
      <div class="inputWrapper">
        <input
          class="input"
          type="password"
          placeholder="비밀번호"
          @keyup.enter="login"
          v-model="inputPassword"
        />
      </div>
      <div class="btn" @click="login">로그인</div>
      <div class="other">
        <RouterLink :to="{ name: 'idfind' }">아이디 찾기</RouterLink>
        <span class="split">|</span>
        <RouterLink :to="{ name: 'pwdfind' }">비밀번호 찾기</RouterLink>
        <span class="split">|</span>
        <RouterLink :to="{ name: 'join' }">회원가입</RouterLink>
      </div>
    </div>
  </div>
</template>

<style scoped>
.loginFlex {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.loginContainer {
  width: 300px;
  padding: 20px 30px;
  background-color: white;
  border-radius: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 10px auto;
}
.loginTitle {
  margin-top: 50px;
  margin-bottom: 20px;
  font-size: 30px;
  font-weight: 700;
}
.inputWrapper {
  padding-left: 10px;
  width: 200px;
  height: 40px;
  margin-bottom: 20px;
  background-color: whitesmoke;
  border-radius: 5px;
}

.input {
  width: 180px;
  height: 40px;
  border: none;
  border-radius: 5px;
  background-color: rgba(0, 0, 0, 0);
  &:focus {
    outline: none;
  }
}
.btn {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 200px;
  height: 50px;
  color: whitesmoke;
  background-color: rgb(15, 55, 88);
  border-radius: 10px;
  transition: 0.3s;
  border: 1px solid gray;
  cursor: pointer;
  margin-bottom: 20px;
  &:hover {
    background-color: rgba(15, 55, 88, 0.9);
  }
}

.other {
  margin-bottom: 50px;
  display: flex;
}

.split {
  margin: 0px 10px;
}
</style>
