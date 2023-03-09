<template>
  <!-- 아파트 매매 메인 -->
  <div class="container">
    <br />
    <h1 style="font-family: 'Nanum Gothic'">아파트 매매</h1>
    <b-button variant="light" @click="goAptlist">목록 보기</b-button>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  methods: {
    goAptlist() {
      this.$router.push("/apt/list");
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Nanum+Gothic&display=swap");
</style>
