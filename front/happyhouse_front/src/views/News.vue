<template>
  <div>
    <v-container>
      <v-row>
        <!-- <h1>검색하려는 키워드를 입력하세요</h1> -->
        <v-col cols="20" sm="6" md="3">
          <v-text-field
            label="Solo"
            placeholder="News Keyword"
            solo
            v-model="keyword"
            @keyup.enter="searchApi"
          ></v-text-field>
        </v-col>
        <v-col cols="4"> </v-col>
      </v-row>
    </v-container>

    <v-container>
      <v-card-title>
        <h1>부동산 뉴스</h1>
        <v-spacer></v-spacer>
        <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="Search"
          single-line
          hide-details
        ></v-text-field>
      </v-card-title>
      <v-data-table
        :headers="headers"
        :items="items"
        :items-per-page="7"
        :search="search"
        :footer-props="{
          showFirstLastPage: true,
          firstIcon: 'mdi-arrow-collapse-left',
          lastIcon: 'mdi-arrow-collapse-right',
          prevIcon: 'mdi-minus',
          nextIcon: 'mdi-plus',
        }"
      >
        <template v-slot:body="{ items }">
          <tbody>
            <tr
              v-for="(item, index) in items"
              :key="index"
              @click="handleClick(item)"
            >
              <td v-html="item.title"></td>
              <td v-html="item.description"></td>
              <td v-html="item.pubDate"></td>
            </tr>
          </tbody>
        </template>
      </v-data-table>
    </v-container>
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
        { text: "날짜", value: "pubDate" },
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
  watch: {
    keyword() {
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
  },
};
</script>

<style></style>
