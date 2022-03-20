// 화면 구성 구조 : xxList - BoardList - yyListRow
<template>
  <div class="d-flex flex-column">
    <main class="flex-shrink-0">
      <section class="py-5">
        <div class="container px-5 my-5">
          <div class="text-center mb-5">
            <h1 class="fw-bolder">공지사항</h1>
          </div>
          <div class="row">
            <div class="col">
              <!-- FAQ Accordion 1-->
              <div class="row">
                <div class="col"></div>
                <div class="col">
                  <button
                    class="btn btn-primary float-right"
                    href=""
                    v-if="userInfo.userId == 'admin'"
                  >
                    <router-link
                      :to="{ name: 'NoticeWrite' }"
                      class="text-light"
                    >
                      글쓰기
                    </router-link>
                  </button>
                </div>
              </div>
              <div class="accordion mb-5" id="accordionExample">
                <!-- 게시판 form -->
                <board-list
                  v-bind:list="noticelist"
                  :paging="paging"
                  :columns="columns"
                  type="NoticeList"
                />
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
import { listArticle } from "@/api/notice.js";
const noticeStore = "noticeStore";
const userStore = "userStore";

export default {
  name: "NoticeList",
  data() {
    return {
      noticelist: [],
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
          this.noticelist = response.data;
        });
      },
    },
  },
  mounted() {
    // let param = {
    //   pg: this.paging.nowPage,
    //   spp: 10,
    //   key: null,
    //   word: null,
    // };
    listArticle(this.param).then((response) => {
      console.log(this.noticelist);
      this.noticelist = response.data;
      console.log(this.noticelist);
    });
  },
  computed: {
    ...mapState(noticeStore, ["getNoticeList"]),
    ...mapState(userStore, ["userInfo"]),
  },
  methods: {},
};
</script>

<style></style>
