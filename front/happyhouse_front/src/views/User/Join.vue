<template>
  <!-- 회원가입 Form -->
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

                <base-input
                  alternative
                  class="mb-5"
                  placeholder="Name"
                  addon-left-icon="ni ni-hat-3"
                  v-model="user.name"
                >
                </base-input>
                <base-input
                  alternative
                  class="mb-5"
                  placeholder="Email"
                  addon-left-icon="ni ni-email-83"
                  v-model="user.email"
                >
                </base-input>
                <div class="text-center">
                  <base-button type="primary" class="my-4" @click="joinSubmit"
                    >회원가입</base-button
                  >
                </div>
              </form>
            </template>
          </card>
          <br />
          <b-button variant="light" @click="login">로그인</b-button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "Join",
  data() {
    return {
      user: {
        id: "",
        pwd: "",
        name: "",
        email: "",
      },
    };
  },
  methods: {
    joinSubmit() {
      if (this.user.id == "") {
        alert("아이디를 입력하세요.");
      } else if (this.user.name == "") {
        alert("이름을 입력하세요.");
      } else if (this.user.pwd == "") {
        alert("비밀번호를 입력하세요.");
      } else if (this.user.email == "") {
        alert("이메일을 입력하세요.");
      } else {
        this.$store.dispatch("join", this.user).then((resp) => {
          let msg = "회원가입에 실패했습니다.";
          if (resp.data === "success") {
            msg = "회원가입 되었습니다.";
          }
          alert(msg);
          this.$router.push("/");
        });
        this.$emit("change", 0);
      }
    },
    login() {
      this.$emit("change", 0);
    },
  },
};
</script>

<style></style>
