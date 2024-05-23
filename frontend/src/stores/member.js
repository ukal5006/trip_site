import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import { useRouter } from 'vue-router';
import Cookies from 'js-cookie';

export const useMemberStore = defineStore('member', () => {
  const router = useRouter();

  const user = ref();

  const cookieUser = Cookies.get('user');
  if (cookieUser != undefined) {
    user.value = JSON.parse(cookieUser);
    console.log(user.value);
  }

  const setUser = (input) => {
    user.value = input;
    const cookieUser = JSON.stringify(user.value);
    document.cookie = 'user=' + cookieUser;
  };

  const logout = () => {
    user.value = null;
    document.cookie = 'user=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    router.replace('/');
  };

  return { user, setUser, logout };
});
