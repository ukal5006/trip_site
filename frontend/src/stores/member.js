import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useMemberStore = defineStore("member", () => {
  const memberList = [
    {
      id: "ssafy",
      password: "ssafy",
      name: "김싸피",
    },
    {
      id: "admin",
      password: "admin",
      name: "관리자",
    },
  ];
  const id = ref("");
  const name = ref("");

  const changeId = (input) => {
    id.value = input;
  };

  const changeName = () => {
    const idx = memberList.findIndex((item) => item.id === id.value);
    if (idx !== -1) {
      name.value = memberList[idx].name;
    }
  };
  return { memberList, id, name, changeId, changeName };
});
