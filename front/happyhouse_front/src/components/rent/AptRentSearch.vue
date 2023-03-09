<template>
  <!-- 아파트 전/월세 검색 Form -->
  <div>
    <form class="form-inline">
      <div class="form group">
        <select v-model="search.key" class="form-control">
          <option disabled value="">선택</option>
          <option value="aptName">아파트 이름</option>
          <option value="dong">법정동</option>
        </select>
      </div>
      <base-input class="form-group" placeholder="검색어를 입력해주세요" v-model="search.word">
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
export default {
  name: "search",
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
      this.$router.push(`/rent/search/${this.search.key}/${this.search.word}`);
    },
  },
};
</script>

<style></style>
