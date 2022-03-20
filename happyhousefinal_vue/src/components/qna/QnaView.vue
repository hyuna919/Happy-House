<template>
  <div class="d-flex flex-column">
    <main class="flex-shrink-0">
      <section class="py-5">
        <div class="container px-5 my-5">
          <div class="row gx-5">
            <div class="col-lg-9">
              <!-- Post content-->
              <article>
                <!-- Post header-->
                <!-- Post title-->
                <h1 class="fw-bolder mb-1">{{ qna.subject }}</h1>

                <hr />
                <!-- Post meta content-->
                <div class="text-muted fst-italic mb-2">
                  작성자 : {{ qna.userid }}
                </div>
                <div class="text-muted fst-italic mb-2">
                  작성일 : {{ qna.regtime }}
                </div>
                <div class="text-muted fst-italic mb-2">
                  조회수 : {{ qna.hit }}
                </div>

                <!-- Post content-->
                <section class="mb-5">
                  <p class="fs-5 mb-4">
                    {{ qna.content }}
                  </p>
                </section>
              </article>
              <!-- button zone -->
              <section class="mb-5">
                <div class="row">
                  <div class="">
                    <a
                      class="btn btn-primary float-right"
                      v-if="userInfo.userId === this.qna.userid"
                    >
                      <router-link
                        :to="{
                          name: 'QnaUpdate',
                          params: { qna: this.qna },
                        }"
                        class="text-light"
                      >
                        글 수정
                      </router-link></a
                    >
                    <a
                      class="btn btn-primary float-right"
                      v-if="
                        userInfo.userId === this.qna.userid ||
                        userInfo.userId === 'admin'
                      "
                      @click="deleteQna"
                    >
                      글 삭제</a
                    >
                    <div v-if="userInfo.userId === 'admin'">
                      <a
                        class="btn btn-primary float-right"
                        @click="writeAnswer"
                        ><div v-if="!isAnswering">답변 수정</div>
                        <div v-else>답변 완료</div>
                      </a>
                    </div>
                    <a
                      class="btn btn-primary float-right"
                      v-if="userInfo.userId === 'admin'"
                      @click="removeAnswer"
                    >
                      답변 삭제</a
                    >
                  </div>
                </div>
              </section>
              <!-- Comments section-->
              <section>
                <div class="card bg-light">
                  <div class="card-body">
                    <!-- Single comment-->
                    <div class="d-flex">
                      <div class="flex-shrink-0">
                        <img
                          class="rounded-circle"
                          src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
                          alt="..."
                        />
                      </div>
                      <div class="col-11">
                        <div class="fw-bold">
                          <p v-if="!isAnswering">
                            {{ qna.answer }}
                          </p>
                          <textarea
                            class="form-control"
                            id="message"
                            type="text"
                            placeholder="Enter your message here..."
                            v-model="qna.answer"
                            v-if="isAnswering"
                            data-sb-validations="required"
                          >
                          </textarea>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </section>
            </div>
          </div>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
import { mapState } from "vuex";
const userStore = "userStore";

// import { getArticle } from "@/api/qna";
import {
  getArticle,
  deleteArticle,
  modifyAnswer,
  deleteAnswer,
} from "@/api/qna";

export default {
  data() {
    return {
      qna: {},
      isAnswering: false,
    };
  },
  computed: {
    ...mapState(userStore, ["userInfo"]),
  },
  created() {
    getArticle(this.$route.params.no).then(
      (response) => (this.qna = response.data)
    );
  },
  methods: {
    deleteQna() {
      alert("정말 삭제하시겠습니까?");
      deleteArticle(this.qna.no);
      alert("삭제되었습니다!");
      this.$router.push({ name: "QnaList" });
      this.$router.go();
    },
    writeAnswer() {
      if (this.isAnswering) {
        this.isAnswering = false;
        modifyAnswer(this.qna);
      } else {
        this.isAnswering = true;
      }
    },
    removeAnswer() {
      this.qna.answer = "";
      deleteAnswer(this.qna.no);
    },
  },
};
</script>

<style></style>
