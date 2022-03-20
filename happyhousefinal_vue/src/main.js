import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

import { BootstrapVue, IconsPlugin } from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue);
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin);

Vue.config.productionTip = false;

Vue.use(BootstrapVue);
new Vue({
  router,
  store,
  // async beforeCreate() {
  //   let token = sessionStorage.getItem("access-token");
  //   if (loginStore.state.userInfo == null && token) {
  //     await loginStore.dispatch("getUserInfo", token);
  //   }
  // },
  render: (h) => h(App),
}).$mount("#app");
