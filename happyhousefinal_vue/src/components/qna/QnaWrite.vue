<template>
  <div class="d-flex flex-column">
    <main class="flex-shrink-0">
      <section class="py-5">
        <div class="container px-5 my-5">
          <board-write type="regist" @submit="write" />
        </div>
      </section>
    </main>
  </div>
</template>

<script>
import BoardWrite from "@/components/board/BoardWrite.vue";

import { writeArticle } from "@/api/qna.js";

export default {
  name: "QnaWrite",
  components: {
    BoardWrite,
  },
  methods: {
    async write(qna) {
      writeArticle(qna);
      alert("글 작성이 완료되었습니다.");
      this.$router.push({ name: "QnaList" });
    },
  },
};
</script>

<style></style>
