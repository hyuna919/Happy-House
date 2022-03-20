<template>
  <div class="d-flex flex-column">
    <main class="flex-shrink-0">
      <section class="py-5">
        <div class="container px-5 my-5">
          <board-write type="modify" @submit="modify" :modiArticle="this.qna" />
        </div>
      </section>
    </main>
  </div>
</template>

<script>
import BoardWrite from "@/components/board/BoardWrite.vue";

import { modifyArticle } from "@/api/qna.js";

// import { mapActions } from "vuex";
// import { listArticle } from "@/api/qna.js";
// const qnaStore = "qnaStore";

export default {
  name: "QnaUpdate",
  components: {
    BoardWrite,
  },
  data() {
    return {
      qna: null,
    };
  },
  created() {
    this.qna = this.$route.params.qna;
  },
  methods: {
    // ...mapActions(qnaStore),
    modify(qna) {
      modifyArticle(qna);
      alert("글 수정이 완료되었습니다.");
      this.$router.push({ name: "QnaList" });
    },
  },
};
</script>

<style></style>
