import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: {},
    apt: {},
    aptlist: [],
    aptsearchlist: [],
    aptrent: {},
    aptrentlist: [],
    aptrentsearchlist: [],
    presell: {},
    preselllist: [],
    presellsearchlist: [],
    board: {},
    boardlist: [],
    comment: {},
    commentlist: [],
    conveniencelist: [],
    subwaylist: [],
  },
  mutations: {
    setUser(state, payload) {
      state.user = payload;
    },
    setBoardList(state, payload) {
      state.boardlist = payload;
    },
    setBoard(state, payload) {
      state.board = payload;
    },
    setCommentList(state, payload) {
      state.commentlist = payload;
    },
    setAptList(state, payload) {
      state.aptlist = payload;
    },
    setApt(state, payload) {
      state.apt = payload;
    },
    setAptSearchList(state, payload) {
      state.aptsearchlist = payload;
    },
    setAptRentList(state, payload) {
      state.aptrentlist = payload;
    },
    setAptRent(state, payload) {
      state.aptrent = payload;
    },
    setAptRentSearchList(state, payload) {
      state.aptrentsearchlist = payload;
    },
    setSubwayList(state, payload) {
      state.subwaylist = payload;
    },
  },
  actions: {
    //로그인,로그아웃 및 회원관리

    login(context, payload) {
      http.post("/login", payload).then((resp) => {
        if (resp.data.id != undefined) {
          console.log("로그인 정보 맞음!");
          localStorage.setItem("login", true);
          localStorage.setItem("id", resp.data.id);
          localStorage.setItem("name", resp.data.name);
          resp.data.login = true;
          alert("로그인 되었습니다");
        } else {
          alert("로그인에 실패했습니다. 아이디, 비밀번호를 확인해주세요.");
        }
        context.commit("setUser", resp.data);
      });
    },
    logout(context) {
      console.log("logout");
      context.commit("setUser", "");
      localStorage.setItem("id", "null");
      localStorage.setItem("name", "null");
      localStorage.setItem("login", false);
    },
    join(context, payload) {
      return http.post("/join", payload);
    },
    findPwd(context, payload) {
      console.log(payload.id);
      return http.put("/findpwd", payload);
    },
    getUser(context, payload) {
      http
        .get("/mypage", {
          params: {
            id: payload,
          },
        })
        .then((resp) => {
          context.commit("setUser", resp.data);
        });
    },
    updateUser(context, payload) {
      return http.put("/mypage", payload);
    },
    deleteUser(context, payload) {
      return http.delete("/mypage", {
        params: {
          id: payload,
        },
      });
    },

    // Board 목록 및 관리

    getBoardList(context, payload) {
      console.log(payload.page);
      
      http.get("/board/list/" + payload).then((resp) => {
        console.log(resp.data.bList);
        context.commit("setBoardList", resp.data);
      });
    },

    // getAptList(context, payload) {
    //   console.log(payload.page);
    //   http.get("/apt/list/" + payload).then((resp) => {
    //     console.log(resp.data.aList);
    //     context.commit("setAptList", resp.data);
    //   });
    // },


    getBoard(context, payload) {
      http.get("/board/" + payload.bnum).then((resp) => {
        context.commit("setBoard", resp.data);
      });
    },
    getBoardSearchList(context, payload) {
      return http
        .get("/board/search", {
          params: {
            page: payload.page,
            key: payload.key,
            word: payload.word,
          },
        })
        .then((resp) => {
          context.commit("setBoardList", resp.data);
        });
    },
    writeBoard(context, payload) {
      return http.post("/board", payload);
    },
    updateBoard(context, payload) {
      return http.put("/board", payload);
    },
    deleteBoard(context, payload) {
      console.log(payload);
      return http.delete("/board/" + payload);
    },

    // Comment 목록 및 관리

    getCommentList(context, payload) {
      console.log(payload.page);
      console.log(payload.bn);
      return http
        .get("/comment", {
          params: {
            page: payload.page,
            bnum: payload.bn,
          },
        })
        .then((resp) => {
          context.commit("setCommentList", resp.data);
        });
    },
    writeComment(context, payload) {
      return http.post("/comment", payload);
    },
    updateComment(context, payload) {
      return http.put("/comment", payload);
    },
    deleteComment(context, payload) {
      console.log(payload);
      return http.delete("/comment/" + payload);
    },

    // Apt 매매, 전/월세

    getAptList(context, payload) {
      console.log(payload.page);
      http.get("/apt/list/" + payload).then((resp) => {
        console.log(resp.data.aList);
        context.commit("setAptList", resp.data);
      });
    },
    getApt(context, payload) {
      http.get("/apt/" + payload.aptNo).then((resp) => {
        context.commit("setApt", resp.data);
      });
    },
    getAptSearchList(context, payload) {
      return http
        .get("/apt/search", {
          params: {
            page: payload.page,
            key: payload.key,
            word: payload.word,
          },
        })
        .then((resp) => {
          context.commit("setAptSearchList", resp.data);
        });
    },

    getAptRentList(context, payload) {
      console.log(payload);
      http.get("/rent/list/" + payload).then((resp) => {
        
        console.log(resp);
        context.commit("setAptRentList", resp.data);
      });
    },
    getAptRent(context, payload) {
      http.get("/rent/" + payload.aptNo).then((resp) => {
        context.commit("setAptRent", resp.data);
      });
    },
    getAptRentSearchList(context, payload) {
      return http
        .get("/rent/search", {
          params: {
            page: payload.page,
            key: payload.key,
            word: payload.word,
          },
        })
        .then((resp) => {
          context.commit("setAptRentSearchList", resp.data);
        });
    },

    // Subway 목록

    getSubwayList(context) {
      http.get("/subway/list").then((resp) => {
        context.commit("setSubwayList", resp.data);
      });
    },
  },
  modules: {},
  getters: {
    user(state) {
      return state.user;
    },
    boardlist(state) {
      return state.boardlist;
    },
    board(state) {
      return state.board;
    },
    commentlist(state) {
      return state.commentlist;
    },
    aptlist(state) {
      return state.aptlist;
    },
    apt(state) {
      return state.apt;
    },
    aptsearchlist(state) {
      return state.aptsearchlist;
    },
    aptrentlist(state) {
      return state.aptrentlist;
    },
    aptrent(state) {
      return state.aptrent;
    },
    aptrentsearchlist(state) {
      return state.aptrentsearchlist;
    },
    subwaylist(state) {
      return state.subwaylist;
    },
  },
});
