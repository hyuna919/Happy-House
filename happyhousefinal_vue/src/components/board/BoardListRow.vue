<template>
  <tr>
    <td>{{ no }}</td>
    <td>
      <a v-if="type === 'qna'">
        <router-link :to="{ name: 'QnaView', params: { no: no } }">{{
          subject
        }}</router-link>
      </a>
      <a v-if="type === 'notice'">
        <router-link :to="{ name: 'NoticeView', params: { no: no } }">{{
          subject
        }}</router-link>
      </a>
    </td>
    <td>{{ userid }}</td>
    <td>{{ regtime }}</td>
  </tr>
</template>

<script>
import moment from "moment";

export default {
  name: "BoardListRow",
  props: {
    no: String,
    userid: String,
    subject: String,
    content: String,
    hit: String,
    regtime: String,
    answer: String,
    type: String,
  },
  computed: {
    changeDateFormat() {
      return moment(new Date(this.regtime)).format("YY.MM.DD.");
    },
  },
};
</script>

<style></style>
