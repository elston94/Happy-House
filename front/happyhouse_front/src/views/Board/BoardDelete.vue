<template>
  <!-- 게시글 삭제 -->
  <div>
    <h3>삭제 중입니다.</h3>
  </div>
</template>

<script>
export default {
  name: "BoardDelete",
  created() {
    this.$store.dispatch("deleteBoard", this.$route.params.no).then((resp) => {
      let msg = "게시물 삭제 실패했습니다.";
      if (resp.data === "success") {
        msg = "게시물 삭제 완료되었습니다.";
      }
      alert(msg);
      this.$router.push("/board/list");
    });
  },
};
</script>

<style></style>
