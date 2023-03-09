<template>
  <div>
    <b-alert show variant="light"
      >현재 날씨는 {{ weatherinfo.description }} 입니다.
      <img
        :src="'http://openweathermap.org/img/wn/' + weatherinfo.icon + '.png'"
    /></b-alert>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "WeatherInfo",
  data() {
    return {
      weatherinfo: {},
    };
  },
  created() {
    axios
      .get(
        "https://api.openweathermap.org/data/2.5/weather?q=seoul&units=&lang=kr&appid=3e977a038e1236f622f20dce6e1e5871"
      )
      .then(({ data }) => {
        console.log(data.weather[0]);
        this.weatherinfo = data.weather[0];
      });
  },
};
</script>

<style></style>
