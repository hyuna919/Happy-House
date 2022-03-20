<template>
  <div>
    <table class="table table-hover">
      <thead>
        <tr>
          <th v-for="(column, idx) in columns" :key="idx">{{ column }}</th>
        </tr>
      </thead>
      <tbody>
        <!-- 게시판 목록의 각 아이템 -->
        <board-list-row
          v-if="type === 'QnaList'"
          v-for="(item, index) in list"
          :key="index"
          v-bind="item"
          type="qna"
        />
        <board-list-row
          v-if="type === 'NoticeList'"
          v-for="(item, index) in list"
          :key="index"
          v-bind="item"
          type="notice"
        />
        <admin-list-row
          v-if="type === 'AdminUserList'"
          v-for="(item, index) in list"
          :key="index"
          v-bind="item"
        />
      </tbody>
    </table>
    <ul class="pagination justify-content-center">
      <li class="page-item">
        <a class="page-link" @click="previous">Previous</a>
      </li>
      <!-- 페이지 버튼생성 -->
      <div
        v-for="idx in range(this.paging.startPage, this.paging.endPage)"
        :key="idx"
      >
        <!-- 현재페이지 버튼은 active설정 -->
        <div v-if="idx === paging.nowPage">
          <li class="page-item active">
            <a class="page-link">{{ idx }}</a>
          </li>
        </div>
        <!-- 현재페이지가 아닌 버튼은 active 없음 + 페이지 이동 함수 걸어둠 -->
        <div v-else>
          <li class="page-item">
            <a class="page-link" @click="movePage(idx)">{{ idx }}</a>
          </li>
        </div>
      </div>

      <li class="page-item">
        <a class="page-link" @click="next">Next</a>
      </li>
    </ul>
  </div>
</template>

<script>
import AdminListRow from "@/components/admin/AdminListRow";
import BoardListRow from "@/components/board/BoardListRow";
export default {
  name: "BoardList",
  components: {
    AdminListRow,
    BoardListRow,
  },
  props: {
    list: [],
    paging: {},
    columns: [],
    type: String,
  },
  data() {
    return {
      keyword: "",
    };
  },
  created() {},
  computed: {},
  watch: {},
  methods: {
    range(start, end) {
      if (!end) {
        end = start;
        start = 0;
      }
      start -= 1;
      // end -= 1;
      let arr = [];
      while (start++ !== end) {
        arr.push(start);
      }
      return arr;
    },
    movePage(idx) {
      this.paging.nowPage = idx;
    },
    previous() {
      if (this.paging.nowPage <= 5) {
        alert("더이상 앞으로 갈 수 없습니다.");
      } else {
        this.paging.nowPage = this.paging.startPage - 1;
        this.paging.startPage -= 5;
        this.paging.endPage -= 5;
      }
    },
    next() {
      this.paging.nowPage = this.paging.endPage + 1;
      this.paging.startPage += 5;
      this.paging.endPage += 5;
    },
  },
};
</script>

<style></style>
