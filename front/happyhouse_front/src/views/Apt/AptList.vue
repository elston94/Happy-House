<template>
  <div>
    <!-- 아파트 매매 목록 -->
    <apt-search></apt-search>
    <br />
    <table border="1" v-if="1" align="center" class="table">
      <colgroup>
        <col :style="{ width: '10%' }" />
        <col :style="{ width: '20%' }" />
        <col :style="{ width: '40%' }" />
        <col :style="{ width: '25%' }" />
      </colgroup>
      <tr>
        <th>번호</th>
        <th>법정동</th>
        <th>아파트 이름</th>
        <th>가격</th>
        <th>면적</th>
      </tr>
      <list-row
        v-for="(apt, index) in aptlist.aList"
        :key="`${index}`"
        :no="apt.no"
        :dong="apt.dong"
        :aptName="apt.aptName"
        :dealAmount="apt.dealAmount"
        :area="apt.area"
      />
    </table>
    <div class="row row-grid justify-content-between align-items-center mt-lg">
      <base-pagination
        :pageCount="aptlist.totalPage"
        :perPage="aptlist.curpage"
        :total="aptlist.totalCount"
        :value="page"
        v-model="page"
        @input="pageMove"
        align="center"
      />
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import ListRow from "@/components/apt/AptRow.vue";
import AptSearch from "@/components/apt/AptSearch.vue";
export default {
  components: {
    ListRow,
    AptSearch,
  },
  computed: {
    ...mapGetters(["aptlist"]),
  },
  data() {
    return {
      page: 1,
    };
  },
  created() {
    this.$store.dispatch("getAptList", this.page);
  },
  methods: {
    pageMove(item) {
      this.page = item;
      this.$store.dispatch("getAptList", this.page);
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Nanum+Gothic&display=swap");
th {
  font-family: "Nanum Gothic", sans-serif;
}
</style>
