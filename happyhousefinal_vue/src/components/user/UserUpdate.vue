<template>
  <div class="d-flex flex-column">
    <main class="flex-shrink-0">
      <section class="py-5">
        <div class="container px-5 my-5">
          <div class="row gx-5">
            <div class="col-lg-9">
              <!-- Post content-->
              <!-- Post header-->
              <div class="mb-4">
                <!-- Post title-->
                <h1 class="fw-bolder mb-1">회원정보 수정</h1>
              </div>
              <!-- Post content-->
              <section class="mb-5">
                <form>
                  <!-- Name input-->
                  <div class="form-floating mb-3">
                    <div class="small text-uppercase fw-bold">아이디</div>
                    <input
                      type="readonly"
                      class="form-control"
                      id="id"
                      v-model="userInfo.userId"
                      ref="userId"
                      readonly
                    />
                  </div>
                  <div class="form-floating mb-3">
                    <div class="small text-uppercase fw-bold">비밀번호</div>
                    <input
                      class="form-control"
                      id="pw"
                      v-model="userInfo.userPw"
                      type="text"
                      placeholder="Enter your password..."
                      data-sb-validations="required"
                    />
                  </div>
                  <div class="form-floating mb-3">
                    <div class="small text-uppercase fw-bold">이름</div>
                    <input
                      class="form-control"
                      id="name"
                      v-model="userInfo.userName"
                      type="text"
                      placeholder="Enter your name..."
                      data-sb-validations="required"
                    />
                  </div>
                  <!-- Email address input-->
                  <div class="form-floating mb-3">
                    <div class="small text-uppercase fw-bold">이메일</div>
                    <input
                      class="form-control"
                      id="email"
                      v-model="userInfo.userEmail"
                      type="email"
                      placeholder="name@example.com"
                      data-sb-validations="required,email"
                    />
                  </div>
                  <!-- Phone number input-->
                  <div class="form-floating mb-3">
                    <div class="small text-uppercase fw-bold">연락처</div>
                    <input
                      class="form-control"
                      id="phone"
                      type="number"
                      v-model="userInfo.userPhone"
                      placeholder="(123) 456-7890"
                      data-sb-validations="required"
                    />
                  </div>

                  <!-- Submit Button-->
                  <div class="d-grid mb-3">
                    <button
                      class="btn btn-primary btn-lg"
                      id="submitButtn"
                      type="submit"
                      @click="updateUser()"
                    >
                      회원 정보 수정
                    </button>
                  </div>
                  <div class="d-grid mb-3">
                    <button
                      class="btn btn-primary btn-lg"
                      id=""
                      type="submit"
                      @click="deleteUser()"
                    >
                      회원 탈퇴
                    </button>
                  </div>
                </form>
              </section>
            </div>
          </div>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

const userStore = "userStore";

export default {
  name: "MyPageUserUpdate",
  data() {
    return {
      user: {
        userId: null,
        userPw: null,
      },
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {
    ...mapActions(userStore, [
      "userConfirm",
      "getUserInfo",
      "updateUserInfo",
      "deleteUserInfo",
    ]),

    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      if (token) {
        await this.getUserInfo(token);
        this.$router.push({ name: "Home" }); // vue의 화면 갱신은 비동기
      }
    },

    movePage() {
      this.$router.push({ name: "Join" });
    },
    updateUser() {
      this.updateUserInfo(this.userInfo);
      alert("정보수정이 완료되었습니다.!!");
    },
    deleteUser() {
      var input = prompt("비밀번호를 입력해주세요.");

      if (input == this.userInfo.userPw) {
        var result = confirm("정말로 탈퇴 하시겠습니까?");
        if (result) {
          this.deleteUserInfo(this.userInfo.userId);
          alert("탈퇴가 완료되었습니다.");
          if (this.$route.path != "/") this.$router.push({ name: "Home" });
        }
      } else {
        alert("올바른 비밀번호를 입력해주세요!!");
      }
    },
  },
};
</script>

<style></style>
