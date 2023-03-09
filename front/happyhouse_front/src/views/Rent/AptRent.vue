<template>
  <!-- 아파트 전/월세 메인 -->
  <div class="container">
    <br />
    <h1 style="font-family: 'Nanum Gothic'">아파트 전 월세</h1>
    <b-button variant="light" @click="goRentlist">목록 보기</b-button>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  methods: {
    goRentlist() {
      this.$router.push("/rent/list");
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Nanum+Gothic&display=swap");
th {
  font-family: "Nanum Gothic", sans-serif;
}
</style>
