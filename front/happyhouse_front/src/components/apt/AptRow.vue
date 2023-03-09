<template>
  <!-- 아파트 매매 Row Component -->
  <tr>
    <td>{{ no }}</td>
    <td>{{ dong }}</td>
    <td>
      <router-link :to="`/apt/detail/${no}`" style="color: black">{{ aptName }}</router-link>
    </td>
    <td>{{ dealAmount }}</td>
    <td>{{ area }}</td>
  </tr>
</template>

<script>
export default {
  name: "Row",
  props: {
    no: { type: Number },
    dong: { type: String },
    aptName: { type: String },
    dealAmount: { type: String },
    area: { type: String },
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
