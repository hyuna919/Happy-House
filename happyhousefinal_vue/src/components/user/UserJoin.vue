<template>
  <div class="d-flex flex-column">
    <main class="flex-shrink-0">
      <!-- Page content-->
      <section class="py-5">
        <div class="container px-5">
          <!-- Contact form-->
          <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
            <div class="text-center mb-5">
              <h1 class="fw-bolder">회원가입</h1>
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
                  <div class="form-floating mb-3">
                    <input
                      class="form-control"
                      id="id"
                      type="text"
                      v-model="user.userId"
                      placeholder="Enter your id..."
                      data-sb-validations="required"
                    />
                    <label for="name">아이디</label>
                    <br />
                    <button
                      class="btn btn-secondary"
                      id="submitButtn"
                      type="submit"
                      @click.prevent="idCheck()"
                    >
                      아이디 중복확인
                    </button>
                  </div>
                  <div class="form-floating mb-3">
                    <input
                      class="form-control"
                      id="pw"
                      v-model="user.userPw"
                      type="text"
                      placeholder="Enter your password..."
                      data-sb-validations="required"
                    />
                    <label for="name">비밀번호</label>
                  </div>
                  <div class="form-floating mb-3">
                    <input
                      class="form-control"
                      id="name"
                      v-model="user.userName"
                      type="text"
                      placeholder="Enter your name..."
                      data-sb-validations="required"
                    />
                    <label for="name">이름</label>
                  </div>
                  <!-- Email address input-->
                  <div class="form-floating mb-3">
                    <input
                      class="form-control"
                      id="email"
                      v-model="user.userEmail"
                      type="email"
                      placeholder="name@example.com"
                      data-sb-validations="required,email"
                    />
                    <label for="email">이메일</label>
                  </div>
                  <!-- Phone number input-->
                  <div class="form-floating mb-3">
                    <input
                      class="form-control"
                      id="phone"
                      type="number"
                      pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}"
                      v-model="user.userPhone"
                      data-sb-validations="required"
                    />
                    <label for="phone">연락처</label>
                  </div>

                  <!-- Submit Button-->
                  <div class="d-grid">
                    <button
                      class="btn btn-primary btn-lg"
                      id="submitButtn"
                      type="submit"
                      @click.prevent="registUser"
                    >
                      회원가입
                    </button>
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
import { regist } from "@/api/user.js";
import { apiInstance } from "@/api/instance.js";
const api = apiInstance();

export default {
  name: "Join",
  data() {
    return {
      user: {
        userId: null,
        userPw: null,
        userEmail: null,
        userPhone: null,
        userName: null,
      },
      isOk: false,
      preId: null,
    };
  },
  watch: {
    user: {
      deep: true,
      handler(val) {
        if (this.preId != val.userId) {
          this.isOk = false;
        }
        this.preId = val.userId;
      },
    },
  },
  methods: {
    registUser() {
      if (this.user.userId == null) {
        alert("아이디를 입력해주세요.");
      } else if (this.user.userPw == null) {
        alert("비밀번호를 입력해주세요.");
      } else if (this.user.userName == null) {
        alert("이름을 입력해주세요.");
      } else if (this.user.userEmail == null) {
        alert("이메일을 입력해주세요.");
      } else if (this.user.userPhone == null) {
        alert("연락처를 입력해주세요.");
      } else if (this.isOk) {
        regist(this.user);
        alert("회원가입이 완료되었습니다!!");
        this.$router.push({ name: "Home" }); // vue의 화면 갱신은 비동기
      } else {
        alert("아이디 중복확인을 해주세요!");
      }
    },

    movePage() {
      this.$router.push({ name: "Login" });
    },
    idCheck() {
      api.get(`/user/idCheck/${this.user.userId}`).then((response) => {
        if (response.data == "SUCCESS") {
          alert("사용가능한 아이디입니다.");
          this.isOk = true;
        } else {
          alert("사용불가능한 아이디입니다.");
        }
      });
    },
  },
};
</script>

<style></style>
