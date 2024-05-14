<script setup>
import LogoComponent from "@/components/LogoComponent.vue";
import { computed, ref } from "vue";
import { useMemberStore } from "@/stores/member";
import router from "@/router";

// const useRouter = router();

const { memberList, changeId, changeName } = useMemberStore();

const inputId = ref("");
const inputPassword = ref("");

const login = () => {
    if (inputId.value == "") {
        alert("id를 입력해 주세요.");
    } else if (inputPassword.value == "") {
        alert("password를 입력해 주세요.");
    } else {
        console.log(`id:${inputId.value} | password:${inputPassword.value}`);
        const memberIndex = memberList.findIndex(
            (item) => item.id == inputId.value && item.password == inputPassword.value
        );
        if (memberIndex != -1) {
            changeId(inputId.value);
            changeName();
            router.replace("/");
        } else {
            alert("Id 또는 Password가 잘못되었습니다.");
        }
    }
};
</script>

<template>
    <div>
        <LogoComponent />
        <h1 class="temp">로그인</h1>
        <input class="input" type="text" placeholder="아이디" v-model="inputId" />
        <input class="input" type="password" placeholder="비밀번호" v-model="inputPassword" />
        <div class="btn" @click="login">로그인</div>
        <div>비밀번호 찾기 | 아이디 찾기 | 회원가입</div>
    </div>
</template>

<style scoped>
.temp {
    margin-top: 100px;
}
h1 {
    margin-bottom: 20px;
}
div {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin: 10px auto;
}

.input {
    width: 200px;
    height: 40px;
}
.btn {
    width: 200px;
    height: 50px;
    background-color: tomato;
    &:hover {
        cursor: pointer;
    }
}
</style>
