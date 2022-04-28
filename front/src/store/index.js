import { createStore } from "vuex";

import AuthStore from './auth.store.js'

export default createStore({
  modules: {
    AuthStore
  },
});
