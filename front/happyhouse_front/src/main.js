import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import BootstartVue from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import Argon from "@/plugins/argon-kit";
import VueMoment from "vue-moment";
import Vuetify from "vuetify";
import "vuetify/dist/vuetify.min.css";

Vue.use(VueMoment);
Vue.use(BootstartVue);
Vue.use(Argon);
Vue.use(Vuetify);
Vue.config.productionTip = false;

new Vue({
  router,
  store,
  BootstartVue,
  vuetify: new Vuetify(),
  render: (h) => h(App),
}).$mount("#app");
