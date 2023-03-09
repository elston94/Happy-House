<template>
  <!--아파트 전/월세 목록 -->
  <div>
    <apt-rent-search></apt-rent-search>
    <br />
    <table border="1" v-if="1" align="center" class="table">
      <colgroup>
        <col :style="{ width: '5%' }" />
        <col :style="{ width: '20%' }" />
        <col :style="{ width: '40%' }" />
        <col :style="{ width: '25%' }" />
      </colgroup>
      <tr>
        <th>번호</th>
        <th>법정동</th>
        <th>아파트 이름</th>
        <th>월세가격</th>
        <th>보증금</th>
        <th>면적</th>
      </tr>
      <list-row
        v-for="(apt, index) in aptrentlist.aList"
        :key="`${index}`"
        :no="apt.no"
        :dong="apt.dong"
        :aptName="apt.aptName"
        :deposit="apt.deposit"
        :rentMoney="apt.rentMoney"
        :area="apt.area"
      />
    </table>
    <div class="row row-grid justify-content-between align-items-center mt-lg">
      <base-pagination
        :pageCount="aptrentlist.totalPage"
        :perPage="aptrentlist.curpage"
        :total="aptrentlist.totalCount"
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
import ListRow from "@/components/rent/AptRentRow.vue";
import AptRentSearch from "@/components/rent/AptRentSearch.vue";
export default {
  components: {
    ListRow,
    AptRentSearch,
  },
  computed: {
    ...mapGetters(["aptrentlist"]),
  },
  data() {
    return {
      page: 1,
    };
  },
  created() {
    this.$store.dispatch("getAptRentList", this.page);
  },
  methods: {
    pageMove(item) {
      this.page = item;
      this.$store.dispatch("getAptRentList", this.page);
    },
  },
};
</script>

<style></style>
