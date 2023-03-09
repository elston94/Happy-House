<template>
  <!-- 로그아웃 -->
  <div>
    <h3>로그아웃중입니다.</h3>
  </div>
</template>

<script>
export default {
  name: "Logout",
  created() {
    this.$store.dispatch("logout").then(() => {
      alert("로그아웃 되었습니다.");
      this.$router.push("/");
    });
  },
};
</script>

<style></style>
