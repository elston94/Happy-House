<template>
  <!-- 댓글 목록 및 관리-->
  <fieldset class="mt-5">
    <legend>댓글</legend>
    <div class="ddd">
      <v-simple-table v-for="(c, index) in commentlist.cList" :key="index">
        <tr>
          <td>작성자</td>
          <td>{{ c.cwriter }}</td>
          <td>내용</td>
          <td>{{ c.ccontent }}</td>
          <td>
            <base-button
              type="secondary"
              size="sm"
              class="float-right"
              v-if="c.cwriter === user.id"
              @click.prevent="commentDelete(c.cnum)"
            >
              삭제
            </base-button>
          </td>
        </tr>
      </v-simple-table>
    </div>
    <div align="left">
      <form>
        <textarea
          class="form-control"
          id="exampleFormControlTextarea1"
          rows="3"
          placeholder="댓글 내용을 작성해주세요"
          v-model="comment.ccontent"
        ></textarea>
        <base-button
          type="primary"
          size="sm"
          class="float-right mt-3"
          @click.prevent="commentSubmit"
        >
          댓글작성
        </base-button>
      </form>
    </div>
  </fieldset>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  computed: {
    ...mapGetters(["commentlist"]),
    ...mapGetters(["user"]),
  },
  props: ["bnnn"],
  data() {
    return {
      bn: this.bnnn,
      payload: {
        page: "1",
      },
      comment: {
        bnum: "",
        cwriter: "",
        ccontent: "",
      },
    };
  },
  watch: {
    bnnn() {
      console.log("change bnnn:" + this.bnnn);
      this.payload.bn = this.bnnn;
      this.comment.bnum = this.bnnn;
      this.$store.dispatch("getCommentList", this.payload);
    },
  },
  methods: {
    commentSubmit() {
      this.comment.cwriter = this.user.id;
      this.$store.dispatch("writeComment", this.comment).then((resp) => {
        let msg = "댓글 등록에 실패하였습니다.";
        if (resp.data === "success") {
          msg = "댓글 등록이 완료되었습니다.";
        }
        alert(msg);
        this.$store.dispatch("getCommentList", this.payload);
      });
    },
    commentDelete(cnum) {
      this.$store.dispatch("deleteComment", cnum).then((resp) => {
        let msg = "댓글 등록에 실패하였습니다.";
        if (resp.data === "success") {
          msg = "댓글이 삭제되었습니다.";
        }
        alert(msg);
        this.$store.dispatch("getCommentList", this.payload);
      });
    },
  },
};
</script>

<style>
.comment-btn {
  display: flex;
  text-align: right;
}
td {
  white-space: inherit;
}
.ddd {
  width: 300px;
}
</style>
