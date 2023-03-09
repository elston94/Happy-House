<template>
  <!-- 게시글 목록 -->
  <div>
    <board-search></board-search>
    <br />
    <table border="1" align="center" class="table">
      <colgroup>
        <col :style="{ width: '10%' }" />
        <col :style="{ width: '50%' }" />
        <col :style="{ width: '10%' }" />
        <col :style="{ width: '25%' }" />
      </colgroup>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
      </tr>
      <list-row
        v-for="(board, index) in boardlist.bList"
        :key="`${index}`"
        :bnum="board.bnum"
        :btitle="board.btitle"
        :bwriter="board.bwriter"
        :bregdate="formatDate(board.bregdate)"
      />
    </table>
    <div class="row row-grid justify-content-between align-items-center mt-lg">
      <base-pagination
        :pageCount="boardlist.totalPage"
        :perPage="boardlist.curpage"
        :total="boardlist.totalCount"
        :value="page"
        @input="pageMove"
        align="center"
      />
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import ListRow from "@/components/board/Row.vue";
import BoardSearch from "@/components/board/BoardSearch.vue";
import moment from "moment";
export default {
  components: {
    ListRow,
    BoardSearch,
  },
  computed: {
    ...mapGetters(["boardlist"]),
  },
  data() {
    return {
      page: 1,
    };
  },
  created() {
    this.$store.dispatch("getBoardList", this.page);
    console.log("create");
  },
  methods: {
    pageMove(item) {
      this.page = item;
      this.$store.dispatch("getBoardList", this.page);
    },
    formatDate(date) {
      return moment(new Date(date)).format("YYYY.MM.DD HH:mm");
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
