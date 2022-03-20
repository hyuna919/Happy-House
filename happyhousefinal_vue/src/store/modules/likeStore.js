import { like, unlike, likeList } from "@/api/like.js";

const likeStore = {
  namespaced: true,
  state: {
    likes: [],
  },
  getters: {},
  mutations: {
    GET_LIKES_LIST(state, likes) {
      state.likes = likes;
    },
    SET_LIKES_LIST(state, like) {
      state.likes.push(like);
    },
    DEL_LIKES_LIST(state, like) {
      for (let index = 0; index < state.likes.length; index++) {
        if (state.likes[index].houseNo == like.houseNo) {
          state.likes.splice(index, 1);
        }
      }
    },
  },
  actions: {
    setLike: ({ commit }, params) => {
      like(
        params,
        () => {
          commit("SET_LIKES_LIST", params);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    deleteLike: ({ commit }, params) => {
      unlike(
        params,
        () => {
          commit("DEL_LIKES_LIST", params);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getLike: ({ commit }, userId) => {
      const params = {
        userId: userId,
      };
      likeList(
        params,
        ({ data }) => {
          console.log("getlike");
          commit("GET_LIKES_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default likeStore;
