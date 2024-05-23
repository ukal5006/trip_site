import { createApp } from 'vue';
import { createPinia } from 'pinia';

import App from './App.vue';
import router from './router';

import { useKakao } from 'vue3-kakao-maps/@utils';

const app = createApp(App);

app.use(createPinia());
app.use(router);

useKakao('f338b1da57671b9cf848326a9576fc0b', [
  'clusterer',
  'services',
  'drawing',
]);

app.mount('#app');
