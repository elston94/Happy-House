<template>
  <!-- 회원탈퇴 -->
  <div>
    <div class="profile-page">
      <section class="section-profile-cover section-shaped my-0"></section>
      <div class="container">
        <card shadow class="card-profile mt--300" no-body>
          <div class="px-4">
            <div class="row justify-content-center">
              <div class="row justify-content-center">
                <h2 class="mt-5">탈퇴하시겠습니까?</h2>
                <base-button
                  block
                  type="danger"
                  class="mr-4 col-3 mt-5"
                  @click="deleteSubmit"
                  >회원탈퇴</base-button
                >
              </div>
            </div>
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
    deleteSubmit() {
      this.$store.dispatch("deleteUser", this.user.id).then((resp) => {
        let msg = "회원 탈퇴 중 오류가 발생하였습니다.";
        if (resp.data === "success") {
          this.$store.dispatch("logout");
          msg = "회원 탈퇴 완료되었습니다.";
        }
        alert(msg);
        this.$router.push("/");
      });
    },
  },
};
</script>

<style></style>
