<template>
  <header class="shadow bg-white">
    <b-navbar toggleable="lg" id="navbar">
      <b-navbar-brand>
        <router-link to="/" style="color: #d8f2f0"
          ><img
            class="logo-img"
            alt="logo"
            :src="require('@/assets/Mainlogo.png')"
        /></router-link>
      </b-navbar-brand>

      <!-- <b-navbar-toggle target="nav-collapse"></b-navbar-toggle> -->

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav v-if="user.login == true" class="navbar-menu">
          <b-nav-item
            ><router-link to="/apt">아파트 매매</router-link></b-nav-item
          >
          <b-nav-item
            ><router-link to="/rent">아파트 전월세</router-link></b-nav-item
          >
          <b-nav-item><router-link to="/board">게시판</router-link></b-nav-item>
          <!-- <b-nav-item
            ><router-link to="/chart">공지사항</router-link></b-nav-item
          > -->
          <b-nav-item><router-link to="/news">News</router-link></b-nav-item>
        </b-navbar-nav>

        <b-navbar-nav v-if="user.login != true" class="navbar-menu">
          <b-nav-item>로그인 후 이용 가능합니다</b-nav-item>
        </b-navbar-nav>

        <b-navbar-nav class="ml-auto">
          <!-- Using 'button-content' slot -->

          <template v-if="user.login == true">
            <b-nav-item>{{ user.name }}님 반갑습니다!</b-nav-item>
            <b-nav-item
              ><router-link to="/logout">로그아웃</router-link></b-nav-item
            >
            <b-nav-item
              ><router-link to="/mypage">마이페이지</router-link></b-nav-item
            >

            <br />
          </template>

          <template v-else>
            <b-nav-item
              ><router-link to="/login">로그인</router-link></b-nav-item
            >
            <b-nav-item
              ><router-link to="/join">회원가입</router-link></b-nav-item
            >
          </template>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </header>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  computed: {
    ...mapGetters(["user"]),
  },
};
</script>

<style scoped>
header {
  font-family: "Do Hyeon", sans-serif !important;
  min-height: 30px;
  font-size: 16px;
  width: 100%;
  position: fixed;
  top: 0;
  left: 0;
  /* display: flex;
   position: relative; */
  border-bottom: solid 1.5px rgb(198, 198, 198);
  background: white;
  z-index: 10;
}

#navbar {
  padding: 5px 20px;
  width: 100%;
}

.navbar-nav .nav-link {
  margin-left: 20px;
}

.logo {
  float: left;
  padding: 10px 10px 3px 10px;
}

.logo-img {
  height: 45px;
}

a {
  color: black;
}

a:hover {
  color: #1075dc;
  text-decoration: none;
}

.login-tab {
  font-size: 14px;
  font-weight: normal;
  margin-top: 6px;
}

.userInfo {
  margin-top: 2%;
  font-size: 16px;
}

.username {
  color: black;
  font-weight: normal;
}

.username span {
  color: #1075dc;
}
</style>
