import { ref } from 'vue';
import { defineStore } from 'pinia';

export const useDataInfoStore = defineStore('dataInfo', () => {
  const dataType = [
    {
      dataTypeId: 12,
      title: '관광지',
    },
    {
      dataTypeId: 14,
      title: '문화시설',
    },
    {
      dataTypeId: 15,
      title: '축제',
    },
    {
      dataTypeId: 25,
      title: '여행코스',
    },
    {
      dataTypeId: 28,
      title: '레포츠',
    },
    {
      dataTypeId: 32,
      title: '숙박',
    },
    {
      dataTypeId: 38,
      title: '쇼핑',
    },
    {
      dataTypeId: 39,
      title: '음식점',
    },
  ];

  const mapCatagory = [
    {
      dataTypeId: 12,
      title: '관광지',
      icon: 'fa-flag',
      isActive: true,
      color: 'rgb(2,176,80)',
    },
    {
      dataTypeId: 14,
      title: '문화시설',
      icon: 'fa-film',
      isActive: false,
      color: 'black',
    },
    {
      dataTypeId: 15,
      title: '축제',
      icon: 'fa-star',
      isActive: false,
      color: 'rgb(247,198,9)',
    },
    {
      dataTypeId: 25,
      title: '여행코스',
      icon: 'fa-road',
      isActive: false,
      color: 'black',
    },
    {
      dataTypeId: 28,
      title: '레포츠',
      icon: 'fa-futbol-o',
      isActive: false,
      color: 'black',
    },
    {
      dataTypeId: 32,
      title: '숙박',
      icon: 'fa-bed',
      isActive: false,
      color: 'rgb(247,198,9)',
    },
    {
      dataTypeId: 38,
      title: '쇼핑',
      icon: 'fa-shopping-cart',
      isActive: false,
      color: 'rgb(80,141,221)',
    },
    {
      dataTypeId: 39,
      title: '음식점',
      icon: 'fa-cutlery',
      isActive: true,
      color: 'rgb(80,141,221)',
    },
    {
      dataTypeId: 'thema',
      title: '테마여행',
      icon: 'fa-car',
      isActive: false,
      color: 'red',
    },
    {
      dataTypeId: 'my',
      title: '나의여행',
      icon: 'fa-bookmark',
      isActive: false,
      color: 'rgb(2,176,80)',
    },
  ];

  const getTypeTitle = (typeNumber) => {
    // `dataType` 배열에서 `typeNumber`와 일치하는 `dataTypeId`를 찾습니다.
    const type = dataType.find((type) => type.dataTypeId === typeNumber);
    // 찾은 객체의 `title`을 반환하거나, 해당 `typeNumber`를 찾지 못했다면 undefined를 반환합니다.
    return type ? type.title : undefined;
  };

  const getIsActive = (typeNumber) => {
    const type = mapCatagory.find((type) => type.dataTypeId === typeNumber);

    return type ? type.isActive : undefined;
  };

  return { dataType, getTypeTitle, mapCatagory, getIsActive };
});
