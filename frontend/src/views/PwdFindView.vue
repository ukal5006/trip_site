<script setup>
import LogoComponent from '@/components/LogoComponent.vue';
import { computed, ref, watch } from 'vue';
import { useSettingStore } from '@/stores/setting';
import axios from 'axios';
import { useRouter } from 'vue-router';

const router = useRouter();

const setting = useSettingStore();
setting.changeBoxColor('rgb(240,242,244)');

const inputId = ref('');
const inputEmail = ref();
const inputName = ref();
const inputBirth = ref();
const phoneFirst = ref('010');
const phoneMiddle = ref();
const phoneLast = ref();
const inputPhone = computed(() => {
  return `${phoneFirst.value}-${phoneMiddle.value}-${phoneLast.value}`;
});

const find = () => {
  axios
    .post(`${import.meta.env.VITE_URL}user/findUserPw`, {
      userId: inputId.value,
      birth: inputBirth.value,
      userName: inputName.value,
      userPhone: inputPhone.value,
      userEmail: inputEmail.value,
    })
    .then((response) => {
      alert(response.data);
      router.replace({ name: 'login' });
    })
    .catch((error) => {
      alert('입력하신 정보와 일치하는 회원이 없습니다.');
    });
};
</script>

<template>
  <div class="flex">
    <LogoComponent />
    <div class="loginContainer">
      <h1 class="loginTitle">비밀번호 찾기</h1>
      <div class="inputWrapper">
        <input
          class="input"
          type="text"
          placeholder="아이디"
          v-model="inputId"
          @input="debouncedIdCheck"
        />
      </div>
      <div class="inputWrapper">
        <input
          class="input"
          type="email"
          placeholder="이메일"
          v-model="inputEmail"
        />
      </div>
      <div class="inputWrapper">
        <input
          class="input"
          type="text"
          placeholder="이름"
          v-model="inputName"
        />
      </div>

      <div class="inputWrapper">
        <input
          class="input"
          type="date"
          placeholder="생년월일"
          v-model="inputBirth"
        />
      </div>

      <div class="inputWrapper phone">
        <select v-model="phoneFirst" class="phoneSelect">
          <option value="010">010</option>
          <option value="011">011</option>
          <option value="012">012</option>
          <option value="013">013</option>
          <option value="014">014</option>
          <option value="015">015</option>
          <option value="016">016</option>
          <option value="017">017</option>
          <option value="018">018</option>
          <option value="019">019</option>
        </select>
        -
        <input
          class="input"
          type="text"
          v-model="phoneMiddle"
          minlength="4"
          maxlength="4"
        />
        -
        <input
          class="input"
          type="text"
          v-model="phoneLast"
          minlength="4"
          maxlength="4"
        />
      </div>
      <div class="btn" @click="find">비밀번호 찾기</div>
    </div>
  </div>
</template>

<style scoped>
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
  margin-top: 0px;
  margin-bottom: 20px;
  font-size: 30px;
  font-weight: 700;
}
.inputWrapper {
  position: relative;
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
  /* margin-bottom: 20px; */
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

.phone {
  display: flex;
  justify-content: center;
  align-items: center;
  input {
    border: 1px solid black;
    width: 30px;
    height: 20px;
    margin: 0px 10px;
  }
}
.flex {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.phoneSelect {
  width: 45px;
  height: 25px;
  border: 1px solid black;
  box-sizing: border-box;
  border-radius: 5px;
  font-family: 'Roboto';
  font-style: normal;
  font-weight: 400;
  font-size: 14px;
  line-height: 16px;
  margin-right: 5px;
}
</style>
