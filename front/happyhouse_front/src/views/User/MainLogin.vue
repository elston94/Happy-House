<template>
  <!-- 로그인 페이지 -->
  <div class="body">
    <div class="col-6">
      <carousel></carousel>
    </div>
    <div class="col-6">
      <login v-if="check === 0" @change="change"></login>
      <find-pwd v-else-if="check === 1" @change="change"></find-pwd>
      <join v-else-if="check === 2" @change="change"></join>
    </div>
  </div>
</template>

<script>
import FindPwd from "./FindPwd.vue";
import Login from "./Login.vue";
import Join from "./Join.vue";
import Carousel from "./Carousel.vue";
export default {
  name: "MainLogin",
  data() {
    return {
      check: 0, //0:로그인, 1:비밀번호 찾기, 2:회원가입
    };
  },
  components: {
    Login,
    Carousel,
    FindPwd,
    Join,
  },
  methods: {
    change(item) {
      this.check = item;
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Roboto&display=swap");

* {
  font-family: "Roboto", sans-serif;
}
.body {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: linear-gradient(rgba(0, 0, 0, 0.1), rgba(0, 0, 0, 0.1)),
    url("./sky.jpeg") no-repeat center;
  background-size: cover;
}
</style>
