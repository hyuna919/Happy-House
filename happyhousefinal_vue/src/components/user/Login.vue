<template>
  <div class="d-flex flex-column">
    <main class="flex-shrink-0">
      <!-- Page content-->
      <section class="py-5">
        <div class="container px-5">
          <!-- Contact form-->
          <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
            <div class="text-center mb-5">
              <h1 class="fw-bolder">로그인</h1>
            </div>
            <div class="row gx-5 justify-content-center">
              <div class="col-lg-8 col-xl-6">
                <!-- * * * * * * * * * * * * * * *-->
                <!-- * * SB Forms Contact Form * *-->
                <!-- * * * * * * * * * * * * * * *-->
                <!-- This form is pre-integrated with SB Forms.-->
                <!-- To make this form functional, sign up at-->
                <!-- https://startbootstrap.com/solution/contact-forms-->
                <!-- to get an API token!-->
                <form>
                  <!-- Name input-->
                  <div class="mb-5">
                    <div class="form-floating mb-3">
                      <input
                        class="form-control"
                        id="id"
                        type="text"
                        v-model="user.userId"
                        data-sb-validations="required"
                      />
                      <label for="name">아이디</label>
                    </div>
                    <div class="form-floating mb-3">
                      <input
                        class="form-control"
                        id="pw"
                        type="text"
                        v-model="user.userPw"
                        data-sb-validations="required"
                      />
                      <label for="name">비밀번호</label>
                    </div>
                  </div>
                  <!-- Submit Button-->
                  <div class="d-grid">
                    <button
                      class="btn btn-primary btn-lg mb-3"
                      id="submitButton"
                      type="submit"
                      @click="confirm"
                    >
                      로그인
                    </button>
                    <div class="row">
                      <div class="col-md-6 d-grid">
                        <button
                          class="btn bg-white btn-outline-primary btn-lg"
                          id="movePageButton"
                          type="button"
                          @click="JoinPage"
                        >
                          회원가입
                        </button>
                      </div>
                      <div class="col-md-6 d-grid">
                        <button
                          class="btn bg-white btn-outline-primary btn-lg"
                          id="movePageButton"
                          type="button"
                          @click="PwSearchPage"
                        >
                          비밀번호 찾기
                        </button>
                      </div>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
import { mapActions } from "vuex";

const userStore = "userStore";

export default {
  name: "Login",
  data() {
    return {
      user: {
        userId: null,
        userPw: null,
      },
    };
  },
  computed: {
    // ...mapState(userStore, ["isLogin", "isLoginError"]),
  },
  methods: {
    ...mapActions(userStore, ["userConfirm", "getUserInfo"]),

    async confirm() {
      await this.userConfirm(this.user);
      sessionStorage.getItem("access-token");
      alert("반갑습니다! " + this.user.userId + "님");
      this.$router.push({ name: "Home" });
    },

    JoinPage() {
      this.$router.push({ name: "UserJoin" });
    },

    PwSearchPage() {
      this.$router.push({ name: "UserPassword" });
    },
  },
};
</script>

<style></style>
