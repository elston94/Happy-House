<template>
  <!-- 아파트 전/월세 상세조회 -->
  <div>
    <br />
    <table border="1" class="table">
      <tr>
        <td>번호</td>
        <td>{{ aptrent.no }}</td>
      </tr>
      <tr>
        <td>법정동</td>
        <td>{{ aptrent.dong }}</td>
      </tr>
      <tr>
        <td>아파트 이름</td>
        <td>{{ aptrent.aptName }}</td>
      </tr>
      <tr>
        <td>코드</td>
        <td>{{ aptrent.code }}</td>
      </tr>
      <tr>
        <td>월세가격</td>
        <td>{{ aptrent.rentMoney }} (단위 : 만 원)</td>
      </tr>
      <tr>
        <td>보증금</td>
        <td>{{ aptrent.deposit }} (단위 : 만 원)</td>
      </tr>
      <tr>
        <td>건축년도</td>
        <td>{{ aptrent.buildYear }}년</td>
      </tr>
      <tr>
        <td>거래 년도</td>
        <td>{{ aptrent.dealYear }}년</td>
      </tr>
      <tr>
        <td>거래 월</td>
        <td>{{ aptrent.dealMonth }}월</td>
      </tr>
      <tr>
        <td>거래 일</td>
        <td>{{ aptrent.dealDay }}일</td>
      </tr>
      <tr>
        <td>면적</td>
        <td>{{ aptrent.area }} (㎡)</td>
      </tr>
      <tr>
        <td>층</td>
        <td>{{ aptrent.floor }} 층</td>
      </tr>
      <tr>
        <td>지번</td>
        <td>{{ aptrent.jibun }}</td>
      </tr>
    </table>

    <KakaoMap
      :dong="aptrent.dong"
      :aptName="aptrent.aptName"
      :islist="false"
      :jibun="aptrent.jibun"
    />
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
    ...mapGetters(["aptrent"]),
  },
  created() {
    let aptNo = this.$route.params.no;
    this.$store.dispatch("getAptRent", { aptNo });
  },
};
</script>

<style></style>
