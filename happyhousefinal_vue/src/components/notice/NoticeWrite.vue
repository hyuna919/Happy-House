<template>
  <div class="d-flex flex-column">
    <main class="flex-shrink-0">
      <section class="py-5">
        <div class="container px-5 my-5">
          <board-write type="notice" @submit="write" />
        </div>
      </section>
    </main>
  </div>
</template>

<script>
import BoardWrite from "@/components/board/BoardWrite.vue";

import { writeArticle } from "@/api/notice.js";

export default {
  name: "NoticeWrite",
  components: {
    BoardWrite,
  },
  methods: {
    async write(notice) {
      writeArticle(notice);
      alert("글 작성이 완료되었습니다");
      this.$router.push({ name: "NoticeList" });
    },
  },
};
</script>

<style></style>
