<template>
  <!-- 메인페이지 메인 -->
  <div>
    <br />
    <h1>마이페이지</h1>
    <b-button variant="light" @click="userInfo">회원정보 조회</b-button>
    <b-button variant="light" @click="usermodify">회원정보 수정</b-button>
    <b-button variant="light" @click="userdelete">회원 탈퇴</b-button>
    <router-view></router-view>
    <section class="section-profile-cover section-shaped my-0"></section>
  </div>
</template>

<script>
export default {
  methods: {
    userInfo() {
      this.$router.push("/mypage/detail");
    },
    usermodify() {
      this.$router.push("/mypage/update");
    },
    userdelete() {
      this.$router.push("/mypage/delete");
    },
  },
};
</script>
<style></style>
