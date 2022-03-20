<template>
  <div class="d-flex flex-column">
    <main class="flex-shrink-0">
      <!-- Page content-->
      <section class="py-5">
        <div class="container px-5">
          <!-- Contact form-->
          <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
            <div class="text-center mb-5">
              <h1 class="fw-bolder">비밀번호 찾기</h1>
              <p class="lead fw-normal text-muted mb-0">
                가입한 아이디를 입력하면 저장된 이메일로 비밀번호를
                보내드립니다.
              </p>
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
                        v-model="userId"
                        placeholder="Enter your id..."
                        data-sb-validations="required"
                      />
                      <label for="name">아이디</label>
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
                      비밀번호 찾기
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
import { execPasswordMail } from "@/api/user.js";
import { apiInstance } from "@/api/instance.js";
const api = apiInstance();

export default {
  name: "UserPassWord",
  data() {
    return {
      userId: null,
    };
  },
  computed: {},
  methods: {
    confirm() {
      api.get(`/user/idCheck/${this.userId}`).then((response) => {
        if (response.data == "SUCCESS") {
          alert("존재하지 않는 ID입니다.");
          this.isOk = true;
        } else {
          execPasswordMail(this.userId);
          alert("메일로 비밀번호를 전송했습니다.");
          this.$router.push({ name: "Home" });
          // await execPasswordMail("hyuna919@naver.com");
        }
      });
    },
  },
};
</script>

<style></style>
