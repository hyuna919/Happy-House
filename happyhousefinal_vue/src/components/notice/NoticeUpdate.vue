<template>
  <div class="d-flex flex-column">
    <main class="flex-shrink-0">
      <section class="py-5">
        <div class="container px-5 my-5">
          <board-write
            type="modify"
            @submit="modify"
            :modiArticle="this.notice"
          />
        </div>
      </section>
    </main>
  </div>
</template>

<script>
import BoardWrite from "@/components/board/BoardWrite.vue";

import { modifyArticle } from "@/api/notice.js";

// import { mapActions } from "vuex";
// import { listArticle } from "@/api/notice.js";
// const noticeStore = "noticeStore";

export default {
  name: "NoticeUpdate",
  components: {
    BoardWrite,
  },
  data() {
    return {
      notice: null,
    };
  },
  created() {
    this.notice = this.$route.params.notice;
  },
  methods: {
    // ...mapActions(noticeStore),
    modify(notice) {
      modifyArticle(notice);
      alert("글 수정이 완료되었습니다.");
      this.$router.push({ name: "NoticeList" });
    },
  },
};
</script>

<style></style>
