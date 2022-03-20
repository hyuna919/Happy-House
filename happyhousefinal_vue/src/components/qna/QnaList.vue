// 화면 구성 구조 : xxList - BoardList - yyListRow
<template>
  <div class="d-flex flex-column">
    <main class="flex-shrink-0">
      <section class="py-5">
        <div class="container px-5 my-5">
          <div class="text-center mb-5">
            <h1 class="fw-bolder">Q & A</h1>
            <p class="lead fw-normal text-muted mb-0">How can we help you?</p>
          </div>
          <div class="row gx-5">
            <div class="col-xl-8">
              <!-- FAQ Accordion 1-->
              <div class="row">
                <div class="col-md-10">
                  <h2 class="fw-bolder mb-3">문의사항</h2>
                </div>
                <div class="col-md-2">
                  <a class="btn btn-primary float-right" href="">
                    <router-link :to="{ name: 'QnaWrite' }" class="text-light">
                      글쓰기
                    </router-link></a
                  >
                </div>
              </div>
              <div class="accordion mb-5" id="accordionExample">
                <!-- 게시판 form -->
                <board-list
                  v-bind:list="qnalist"
                  :paging="paging"
                  :columns="columns"
                  type="QnaList"
                />
              </div>
            </div>
            <div class="col-xl-4">
              <div class="card border-0 bg-light mt-xl-5">
                <div class="card-body p-4 py-lg-5">
                  <div class="d-flex align-items-center justify-content-center">
                    <div class="text-center">
                      <div class="h6 fw-bolder">Have more questions?</div>
                      <p class="text-muted mb-4">
                        Contact us at
                        <br />
                        <a href="/qna/view">happyhouse@ssafy.com</a>
                      </p>
                      <div class="h6 fw-bolder">Follow us</div>
                      <div class="h-25 d-inline-block" style="width: 120px">
                        아이콘자리
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
import BoardList from "@/components/board/BoardList.vue";

import { mapState } from "vuex";
import { listArticle } from "@/api/qna.js";
const qnaStore = "qnaStore";

export default {
  name: "QnaList",
  data() {
    return {
      qnalist: [],
      paging: {
        nowPage: 1,
        startPage: 1,
        endPage: 5,
      },
      param: {
        pg: 1,
        spp: 10,
        key: null,
        word: null,
      },
      columns: ["번호", "제목", "작성자", "작성일"],
    };
  },
  components: {
    BoardList,
  },
  watch: {
    paging: {
      deep: true,
      handler() {
        this.param.pg = this.paging.nowPage;
        listArticle(this.param).then((response) => {
          console.log(this.param.pg);
          this.qnalist = response.data;
        });
      },
    },
  },
  created() {
    listArticle(this.param).then((response) => {
      this.qnalist = response.data;
    });
  },
  mounted() {
    listArticle(this.param).then((response) => {
      this.qnalist = response.data;
    });
  },
  computed: {
    ...mapState(qnaStore, ["getQnaList"]),
  },
  methods: {},
};
</script>

<style></style>
