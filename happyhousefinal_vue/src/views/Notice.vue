<template>
  <div>
    <div class="d-flex flex-column h-100" v-if="isLogin">
      <main class="flex-shrink-0">
        <router-view></router-view>
      </main>
    </div>
    <div v-else><span :set="unauth()"></span></div>
  </div>
</template>

<script>
const userStore = "userStore";
import { mapState } from "vuex";

export default {
  name: "Notice",
  components: {},
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

<style>
@import url("../css/styles.css");
</style>
