<template>
  <div>
    <b-container class="bv-example-row mt-3 text-center" v-if="isLogin">
      <h3 class="underline-orange">
        <b-icon icon="house-fill"></b-icon> House Service
      </h3>
      <b-row>
        <b-col>
          <house-search-bar></house-search-bar>
        </b-col>
      </b-row>
      <b-row>
        <b-col cols="6" align="left">
          <house-list />
        </b-col>
        <b-col cols="6">
          <kakao-map />
        </b-col>
      </b-row>
    </b-container>
    <b-container v-else> <span :set="unauth()"></span></b-container>
  </div>
</template>

<script>
import { mapState } from "vuex";

import HouseSearchBar from "@/components/house/HouseSearchBar.vue";
import HouseList from "@/components/house/HouseList.vue";
import KakaoMap from "@/components/house/KakaoMap.vue";
const userStore = "userStore";

export default {
  name: "House",
  components: {
    HouseSearchBar,
    HouseList,
    KakaoMap,
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError"]),
  },
  methods: {
    unauth() {
      alert("로그인 후 이용해주세요!");
      this.$router.push({ name: "Login" });
    },
  },
};
</script>

<style></style>
