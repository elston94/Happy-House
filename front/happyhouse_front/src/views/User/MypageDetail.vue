<template>
  <!-- 회원정보 조회 -->
  <div>
    <div class="profile-page">
      <section class="section-profile-cover section-shaped my-0"></section>
      <div class="container">
        <card shadow class="card-profile mt--300" no-body>
          <div class="px-4">
            <div class="row justify-content-center">
              <div class="col-lg-4 order-lg-3 text-lg align-self-lg-center">
                <div class="card-profile-actions py-4 mt-lg-0">
                  <b-button variant="light" @click="moveUpdate"
                    >회원정보 수정</b-button
                  >
                  <b-button variant="light" @click="moveDelete"
                    >회원탈퇴</b-button
                  >
                </div>
              </div>
            </div>

            <table border="1" align="center" class="table">
              <tr>
                <th>이름</th>
                <th>아이디</th>
                <th>이메일</th>
              </tr>
              <tr>
                <td>{{ user.name }}</td>
                <td>{{ user.id }}</td>
                <td>{{ user.email }}</td>
              </tr>
            </table>
            <div class="mt-5 py-5 border-top text-center">
              <div class="row justify-content-center">
                <div class="col-lg-9"></div>
              </div>
            </div>
          </div>
        </card>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  computed: {
    ...mapGetters(["user"]),
  },
  methods: {
    moveUpdate() {
      this.$router.push("/mypage/update");
    },
    moveDelete() {
      this.$router.push("/mypage/delete");
    },
  },
};
</script>

<style></style>
