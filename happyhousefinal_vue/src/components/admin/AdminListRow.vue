// 화면 구성 구조 : xxList - BoardList - yyListRow
<template>
  <tr>
    <td>{{ userId }}</td>
    <td>{{ userPw }}</td>
    <td>{{ userEmail }}</td>
    <td>{{ userName }}</td>
    <td>{{ userPhone }}</td>
    <td>
      <a class="btn btn-primary btn-sm" @click="removeUser">탈퇴시키기</a>
    </td>
  </tr>
</template>

<script>
import { remove } from "@/api/user.js";

export default {
  name: "BoardListRow",
  props: {
    userId: String,
    userPw: String,
    userEmail: String,
    userName: String,
    userPhone: String,
    refresh: Function,
  },
  computed: {},
  methods: {
    removeUser() {
      alert(this.userId + "를 탈퇴시킵니다.");
      remove(this.userId);
      // 새로고침;
      this.$router.go();

      // this.$emit("this.refresh");
    },
  },
};
</script>

<style></style>
