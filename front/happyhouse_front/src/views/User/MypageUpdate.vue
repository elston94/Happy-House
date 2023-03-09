<template>
  <!-- 회원정보 수정 Form -->
  <div>
    <div class="profile-page">
      <section class="section-profile-cover section-shaped my-0"></section>
      <div class="container">
        <card shadow class="card-profile mt--300" no-body>
          <div class="px-4">
            <div class="row justify-content-center text-center">
              <form class="col-md-6 center justify-content-center">
                <br />
                <div>
                  <label>ID</label>
                  <base-input type="text" v-model="user.id" disabled></base-input>
                </div>
                <div>
                  <label>비밀번호</label>
                  <base-input type="text" v-model="user.pwd"></base-input>
                </div>
                <div>
                  <label>이름</label>
                  <base-input type="text" v-model="user.name"></base-input>
                </div>
                <div>
                  <label>EMAIL</label>
                  <base-input type="text" v-model="user.email"></base-input>
                </div>
                <base-button type="primary" size="m" @click="mypageSubmit()">수정</base-button>
              </form>
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
  created() {},
  methods: {
    mypageSubmit() {
      this.$store.dispatch("updateUser", this.user).then((resp) => {
        let msg = "회원정보 수정에 실패하였습니다.";
        if (resp.data === "success") {
          msg = "회원정보 수정이 완료되었습니다.";
        }
        alert(msg);
      });
      this.$router.push("/mypage/detail/");
    },
  },
};
</script>

<style></style>
