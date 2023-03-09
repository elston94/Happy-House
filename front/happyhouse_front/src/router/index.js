import Vue from "vue";
import VueRouter from "vue-router";

// import Home from "../views/Home.vue";
import Main from "../views/Main.vue";

import MainLogin from "@/views/User/MainLogin.vue";
import FindPwd from "@/views/User/FindPwd.vue";
import Login from "@/views/User/Login.vue";
import Logout from "@/views/User/Logout.vue";
import Join from "@/views/User/Join.vue";
import Mypage from "@/views/User/Mypage.vue";
import MypageDetail from "@/views/User/MypageDetail.vue";
import MypageUpdate from "@/views/User/MypageUpdate.vue";
import MypageDelete from "@/views/User/MypageDelete.vue";

import Apt from "@/views/Apt/Apt.vue";
import AptDetail from "@/views/Apt/AptDetail.vue";
import AptList from "@/views/Apt/AptList.vue";
import AptSearchResult from "@/views/Apt/AptSearchResult.vue";

import AptRent from "@/views/Rent/AptRent.vue";
import AptRentDetail from "@/views/Rent/AptRentDetail.vue";
import AptRentList from "@/views/Rent/AptRentList.vue";
import AptRentSearchResult from "@/views/Rent/AptRentSearchResult.vue";

import Board from "@/views/Board/Board.vue";
import BoardDetail from "@/views/Board/BoardDetail.vue";
import BoardList from "@/views/Board/BoardList.vue";
import BoardUpdate from "@/views/Board/BoardUpdate.vue";
import BoardWrite from "@/views/Board/BoardWrite.vue";
import BoardDelete from "@/views/Board/BoardDelete.vue";
import BoardSearchResult from "@/views/Board/BoardSearchResult.vue";

import News from "@/views/News";

Vue.use(VueRouter);

const routes = [
  {
    path: "/test",
    name: "MainLogin",
    component: MainLogin,
  },
  // 로그인 관련 route
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/findpwd",
    name: "FindPwd",
    component: FindPwd,
  },
  {
    path: "/logout",
    name: "Logout",
    component: Logout,
  },
  {
    path: "/join",
    name: "Join",
    component: Join,
  },
  {
    path: "/",
    name: "Main",
    component: Main,
  },
  // 마이페이지 route
  {
    path: "/mypage",
    name: "Mypage",
    component: Mypage,
    children: [
      {
        path: "detail",
        name: "MypageDetail",
        component: MypageDetail,
      },
      {
        path: "update",
        name: "MypageUpdate",
        component: MypageUpdate,
      },
      {
        path: "delete",
        name: "MypageDelete",
        component: MypageDelete,
      },
    ],
  },
  // 아파트 매매 route
  {
    path: "/apt",
    name: "Apt",
    component: Apt,
    redirect: "apt/list",
    children: [
      {
        path: "list",
        name: "AptList",
        component: AptList,
      },
      {
        path: "detail/:no",
        name: "AptDetail",
        component: AptDetail,
      },
      {
        path: "search/:key/:word",
        name: "AptSearchResult",
        component: AptSearchResult,
      },
    ],
  },
  // 아파트 전/월세 route
  {
    path: "/rent",
    name: "Rent",
    component: AptRent,
    redirect: "rent/list",
    children: [
      {
        path: "list",
        name: "AptRentList",
        component: AptRentList,
      },
      {
        path: "detail/:no",
        name: "AptRentDetail",
        component: AptRentDetail,
      },
      {
        path: "search/:key/:word",
        name: "AptRentSearchResult",
        component: AptRentSearchResult,
      },
    ],
  },
  // 게시판 route
  {
    path: "/board",
    name: "Board",
    component: Board,
    redirect: "/board/list",
    children: [
      {
        path: "list",
        name: "BoardList",
        component: BoardList,
      },
      {
        path: "detail/:no",
        name: "BoardDetail",
        component: BoardDetail,
      },
      {
        path: "write",
        name: "BoardWrite",
        component: BoardWrite,
      },
      {
        path: "update/:no",
        name: "BoardUpdate",
        component: BoardUpdate,
      },
      {
        path: "delete/:no",
        name: "BoardDelete",
        component: BoardDelete,
      },
      {
        path: "search/:key/:word",
        name: "BoardSearchResult",
        component: BoardSearchResult,
      },
    ],
  },

  {
    path: "/news",
    name: "News",
    component: News,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
