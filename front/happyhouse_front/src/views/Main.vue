<template>
  <div class="container-fluid p-0">
    <div class="main">
      <!--1. carousel 들어가는 div -->
      <div class="carousel-wrapper">
        <b-carousel
          id="carousel-fade"
          style="text-shadow: 0px 0px 2px #000"
          fade
          indicators
          img-width="1410"
          img-height="800"
        >
          <b-carousel-slide
            img-src="https://cdn.pixabay.com/photo/2016/06/24/10/47/house-1477041_960_720.jpg"
          ></b-carousel-slide>
          <b-carousel-slide
            img-src="https://cdn.pixabay.com/photo/2018/07/27/00/32/apartment-3564955_960_720.jpg"
          ></b-carousel-slide>
          <b-carousel-slide
            img-src="https://cdn.pixabay.com/photo/2015/10/20/18/57/furniture-998265_960_720.jpg"
          ></b-carousel-slide>
        </b-carousel>
      </div>
      <div class="container mt-4">
        <weather-info class="weather"></weather-info>
        <div class="row">
          <div class="col">
            <div class="intro">
              <span class="title"> 광고</span>
              <hr />
              <img
                class="intro-img"
                alt="logo"
                :src="require('@/assets/img/ad.png')"
              />
              <!-- <img class="intro-img" alt="intro image" src="@/assets/DM.jpg" /> -->
            </div>
          </div>
          <div class="col">
            <!-- news -->
            <div class="intro">
              <span class="title"> 뉴스</span>
              <hr />

              <home-news></home-news>
            </div>
          </div>

          <div class="col">
            <!-- 공지사항 -->
            <div class="intro">
              <span class="title"> 게시판</span>
              <hr />
              <home-board></home-board>

              <!-- <img class="intro-img" alt="intro image" src="@/assets/DM.jpg" /> -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import WeatherInfo from "@/components/MainInfo/WeatherInfo.vue";
import HomeBoard from "@/components/MainInfo/HomeBoard.vue";
import HomeNews from "../components/MainInfo/HomeNews.vue";
export default {
  components: {
    WeatherInfo,
    HomeBoard,
    HomeNews,
  },
};
</script>

<style>
.weather {
  width: 1400px;
  padding-left: 13%;
}

body {
  background-color: #f9f9f9;
}

.carousel-wrapper {
  height: 500px;
}

.main {
  height: 200vh;
  padding-bottom: 20%;
}

.menu {
  float: left;
}

.login {
  float: right;
}

.mini {
  font-size: 10px;
}

.login {
  display: inline;
  padding: 20px;
}

.user-greeting {
  float: right;
  padding: 20px;
}

.user-greeting p {
  margin-top: 10px;
  font-size: 14px;
}

.username {
  font-weight: bold;
}

.main-backgound {
  height: 580px;
  background-color: #6666ff;
}

.notice {
  padding: 15px;
  width: 350px;
}

.intro {
  padding: 10px;
  width: 550px;
}

.news {
  width: 600px;
  height: 486px;
  padding: 15px;
}

.title {
  font-weight: bold;
}

.notice-link {
  font-size: 12px;
  margin-bottom: 12px;
  margin-left: 0px;
}

.notice-link a {
  color: black;
}

.intro-img {
  width: 320px;
}

.addBtn {
  background-color: white;
  border: 1px solid #c9c9c9;
  font-size: 12px;
}

.btn-right {
  margin-left: 92%;
}

.ntc-news-title {
  overflow: hidden;
  text-overflow: ellipsis;
  display: block;
  white-space: nowrap;
}

.carousel-item {
  height: 500px;
}

.carousel-item img {
  height: 500px;
}

.routerNews {
  /* background-color: red; */
  height: 440px;
}
</style>
