<template>
  <!-- 회원정보 조회 -->
  <div>
    <v-simple-table>
      <template>
        <thead>
          <tr>
            <th class="text-left">작성자</th>
            <th class="text-left">제목</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(board, index) in boardlist" :key="index">
            <td v-html="board.bwriter"></td>
            <td v-html="board.btitle"></td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>

    <button
      class="addBtn notice-add-btn"
      type="button"
      @click="gotoboardList()"
    >
      더보기
    </button>
  </div>
</template>

<script>
import http from "@/util/http-common";
import { mapGetters } from "vuex";
export default {
  data() {
    return {
      boardlist: [],
      headers: [
        { text: "작성자", value: "bwriter" },
        { text: "제목", value: "btitle" },
      ],
    };
  },
  computed: {
    ...mapGetters(["user"]),
  },
  created() {
    this.getHomeBoard();
  },
  methods: {
    getHomeBoard() {
      http.get("/board/list").then(({ data }) => {
        this.boardlist = data;
      });
    },
    gotoboardList() {
      if (this.user.login != true) {
        alert("로그인 후 이용 가능합니다.");
        this.$router.push("/");
      } else {
        this.$router.push("/board/list");
      }
    },
  },
};
</script>

<style></style>
