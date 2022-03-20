<template>
  <div class="d-flex flex-column h-100">
    <main class="flex-shrink-0" v-if="isLogin">
      <router-view></router-view>
    </main>
    <div v-else><span :set="unauth()"></span></div>
  </div>
</template>

<script>
const userStore = "userStore";
import { mapState } from "vuex";

export default {
  name: "Qna",
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

<style scoped>
@import url("../css/styles.css");
</style>
