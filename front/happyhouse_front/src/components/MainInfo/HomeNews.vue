<template>
  <div>
    <v-data-table :headers="headers" :items="items" :items-per-page="3">
      <template v-slot:body="{ items }">
        <tbody>
          <tr
            v-for="(item, index) in items"
            :key="index"
            @click="handleClick(item)"
          >
            <td v-html="item.title"></td>
            <td v-html="item.description"></td>
          </tr>
        </tbody>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      search: "",
      keyword: "",
      items: [],
      headers: [
        { text: "제목", value: "title" },
        { text: "내용", value: "description" },
      ],
      dialog: false,
    };
  },
  created() {
    axios
      .get("http://localhost:9999/happyhouse/api/news/부동산")
      .then(({ data: { items } }) => {
        // console.log(items);
        this.items = items;
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods: {
    searchApi() {
      const word = this.keyword + " 부동산";
      axios
        .get("http://localhost:9999/happyhouse/api/news/" + word)
        .then(({ data: { items } }) => {
          console.log(items);
          this.items = items;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    handleClick(value) {
      console.log(value);
      const url = value.link;
      const name = "네이버 뉴스";
      const specs =
        "width=1000, height=800, top=200, left=200, toolbar=no, menubar=no, scrollbars=yes, resizable=yes";
      window.open(url, name, specs);
    },
  },
};
</script>

<style></style>
