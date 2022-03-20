import jwt_decode from "jwt-decode";
import { login, findById, update, remove } from "@/api/user.js";

const userStore = {
  namespaced: true,
  state: {
    isLogin: false,
    isLoginError: false,
    userInfo: null,
  },
  getters: {
    checkUserInfo: function (state) {
      return state.userInfo;
    },
  },
  mutations: {
    SET_IS_LOGIN: (state, isLogin) => {
      state.isLogin = isLogin;
      console.log(state.isLogin);
    },
    SET_IS_LOGIN_ERROR: (state, isLoginError) => {
      state.isLoginError = isLoginError;
    },
    SET_USER_INFO: (state, userInfo) => {
      state.isLogin = true;
      state.userInfo = userInfo;
    },
  },
  actions: {
    userConfirm({ commit, dispatch }, user) {
      login(user, (response) => {
        if (response.data.message === "SUCCESS") {
          let token = response.data["access-token"];
          sessionStorage.setItem("access-token", token);
          dispatch("getUserInfo", token);
          commit("SET_IS_LOGIN", true);
          commit("SET_IS_LOGIN_ERROR", false);
        } else {
          commit("SET_IS_LOGIN", false);
          commit("SET_IS_LOGIN_ERROR", true);
        }
      });
    },
    getUserInfo({ commit }, token) {
      let decode_token = jwt_decode(token);
      let tmp = findById(decode_token.userId, (response) => {
        commit("SET_USER_INFO", response.data.userInfo);
      });
      tmp.then((response) => {
        commit("SET_USER_INFO", response.data.userInfo);
      });
    },
    updateUserInfo({ commit }, params) {
      update(
        params,
        (response) => {
          if (response.data === "SUCCESS") {
            commit("SET_USER_INFO", params);
          } else {
            alert("실패!!!");
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    deleteUserInfo({ commit }, params) {
      remove(params);
      sessionStorage.removeItem("access-token");

      commit("SET_USER_INFO", null);
      commit("SET_IS_LOGIN", false);
    },
  },
};

export default userStore;
