<template>
  <div>
    <b-navbar type="dark" variant="dark">
      <b-navbar-nav>
        <b-nav-item href="#"
          ><router-link
            :to="{ name: 'Home' }"
            class="text-white"
            style="text-decoration: none"
            >HappyHouse</router-link
          ></b-nav-item
        >
        <b-nav-item href="#"
          ><router-link
            :to="{ name: 'QnaList' }"
            class="text-white"
            style="text-decoration: none"
            >Q&A</router-link
          ></b-nav-item
        >
        <b-nav-item href="#"
          ><router-link
            :to="{ name: 'NoticeList' }"
            class="text-white"
            style="text-decoration: none"
            >공지사항</router-link
          ></b-nav-item
        >
      </b-navbar-nav>

      <!-- 로그인시 보이는 버튼 -->
      <b-navbar-nav class="ml-auto" v-if="userInfo">
        <b-nav-item>{{ userInfo.userId }}님 환영합니다</b-nav-item>
        <b-nav-item href="#"
          ><router-link
            :to="{ name: 'MyPage' }"
            class="text-white"
            style="text-decoration: none"
            >마이페이지</router-link
          ></b-nav-item
        >
        <b-nav-item
          class="link align-self-center"
          @click.prevent="onClickLogout"
          >로그아웃</b-nav-item
        >
        <!-- 로그인+관리자 계정이면 보이는 버튼 -->
        <div v-if="userInfo.userId === 'admin'">
          <b-nav-item href="#"
            ><router-link
              :to="{ name: 'Admin' }"
              class="text-white"
              style="text-decoration: none"
              >관리자 페이지</router-link
            ></b-nav-item
          >
        </div>
      </b-navbar-nav>

      <!-- 로그아웃시 보이는 버튼 -->
      <b-navbar-nav class="ml-auto" v-else>
        <b-nav-item href="#"
          ><router-link
            :to="{ name: 'Login' }"
            class="text-white"
            style="text-decoration: none"
            >로그인</router-link
          ></b-nav-item
        >
        <b-nav-item href="#"
          ><router-link
            :to="{ name: 'UserJoin' }"
            class="text-white"
            style="text-decoration: none"
            >회원가입</router-link
          ></b-nav-item
        >
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";
const userStore = "userStore";
const houseStore = "houseStore";

export default {
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
  },
  methods: {
    ...mapMutations(userStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    ...mapMutations(houseStore, ["CLEAR_HOUSE_LIST"]),
    onClickLogout() {
      this.SET_USER_INFO(null);
      this.SET_IS_LOGIN(false);
      sessionStorage.removeItem("access-token");
      this.CLEAR_HOUSE_LIST();
      if (this.$route.path != "/") this.$router.push({ name: "Home" });
    },
  },
};
</script>

<style></style>
