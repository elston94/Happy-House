<template>
  <!-- 로그인페이지 Carousel -->
  <div class="container carousel ml-5">
    <h2 class="display-2" style="color: black">Welcome to HappyHouse!</h2>
    <div>
      <b-carousel
        id="carousel-1"
        v-model="slide"
        :interval="4000"
        controls
        indicators
        background="#ababab"
        img-width="1024"
        img-height="480"
        style="text-shadow: 1px 1px 2px #333"
        @sliding-start="onSlideStart"
        @sliding-end="onSlideEnd"
      >
        <b-carousel-slide
          img-src="https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile1.uf.tistory.com%2Fimage%2F99F78C505E5085042A1BDD"
        ></b-carousel-slide>
        <b-carousel-slide
          img-src="https://images.pexels.com/photos/552102/pexels-photo-552102.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
        >
        </b-carousel-slide>
        <b-carousel-slide
          img-src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile4.uf.tistory.com%2Fimage%2F992E56385E45EA0D20CD8C"
        ></b-carousel-slide>
        <b-carousel-slide
          img-src="https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile4.uf.tistory.com%2Fimage%2F26312F4A566D4C7028C259"
        ></b-carousel-slide>
      </b-carousel>
      <br />
      <h6 style="color: black">
        저희 해피하우스 부동산은 가장 경쟁력 있고, 신뢰할 수 있는 매물만을 엄선하여 <br />
        독자적이고 다양한 정보를 고객님들께 전해드리겠습니다. <br />앞으로 더욱 발전된 모습을
        보이도록 항상 노력하고 고객님과 함께 할 수 있는 파트너가 되겠습니다.
      </h6>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      slide: 0,
      sliding: null,
    };
  },
  methods: {
    onSlideStart(slide) {
      this.sliding = true;
    },
    onSlideEnd(slide) {
      this.sliding = false;
    },
  },
};
</script>

<style>
.carousel {
  text-align: center;
  justify-content: center;
  align-items: center;
}
.carousel img {
  max-height: 480px;
  min-height: 480px;
}
</style>
