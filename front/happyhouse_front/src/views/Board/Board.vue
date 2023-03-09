<template>
  <!-- 게시판 메인 -->
  <div class="container">
    <br />

    <h1 style="font-family: 'Nanum Gothic'">게시판</h1>
    <b-button variant="light" @click="goBoardList">목록</b-button>
    <b-button variant="light" @click="goBoardWrtie">작성</b-button>

    <router-view></router-view>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  computed: {
    ...mapGetters(["user"]),
  },
  methods: {
    goBoardList() {
      this.$router.push("/board/list");
    },
    goBoardWrtie() {
      this.$router.push("/board/write");
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Nanum+Gothic&display=swap");

.container {
  text-align: center;
  justify-content: center;
  align-items: center;
}
</style>
