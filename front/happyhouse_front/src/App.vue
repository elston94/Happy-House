<template>
  <div id="app">
    <Header></Header>
    <main class="rootMain">
      <router-view />
    </main>

    <app-footer class="footer"></app-footer>
  </div>
</template>
<script>
import AppFooter from "@/components/layout/Footer.vue";
import Header from "@/components/layout/Header.vue";
// import MainLogin from "@/views/User/MainLogin.vue";
import { mapGetters } from "vuex";
// import { FadeTransition } from "vue2-transitions";
export default {
  components: {
    // MainLogin,
    Header,
    // FadeTransition,
    AppFooter,
  },
  computed: {
    ...mapGetters(["user"]),
  },
};
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Nanum+Gothic:wght@400;800&display=swap");
* {
  font-family: "Nanum Gothic", sans-serif;
}
h1 {
  font-weight: 800;
}
td,
router-link {
  font-weight: 400;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
/* #nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
} */

.rootMain {
  margin-top: 50px;
  text-align: center;
}
</style>
