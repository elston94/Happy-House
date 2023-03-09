<template>
  <!-- 게시글 Row Component -->
  <tr>
    <td>{{ bnum }}</td>
    <td>
      <router-link :to="`/board/detail/${bnum}`" style="color: black">{{ btitle }}</router-link>
    </td>
    <td>{{ bwriter }}</td>
    <td>{{ bregdate }}</td>
  </tr>
</template>

<script>
export default {
  name: "Row",
  props: {
    bnum: { type: Number },
    bwriter: { type: String },
    btitle: { type: String },
    bregdate: { type: String },
  },
  methods: {},
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Nanum+Gothic&display=swap");
td,
router-link {
  font-family: "Nanum Gothic", sans-serif;
}
</style>
