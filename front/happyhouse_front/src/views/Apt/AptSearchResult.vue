<template>
  <!-- 아파트 매매 검색 결과 목록-->
  <div>
    <apt-search></apt-search>
    <div>[ " {{ payload.word }} " ]로 검색한 결과</div>
    <table border="1" align="center" class="table">
      <colgroup>
        <col :style="{ width: '10%' }" />
        <col :style="{ width: '20%' }" />
        <col :style="{ width: '40%' }" />
        <col :style="{ width: '25%' }" />
      </colgroup>
      <tr>
        <td>번호</td>
        <td>동</td>
        <td>아파트 이름</td>
        <td>가격</td>
        <td>면적</td>
      </tr>
      <tr
        v-for="(a, index) in aptsearchlist.aList"
        :key="`${index}_aptsearchlist.aList`"
      >
        <td v-text="a.no"></td>
        <td v-text="a.dong"></td>
        <td>
          <router-link :to="`/apt/detail/${a.no}`">{{ a.aptName }}</router-link>
        </td>
        <td v-text="a.dealAmount"></td>
        <td v-text="a.area"></td>
      </tr>
    </table>
    <div class="row row-grid justify-content-between align-items-center mt-lg">
      <base-pagination
        :pageCount="aptsearchlist.totalPage"
        :perPage="aptsearchlist.curpage"
        :total="aptsearchlist.totalCount"
        :value="payload.page"
        v-model="payload.page"
        @input="pageMove"
        align="center"
      />
    </div>
    <router-link to="/apt/list">전체 목록으로 돌아가기</router-link>
    <KakaoMap
      :islist="true"
      :aptlist="aptsearchlist.aList"
      :aptName="payload.word"
    />
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import AptSearch from "@/components/apt/AptSearch.vue";
import KakaoMap from "@/components/map/KakaoMap.vue";
export default {
  components: {
    AptSearch,
    KakaoMap,
  },
  computed: {
    ...mapGetters(["aptsearchlist"]),
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
    this.$store.dispatch("getAptSearchList", this.payload);
  },
  methods: {
    pageMove(item) {
      this.payload.page = item;
      this.$store.dispatch("getAptSearchList", this.payload);
    },
  },
};
</script>

<style></style>
