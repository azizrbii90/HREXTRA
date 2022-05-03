import { createApp } from 'vue'
import App from './App.vue'
import './index.css'

import router from "./router";
import store from './store';

import Notifications from '@kyvg/vue3-notification'

import 'v-calendar/dist/style.css';
import VCalendar from 'v-calendar';

createApp(App)
  .use(router)
  .use(store)
  .use(Notifications)
  .use(VCalendar)
  .mount('#app')
