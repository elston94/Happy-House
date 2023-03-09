<template>
  <!-- 아파트 매매 상세 조회 -->
  <div>
    <br />
    <table border="1" class="table">
      <tr>
        <td>번호</td>
        <td>{{ apt.no }}</td>
      </tr>
      <tr>
        <td>법정동</td>
        <td>{{ apt.dong }}</td>
      </tr>
      <tr>
        <td>아파트 이름</td>
        <td>{{ apt.aptName }}</td>
      </tr>
      <tr>
        <td>코드</td>
        <td>{{ apt.code }}</td>
      </tr>
      <tr>
        <td>아파트 가격</td>
        <td>{{ apt.dealAmount }} (단위 : 만 원)</td>
      </tr>
      <tr>
        <td>건축년도</td>
        <td>{{ apt.buildYear }}년</td>
      </tr>
      <tr>
        <td>거래 년도</td>
        <td>{{ apt.dealYear }}년</td>
      </tr>
      <tr>
        <td>거래 월</td>
        <td>{{ apt.dealMonth }}월</td>
      </tr>
      <tr>
        <td>거래 일</td>
        <td>{{ apt.dealDay }}일</td>
      </tr>
      <tr>
        <td>면적</td>
        <td>{{ apt.area }} (㎡)</td>
      </tr>
      <tr>
        <td>층</td>
        <td>{{ apt.floor }} 층</td>
      </tr>
      <tr>
        <td>지번</td>
        <td>{{ apt.jibun }}</td>
      </tr>
    </table>

    <KakaoMap :dong="apt.dong" :aptName="apt.aptName" :islist="false" :jibun="apt.jibun" />
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import KakaoMap from "@/components/map/KakaoMap.vue";
export default {
  components: {
    KakaoMap,
  },
  computed: {
    ...mapGetters(["apt"]),
  },
  created() {
    let aptNo = this.$route.params.no;
    this.$store.dispatch("getApt", { aptNo });
  },
};
</script>

<style></style>
