<template>
  <!-- 게시글 작성 -->
  <div>
    <br />
    <div class="row justify-content-center text-center">
      <form class="col-md-6">
        <div>
          <base-input
            type="text"
            style="width: 100%"
            v-model="board.btitle"
            placeholder="제목"
            class="align-center"
          ></base-input>
        </div>
        <div>
          <textarea
            style="width: 100%; height: 450px"
            class="form-control"
            id="exampleFormControlTextarea1"
            rows="3"
            placeholder="게시글 내용을 작성해주세요"
            v-model="board.bcontent"
          ></textarea>
          <br />

          <base-button type="secondary" size="m" @click="boardSubmit"> 게시글작성 </base-button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  computed: {
    ...mapGetters(["user"]),
  },
  data() {
    return {
      board: {
        btitle: "",
        bwriter: this.$store.state.user.id,
        bcontent: "",
      },
    };
  },
  created() {},
  methods: {
    boardSubmit() {
      this.$store.dispatch("writeBoard", this.board).then((resp) => {
        let msg = "게시물 등록에 실패했습니다.";
        if (resp.data === "success") {
          msg = "게시물 등록이 완료되었습니다.";
        }
        alert(msg);
      });
      this.$router.push("/board/list");
    },
  },
};
</script>

<style>
/* form {
  text-align: center;
  justify-content: center;
  align-items: center;
} */
</style>
