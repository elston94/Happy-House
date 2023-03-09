<template>
  <!-- 게시글 검색 결과 목록 -->
  <div>
    <table border="1" align="center" class="table">
      <colgroup>
        <col :style="{ width: '10%' }" />
        <col :style="{ width: '50%' }" />
        <col :style="{ width: '10%' }" />
        <col :style="{ width: '25%' }" />
      </colgroup>
      <tr>
        <td>글번호</td>
        <td>제목</td>
        <td>작성자</td>
        <td>작성일</td>
      </tr>
      <tr v-for="(b, index) in boardsearchlist.sList" :key="`${index}_boardsearchlist.bList`">
        <td v-text="b.bnum"></td>
        <td>
          <router-link :to="`/board/detail/${b.bnum}`">{{ b.btitle }}</router-link>
        </td>
        <td v-text="b.bwriter"></td>
        <td v-text="b.bregdate"></td>
      </tr>
    </table>
    <div class="row row-grid justify-content-between align-items-center mt-lg">
      <base-pagination
        :pageCount="boardsearchlist.totalPage"
        :perPage="boardsearchlist.curpage"
        :total="boardsearchlist.totalCount"
        :value="payload.page"
        v-model="payload.page"
        @input="pageMove"
        align="center"
      />
    </div>
    <router-link to="/board/list">목록</router-link>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  computed: {
    ...mapGetters(["boardsearchlist"]),
  },
  data() {
    return {
      payload: {
        page: "1",
        key: "",
        word: "",
      },
    };
  },
  created() {
    this.payload.key = this.$route.params.key;
    this.payload.word = this.$route.params.word;
    this.$store.dispatch("getBoardSearchList", this.payload);
  },
  methods: {
    pageMove(item) {
      this.payload.page = item;
      this.$store.dispatch("getBoardSearchList", this.payload);
    },
  },
};
</script>

<style></style>
