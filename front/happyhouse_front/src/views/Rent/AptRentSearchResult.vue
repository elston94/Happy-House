<template>
  <!--아파트 전/월세 검색 결과 목록 -->
  <div>
    <apt-rent-search></apt-rent-search>
    <div>
      <b>" {{ payload.word }} "</b> 로 검색한 결과
    </div>
    <table border="1" align="center" class="table">
      <tr>
        <td>번호</td>
        <td>동</td>
        <td>아파트 이름</td>
        <td>월세가격</td>
        <td>보증금</td>
        <td>면적</td>
      </tr>
      <tr
        v-for="(a, index) in aptrentsearchlist.sList"
        :key="`${index}_aptsearchlist.aList`"
      >
        <td v-text="a.no"></td>
        <td v-text="a.dong"></td>
        <td>
          <router-link :to="`/rent/detail/${a.no}`">{{
            a.aptName
          }}</router-link>
        </td>
        <td v-text="a.rentMoney"></td>
        <td v-text="a.deposit"></td>
        <td v-text="a.area"></td>
      </tr>
    </table>
    <div class="row row-grid justify-content-between align-items-center mt-lg">
      <base-pagination
        :pageCount="aptrentsearchlist.totalPage"
        :perPage="aptrentsearchlist.curpage"
        :total="aptrentsearchlist.totalCount"
        :value="payload.page"
        v-model="payload.page"
        @input="pageMove"
        align="center"
      />
    </div>
    <router-link to="/rent/list">전체 목록으로 돌아가기</router-link>
    <KakaoMap
      :islist="true"
      :aptlist="aptrentsearchlist.sList"
      :aptName="payload.word"
    />
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import AptRentSearch from "@/components/rent/AptRentSearch.vue";
import KakaoMap from "@/components/map/KakaoMap.vue";
export default {
  components: {
    AptRentSearch,
    KakaoMap,
  },
  computed: {
    ...mapGetters(["aptrentsearchlist"]),
  },
  data() {
    return {
      payload: {
        page: 1,
        key: "",
        word: "",
      },
    };
  },
  created() {
    this.payload.key = this.$route.params.key;
    this.payload.word = this.$route.params.word;
    this.$store.dispatch("getAptRentSearchList", this.payload);
  },
  methods: {
    pageMove(item) {
      this.payload.page = item;
      this.$store.dispatch("getAptRentSearchList", this.payload);
      console.log(this.aptrentsearchlist.sList);
    },
  },
};
</script>

<style></style>
