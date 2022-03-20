import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

import houseStore from "@/store/modules/houseStore.js";
import userStore from "@/store/modules/userStore.js";
import qnaStore from "@/store/modules/qnaStore.js";
import likeStore from "@/store/modules/likeStore.js";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: { houseStore, userStore, qnaStore, likeStore },
  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ],
});
