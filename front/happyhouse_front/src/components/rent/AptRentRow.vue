<template>
  <!-- 아파트 전/월세 Row Component -->
  <tr>
    <td>{{ no }}</td>
    <td>{{ dong }}</td>
    <td>
      <router-link :to="`/rent/detail/${no}`" style="color: black">{{ aptName }}</router-link>
    </td>
    <td>{{ rentMoney }}</td>
    <td>{{ deposit }}</td>
    <td>{{ area }}</td>
  </tr>
</template>

<script>
export default {
  name: "AptRentRow",
  props: {
    no: { type: Number },
    dong: { type: String },
    aptName: { type: String },
    rentMoney: { type: String },
    deposit: { type: String },
    area: { type: String },
  },
  methods: {},
};
</script>

<style></style>
