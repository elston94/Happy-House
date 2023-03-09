<template lang="">
  <!-- 게시글 수정 -->
  <div>
    <form>
      제목 : <base-input type="text" v-model="board.btitle" /><br />
      내용 :
      <textarea
        v-model="board.bcontent"
        class="form-control"
        rows="3"
      ></textarea
      ><br />
      <base-button
        @click.prevent="boardSubmit"
        type="primary"
        size="sm"
        class="float mt-3 mb-3"
        >수정하기</base-button
      >
    </form>
    <router-link to="/board">목록</router-link>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
export default {
  computed: {
    ...mapGetters(["board"]),
  },
  created() {
    let bnum = this.$route.params.no;
    this.$store.dispatch("getBoard", { bnum });
  },
  methods: {
    boardSubmit() {
      this.$store.dispatch("updateBoard", this.board).then((resp) => {
        let msg = "게시물 수정에 실패하였습니다.";
        if (resp.data === "success") {
          msg = "게시물 수정이 완료되었습니다.";
        }
        alert(msg);
        this.$router.push("/board/detail/" + this.board.bnum);
      });
    },
  },
};
</script>
<style lang=""></style>
