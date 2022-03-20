<template>
  <div id="app">
    <navi-bar />
    <router-view />
    <footer-bar />
  </div>
</template>

<script>
import NaviBar from "./components/layout/NaviBar.vue";
import FooterBar from "./components/layout/Footer.vue";

export default {
  components: {
    NaviBar,
    FooterBar,
  },
  name: "App",
};
</script>

<style>
@import url("css/styles.css");
</style>
