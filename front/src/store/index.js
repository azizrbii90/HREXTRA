import { createStore } from "vuex";

import AuthStore from './auth.store.js'
import VacationStore from './vacation.store.js'
import PresenceStore from './presence.store'
import UsersStore from './users.store'

export default createStore({
  modules: {
    AuthStore,
    VacationStore,
    PresenceStore,
    UsersStore
  },
});
