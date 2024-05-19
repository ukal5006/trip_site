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

  const getTypeTitle = (typeNumber) => {
    // `dataType` 배열에서 `typeNumber`와 일치하는 `dataTypeId`를 찾습니다.
    const type = dataType.find((type) => type.dataTypeId === typeNumber);
    // 찾은 객체의 `title`을 반환하거나, 해당 `typeNumber`를 찾지 못했다면 undefined를 반환합니다.
    return type ? type.title : undefined;
  };

  return { dataType, getTypeTitle };
});
