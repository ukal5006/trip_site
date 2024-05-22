import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import { useRouter } from 'vue-router';

export const useMemberStore = defineStore('member', () => {
  const router = useRouter();

  const user = ref();
  // const user = ref({
  //   userId: 'ssafy',
  //   userName: '김싸피',
  //   userPwd: '1234',
  //   birth: '1998-10-02',
  //   userPhone: '010-2520-5066',
  //   admin: 1,
  // });
  // jwt << 이거를 쿠키에 넣어서 뭔가를... 이건아직 못함

  const setUser = (input) => {
    user.value = input;
  };

  const logout = () => {
    user.value = null;
    router.replace('/');
  };

  return { user, setUser, logout };
});
