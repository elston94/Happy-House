<template>
  <!-- 게시판 검색 Form -->
  <div>
    <form class="form-inline">
      <div class="form group">
        <select v-model="search.key" class="form-control">
          <option disabled value="">선택</option>
          <option value="btitle">제목</option>
          <option value="bnum">글 번호</option>
          <option value="bwriter">작성자</option>
        </select>
      </div>
      <base-input
        class="form-group"
        @keypress.enter="searchSubmit"
        placeholder="검색어를 입력해주세요"
        v-model="search.word"
      >
      </base-input>
      <base-button
        type="secondary"
        class="form-control my-4 form-group"
        @click.prevent="searchSubmit"
        >검색</base-button
      >
    </form>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "search",
  computed: {
    ...mapGetters(["user"]),
  },
  data() {
    return {
      search: {
        key: "",
        word: "",
      },
    };
  },
  methods: {
    searchSubmit() {
      this.$store.dispatch("getBoardSearchList", this.search);
    },
  },
};
</script>

<style></style>
