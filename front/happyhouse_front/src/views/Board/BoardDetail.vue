<template>
  <!-- 게시글 상세 조회 -->
  <div>
    <table border="1" class="table mt-5">
      <tr>
        <td>제목</td>
        <td>{{ board.btitle }}</td>
      </tr>
      <tr>
        <td>작성자</td>
        <td>{{ board.bwriter }}</td>
      </tr>
      <tr>
        <td>등록일</td>
        <td v-text="formatDate(board.bregdate)"></td>
      </tr>
      <tr>
        <td>내용</td>
        <td>{{ board.bcontent }}</td>
      </tr>
    </table>
    <div v-if="board.bwriter === user.id">
      <router-link :to="`/board/update/${board.bnum}`">수정하기</router-link> |
      <router-link :to="`/board/delete/${board.bnum}`">삭제하기</router-link>
    </div>
    <comment :bnnn="board.bnum"></comment>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import Comment from "@/components/board/Comment.vue";
import moment from "moment";
export default {
  components: { Comment },
  computed: {
    ...mapGetters(["board"]),
    ...mapGetters(["user"]),
  },
  data() {
    return {
      id: "",
    };
  },
  component: {
    Comment,
  },
  created() {
    let bnum = this.$route.params.no;
    this.$store.dispatch("getBoard", { bnum });
    this.id = localStorage.getItem("id");
  },
  methods: {
    formatDate(date) {
      return moment(new Date(date)).format("YYYY.MM.DD HH:mm");
    },
  },
};
</script>

<style></style>
