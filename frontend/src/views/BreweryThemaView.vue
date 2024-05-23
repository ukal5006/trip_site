<script setup>
import { useThemaStore } from '@/stores/thema.js';
import { useAreaStore } from '@/stores/area.js';
import { useMemberStore } from '@/stores/member.js';
import { ref } from 'vue';
import axios from 'axios';

const useMember = useMemberStore();
const breweryThema = useThemaStore().themas[0];
const areaList = useAreaStore().breweryAreaList;
const seletedArea = ref(areaList[0]);
const seleteHandler = (index) => {
  seletedArea.value = areaList[index];
  loadData();
};
const data = ref();
const URL = `${import.meta.env.VITE_URL}brewery/regionBrewery/`;
const loadData = () => {
  axios
    .get(`${URL}${seletedArea.value.title}`)
    .then((response) => (data.value = response.data));
};
loadData();

const bookDate = ref();
const bookMin = ref();
const bookPhone = ref();
const bookTime = ref();
const modalState = ref(false);

const bookModalOpen = () => {
  modalState.value = true;
};

const bookSubmit = () => {
  console.log(bookDate.value);
  console.log(bookMin.value);
  console.log(bookPhone.value);
  console.log(bookTime.value);
  bookModelClose();
};

const bookModelClose = () => {
  bookDate.value = null;
  bookMin.value = null;
  bookPhone.value = null;
  bookTime.value = null;
  modalState.value = false;
};
</script>

<template>
  <div class="breweryContainer">
    <h1 class="title">{{ breweryThema.title }}</h1>
    <h1 class="content">{{ breweryThema.content1 }}</h1>
    <h1 class="content">{{ breweryThema.content2 }}</h1>
    <div class="breweryInfoContainer">
      <div class="areaContainer">
        <div
          class="areaItem"
          v-for="(area, index) in areaList"
          :key="area.name"
          @click="seleteHandler(index)"
        >
          {{ area.title }}
        </div>
      </div>
      <h1 class="seletedAreaTitle">{{ seletedArea.title }}</h1>
      <div class="breweryListContainer">
        <div class="breweryWrapper" v-for="(item, index) in data" :key="index">
          <div class="breweryImg">
            <img :src="item.breweryImg" alt="" />
          </div>
          <div class="breweryContent">
            <div class="breweryTitle">{{ item.breweryTitle }}</div>
            <div class="breweryAddress">
              {{ '주소 : ' + item.breweryAddress }}
            </div>
            <div class="breweryKind">{{ '주종 : ' + item.breweryKind }}</div>
            <div class="breweryTel">{{ '예약문의 : ' + item.breweryTel }}</div>
            <div class="minPeople">{{ '최소인원 : ' + item.minPeople }}</div>
          </div>
          <div class="bookBtn" @click="bookModalOpen">예약하기</div>
        </div>
      </div>
    </div>
    <div class="bookModal" :class="{ none: !modalState }">
      <div class="bookBox">
        <div class="modalClose" @click="bookModelClose">x</div>
        <div class="bookName">
          예약자 이름 : {{ useMember?.user?.userName }}
        </div>
        <div class="bookDate">
          예약 날짜 :
          <input type="date" class="bookDateInput" v-model="bookDate" />
        </div>
        <div class="bookDate">
          예약 인원 :
          <input type="number" class="bookDateInput" v-model="bookMin" />
        </div>
        <div class="bookDate">
          예약자 전화번호 :
          <input type="text" class="bookDateInput" v-model="bookPhone" />
        </div>
        <div class="bookDate">
          방문 시간 :
          <input type="text" class="bookDateInput" v-model="bookTime" />
        </div>
        <div class="submitBtn" @click="bookSubmit">예약하기</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.breweryContainer {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
  /* width: 1000px; */
}
.title {
  font-size: 30px;
  font-weight: 700;
}
.content {
  font-size: 18px;
  font-weight: 700;
  margin-top: 10px;
}
.breweryInfoContainer {
  display: flex;
  flex-direction: column;
  /* width: inherit; */
}
.areaContainer {
  display: flex;
  justify-content: space-evenly;
  width: 800px;
  border: 1px solid gray;
  padding: 20px;
  margin: 20px auto;
  border-radius: 10px;
  background-color: white;
}
.areaItem {
  width: 60px;
  height: 20px;
  padding-top: 5px;
  text-align: center;
  border-radius: 5px;
  transition-duration: 0.3s;
  &:hover {
    color: black;
    cursor: pointer;
  }
  color: gray;
  background-color: whitesmoke;
}
.seletedAreaTitle {
  margin: 20px auto;
  font-size: 30px;
}
.breweryListContainer {
}
.breweryWrapper {
  display: flex;
  margin-bottom: 10px;
  background-color: whitesmoke;
  position: relative;
  box-sizing: border-box;
  /* border-radius: 20px; */
}
.breweryImg {
  width: 200px;
  height: 200px;
  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    content-visibility: auto;
    /* border-radius: 20px; */
  }
}
.breweryContent {
  padding: 15px;
}
.breweryTitle {
  font-size: 30px;
  font-weight: 700;
  margin-bottom: 15px;
}
.breweryAddress {
  font-size: 20px;
  margin-bottom: 15px;
}
.breweryKind {
  font-size: 20px;
  margin-bottom: 15px;
}
.breweryTel {
  font-size: 20px;
  margin-bottom: 15px;
}
.minPeople {
  font-size: 20px;
}
.bookModal {
  position: fixed;
  top: 0px;
  width: 100vw;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
}
/* .bookModal {
  position: fixed;
  top: calc(50% - 380px);
  left: calc(50% - 300px);
  width: 600px;
  height: 800px;
  background-color: tomato;
} */
.bookBox {
  width: 370px;
  height: 350px;
  z-index: 10;
  box-sizing: border-box;
  padding: 20px;
  border-radius: 20px;
  background-color: whitesmoke;
  position: relative;
}
.bookBtn {
  position: absolute;
  bottom: 20px;
  right: 20px;
  box-sizing: border-box;
  padding: 10px;
  width: 80px;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 20px;
  background-color: lightblue;
  cursor: pointer;
}

.none {
  display: none;
}

.modalClose {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 20px;
  height: 20px;
  cursor: pointer;
  border-radius: 50%;
  font-size: 30px;
  background-color: tomato;
  position: absolute;
  right: 20px;
}
.bookName,
.bookDate,
.bookMin,
.bookPhone,
.bookTime {
  font-size: 25px;
  margin-top: 20px;
  display: flex;
  justify-content: space-between;
}
.submitBtn {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 30px;
  font-size: 30px;
  background-color: skyblue;
  padding: 10px;
  border-radius: 10px;
  cursor: pointer;
}
</style>
