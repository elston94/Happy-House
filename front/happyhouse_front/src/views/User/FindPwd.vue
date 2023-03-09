<template>
  <!-- 비밀번호 찾기 Form -->
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
                  placeholder="EMAIL"
                  addon-left-icon="ni ni-email-83"
                  v-model="user.email"
                >
                </base-input>
                <div class="text-center">
                  <base-button
                    type="primary"
                    class="my-4"
                    @click.prevent="findpwd"
                    >임시비밀번호 전송</base-button
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
import { mapGetters } from "vuex";
import BaseButton from "../../components/argon/BaseButton.vue";
export default {
  components: { BaseButton },
  name: "findpwd",
  data() {
    return {
      user: {
        id: "",
        email: "",
      },
    };
  },
  methods: {
    findpwd() {
      this.$store.dispatch("findPwd", this.user).then((resp) => {
        let msg = resp.data;
        if (msg === "success") {
          msg = "메일이 성공적으로 발송되었습니다.";
        }
        alert(msg);
        this.$emit("change", 0);
      });
    },
    login() {
      this.$emit("change", 0);
    },
  },
};
</script>

<style></style>
