<template>
  <div class="d-flex flex-column h-100">
    <main class="flex-shrink-0">
      <div class="row">
        <div class="col-md-2">
          <side-bar></side-bar>
        </div>
        <div class="col-md-10">
          <router-view></router-view>
        </div>
      </div>
    </main>
  </div>
</template>

<script>
import SideBar from "../components/layout/SideBar.vue";

// import { mapActions } from "vuex";
// import { mapState } from "vuex";
// const houseStore = "houseStore";
// const likeStore = "likeStore";
export default {
  name: "MyPage",
  components: { SideBar },
  computed: {
    // ...mapState(houseStore, ["houses"]),
    // ...mapState(likeStore, ["likes"]),
  },

  methods: {
    // ...mapActions(houseStore, ["detailHouse"]),
  },
};
</script>

<style scoped>
@import url("../css/styles.css");
</style>
