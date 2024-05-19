import { ref, computed } from 'vue';
import { defineStore } from 'pinia';

export const useMemberStore = defineStore('member', () => {
  // const user = ref();
  const user = {
    userId: 'asd',
    userName: 'asd',
    userPwd: 'asd',
    birth: 'asd',
    userPhone: 'asd',
    admin: 1,
  };

  const setUser = (input) => {
    user.value = input;
  };

  const logout = () => {
    user.value = null;
  };

  return { user, setUser, logout };
});
