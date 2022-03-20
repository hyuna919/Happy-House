// 화면 구성 구조 : xxList - BoardList - yyListRow

<template>
  <div class="d-flex flex-column">
    <main class="flex-shrink-0">
      <section class="py-5">
        <div class="container px-5 my-5">
          <div class="text-center mb-5">
            <h1 class="fw-bolder">회원관리</h1>
          </div>
          <div class="row gx-5">
            <!-- FAQ Accordion 1-->
            <div class="row">
              <div class="col-sm-2">
                <select class="btn btn-outline-secondary" v-model="param.key">
                  <option value="id" selected>id</option>
                  <option value="email">email</option>
                </select>
              </div>
              <div class="col-sm-5">
                <input
                  class="form-control"
                  id="subject"
                  type="text"
                  v-model="param.word"
                  placeholder="검색할 아이디를 입력해 주세요..."
                  data-sb-validations="required"
                />
              </div>
              <div class="col-sm-2">
                <a class="btn btn-primary" @click="getList">완료</a>
              </div>
            </div>
            <div class="accordion mb-5" id="accordionExample">
              <!-- 목록 컴포넌트 -->
              <board-list
                v-bind:list="userlist"
                :paging="paging"
                :columns="columns"
                type="AdminUserList"
                @submit="getList"
              />
            </div>
          </div>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
import BoardList from "@/components/board/BoardList.vue";

// 유저 정보는 store에 담아두지 않아야

import { getUserList } from "@/api/user.js";
export default {
  name: "AdminUserList",
  data() {
    return {
      userlist: [],
      paging: {
        nowPage: 1,
        startPage: 1,
        endPage: 5,
      },
      param: {
        pg: 1,
        spp: 10,
        key: "id",
        word: null,
      },
      columns: ["아이디", "비밀번호", "이메일", "이름", "전화번호", "강제탈퇴"],
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
        getUserList(this.param).then((response) => {
          this.userlist = response.data;
        });
      },
    },
  },
  mounted() {
    getUserList(this.param).then((response) => {
      this.userlist = response.data;
    });
  },
  computed: {},
  methods: {
    getList() {
      getUserList(this.param).then((response) => {
        this.userlist = response.data;
      });
    },
  },
};
</script>

<style></style>
