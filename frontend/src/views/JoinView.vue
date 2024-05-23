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
const inputPassword = ref('');
const inputPassWordCheck = ref('');
const inputEmail = ref();
const inputName = ref();
const inputBirth = ref();
const phoneFirst = ref('010');
const phoneMiddle = ref();
const phoneLast = ref();
const inputPhone = computed(() => {
  return `${phoneFirst.value}-${phoneMiddle.value}-${phoneLast.value}`;
});
const idCheckMsg = ref('');

const idCheckMsgColor = computed(() => {
  if (idCheckMsg.value == '사용 가능한 아이디입니다.') {
    return 'rgb(2,176,80)';
  } else {
    return 'rgb(255, 0, 0)';
  }
});

function validatePassword(password) {
  const regex = /^(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?\/~`-]).+$/;
  return !regex.test(password);
}

const passwordCheckMsg = computed(() => {
  if (inputPassword.value != '') {
    if (inputPassword.value.length < 8) {
      return '비밀번호는 8자 이상이어야 합니다.';
    } else if (validatePassword(inputPassword.value)) {
      return '비밀번호는 숫자, 소문자, 특수문자가 포함되어야 합니다.';
    } else {
      return '사용 가능한 비밀번호입니다.';
    }
  }
});

const passwordCheckMsgColor = computed(() => {
  if (passwordCheckMsg.value == '사용 가능한 비밀번호입니다.') {
    return 'rgb(2,176,80)';
  } else {
    return 'rgb(255, 0, 0)';
  }
});

const passwordSameCheckMsg = computed(() => {
  if (inputPassWordCheck.value !== '') {
    if (inputPassword.value != inputPassWordCheck.value) {
      return '비밀번호가 다릅니다.';
    } else {
      return '비밀번호가 일치합니다.';
    }
  }
});

const passwordSameCheckMsgColor = computed(() => {
  if (passwordSameCheckMsg.value == '비밀번호가 일치합니다.') {
    return 'rgb(2,176,80)';
  } else {
    return 'rgb(255, 0, 0)';
  }
});

const join = () => {
  axios
    .post(`${import.meta.env.VITE_URL}user/signup`, {
      userId: inputId.value,
      userPwd: inputPassword.value,
      birth: inputBirth.value,
      userName: inputName.value,
      userPhone: inputPhone.value,
      userEmail: inputEmail.value,
      admin: 0,
    })
    .then(() => {
      alert('회원가입 완료!');
      router.replace({ name: 'login' });
    })
    .catch((error) => {
      alert(error.response.data);
    });
};

const idCheck = () => {
  if (inputId.value != '') {
    axios
      .post(`${import.meta.env.VITE_URL}user/idCheck`, {
        userId: inputId.value,
      })
      .then((response) => console.log(response.data))
      .catch((error) => (idCheckMsg.value = error.response.data));
  }
};

function debounce(func, wait) {
  let timeout;
  return function (...args) {
    const later = () => {
      clearTimeout(timeout);
      func(...args);
    };
    clearTimeout(timeout);
    timeout = setTimeout(later, wait);
  };
}

const debouncedIdCheck = debounce(idCheck, 500);
</script>

<template>
  <div class="flex">
    <LogoComponent />
    <div class="loginContainer">
      <h1 class="loginTitle">Hello!</h1>
      <div class="inputWrapper">
        <input
          class="input"
          type="text"
          placeholder="아이디"
          v-model="inputId"
          @input="debouncedIdCheck"
        />
        <!-- <div class="idCheckBtn">중복 체크</div> -->
        <div class="checkText" :style="{ color: idCheckMsgColor }">
          {{ idCheckMsg }}
        </div>
      </div>

      <div class="inputWrapper">
        <input
          class="input"
          type="password"
          placeholder="비밀번호"
          v-model="inputPassword"
          minlength="8"
        />
        <div class="checkText" :style="{ color: passwordCheckMsgColor }">
          {{ passwordCheckMsg }}
        </div>
      </div>

      <div class="inputWrapper">
        <input
          class="input"
          type="password"
          placeholder="비밀번호확인"
          v-model="inputPassWordCheck"
        />
        <div class="checkText" :style="{ color: passwordSameCheckMsgColor }">
          {{ passwordSameCheckMsg }}
        </div>
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
      <div class="btn" @click="join">회원가입</div>
      <div class="kakao">카카오계정으로 회원가입</div>
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
  margin-bottom: 15px;
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
.btn,
.kakao {
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
  /* &:hover {
    background-color: rgba(15, 55, 88, 0.9);
  } */
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

/* .idCheckBtn {
  position: absolute;
  top: 8px;
  right: -68px;
  cursor: pointer;
  background-color: rgb(2, 176, 80);
  border: none;
  padding: 5px;
  border-radius: 5px;
  font-size: 13px;
  color: whitesmoke;
} */

.checkText {
  bottom: -15px;
  font-size: 9px;
  position: absolute;
  color: rgb(255, 0, 0);
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
.kakao {
  margin-top: 17px;
  background-color: #f7e111;
  color: #000000;
  border: none;
}
</style>
