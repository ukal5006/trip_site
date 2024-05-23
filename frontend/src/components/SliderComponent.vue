<template>
  <Carousel :autoplay="2000" :wrap-around="true">
    <Slide v-for="slide in slides" :key="slide.name">
      <div class="carousel__item">
        <img :src="slide.link" :alt="slide.name" class="carousel__image" />
      </div>
    </Slide>

    <template #addons>
      <Navigation />
      <Pagination />
    </template>
  </Carousel>
</template>

<script>
import { defineComponent } from 'vue';
import { Carousel, Navigation, Pagination, Slide } from 'vue3-carousel';

import 'vue3-carousel/dist/carousel.css';

export default defineComponent({
  name: 'SliderComponent',
  components: {
    Carousel,
    Slide,
    Pagination,
    Navigation,
  },
  data() {
    return {
      slides: [
        {
          name: '고양이',
          link: 'https://images.squarespace-cdn.com/content/v1/586ebc34d482e9c69268b69a/1624386887478-9Z3XA27D8WFVDWKW00QS/20201230173806551_JRT8E1VC.png',
        },
        {
          name: '개',
          link: 'https://cdn.lecturernews.com/news/photo/201810/7596_19378_5522.jpg',
        },
        {
          name: '라쿤',
          link: 'https://mblogthumb-phinf.pstatic.net/MjAyMDA4MjZfMjgx/MDAxNTk4NDA3ODE0Nzcz.P4S6ZMutEJZXTsOQoB-aFKq37H1vI8pYCmWz4nJ_5fAg.HGWzWXlvbZjI89k6s-68DLh3YeCd9CU_a3eMCwIcnYUg.JPEG.kjchol123/%EA%B3%A1%EC%84%B1%EA%B8%B0%EC%B0%A8%EB%A7%88%EC%9D%84-%ED%95%9C%EA%B5%AD%EA%B4%80%EA%B4%91%EA%B3%B5%EC%82%AC_%ED%99%88%ED%8E%98%EC%9D%B4%EC%A7%80.jpg?type=w800',
        },
      ],
    };
  },
});
</script>

<style>
.carousel__item {
  min-height: 500px;
  max-height: 500px;
  width: 100%;
  height: 100%;
  background-color: white;
  font-size: 20px;
  border-radius: 30px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  overflow: hidden;
}

.carousel__image {
  width: 100%;
  height: auto;
  border-radius: 10px;
}

.carousel__name {
  margin-top: 10px;
}

.carousel__slide {
  padding: 10px;
}

.carousel__prev,
.carousel__next {
  box-sizing: content-box;
  /* border: 5px solid white; */
  color: whitesmoke;
}
</style>
