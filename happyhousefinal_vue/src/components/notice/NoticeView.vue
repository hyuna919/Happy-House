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
                <h1 class="fw-bolder mb-1">{{ notice.subject }}</h1>
                <!-- Post meta content-->
                <div class="text-muted fst-italic mb-2">
                  작성자 : {{ notice.userid }}
                </div>
                <div class="text-muted fst-italic mb-2">
                  작성일 : {{ notice.regtime }}
                </div>
                <div class="text-muted fst-italic mb-2">
                  조회수 : {{ notice.hit }}
                </div>

                <!-- Post content-->
                <section class="mb-5">
                  <p class="fs-5 mb-4">
                    {{ notice.content }}
                  </p>
                </section>
              </article>
              <!-- button zone -->
              <section class="mb-5">
                <div class="row">
                  <div class="">
                    <a
                      class="btn btn-primary float-right"
                      v-if="userInfo.userId === 'admin'"
                    >
                      <router-link
                        :to="{
                          name: 'NoticeUpdate',
                          params: { notice: this.notice },
                        }"
                        class="text-light"
                      >
                        글 수정
                      </router-link></a
                    >
                    <a
                      class="btn btn-primary float-right"
                      v-if="userInfo.userId === 'admin'"
                      @click="deletenotice"
                    >
                      글 삭제</a
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
                      <div class="ms-3">
                        <div class="fw-bold">
                          <p v-if="!isAnswering">
                            {{ notice.answer }}
                          </p>
                          <textarea
                            class="form-control"
                            id="message"
                            type="text"
                            placeholder="Enter your message here..."
                            v-model="notice.answer"
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

// import { getArticle } from "@/api/notice";
import { getArticle, deleteArticle } from "@/api/notice";

export default {
  data() {
    return {
      notice: {},
      isAnswering: false,
    };
  },
  computed: {
    ...mapState(userStore, ["userInfo"]),
  },
  created() {
    getArticle(this.$route.params.no).then(
      (response) => (this.notice = response.data)
    );
  },
  methods: {
    deletenotice() {
      alert("정말 삭제하시겠습니까?");
      deleteArticle(this.notice.no);
      alert("삭제되었습니다!!");
      this.$router.push({ name: "NoticeList" });
    },
  },
};
</script>

<style></style>
