<template>
  <!-- 로그인 Form -->
  <div>
    <div class="container pt-lg-md findpwd">
      <div class="row justify-content-center">
        <div class="col-lg-7">
          <card
            type="secondary"
            shadow
            header-classes="bg-white pb-7"
            body-classes="px-lg-7 py-lg-7"
            class="border-0"
          >
            <template>
              <form role="form">
                <base-input
                  alternative
                  class="mb-5"
                  placeholder="ID"
                  addon-left-icon="ni ni-single-02"
                  v-model="user.id"
                >
                </base-input>
                <base-input
                  alternative
                  type="password"
                  placeholder="Password"
                  addon-left-icon="ni ni-lock-circle-open"
                  v-model="user.pwd"
                >
                </base-input>
                <div class="text-center">
                  <base-button type="primary" class="my-4" @click="login"
                    >로그인</base-button
                  >
                </div>
              </form>
            </template>
          </card>
          <div class="aaa">
            <div class="row mt-1">
              <div class="col-5">
                <b-button variant="light" @click="findpwd"
                  >비밀번호 찾기</b-button
                >
              </div>
              <div class="col-5">
                <b-button variant="light" @click="moveJoin">회원가입</b-button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  created() {},
  data() {
    return {
      user: {
        id: "",
        pwd: "",
      },
    };
  },
  methods: {
    login() {
      this.$store.dispatch("login", this.user);
      this.$router.push("/");
    },
    findpwd() {
      this.$router.push("/findpwd");
    },
    moveJoin() {
      this.$router.push("/join");
    },
  },
};
</script>

<style>
.aaa {
  padding-left: 15%;
}
</style>
