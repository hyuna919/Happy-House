import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/Home.vue";
import House from "@/views/House.vue";
import MyPage from "@/views/MyPage.vue";
import Qna from "@/views/Qna.vue";
import Sign from "@/views/Sign.vue";
import Admin from "@/views/Admin.vue";
import Notice from "@/views/Notice.vue";

import Login from "@/components/user/Login.vue";
import UserJoin from "@/components/user/UserJoin.vue";
import UserUpdate from "@/components/user/UserUpdate.vue";
import UserPassword from "@/components/user/UserPassword.vue";
import Likes from "@/components/user/Likes.vue";

import QnaList from "@/components/qna/QnaList.vue";
import QnaView from "@/components/qna/QnaView.vue";
import QnaWrite from "@/components/qna/QnaWrite.vue";
import QnaUpdate from "@/components/qna/QnaUpdate.vue";

import NoticeList from "@/components/notice/NoticeList.vue";
import NoticeView from "@/components/notice/NoticeView.vue";
import NoticeWrite from "@/components/notice/NoticeWrite.vue";
import NoticeUpdate from "@/components/notice/NoticeUpdate.vue";

import AdminUserList from "@/components/admin/AdminUserList.vue";
// import store from "@/store/index.js";

Vue.use(VueRouter);

// const onlyAuthUser = async (to, from, next) => {
//   // console.log(store);
//   const checkUserInfo = store.getters["userStore/checkUserInfo"];
//   const getUserInfo = store._actions["userStore/getUserInfo"];
//   let token = sessionStorage.getItem("access-token");
//   if (checkUserInfo == null && token) {
//     await getUserInfo(token);
//   }
//   if (checkUserInfo === null) {
//     alert("로그인이 필요한 페이지입니다..");
//     // next({ name: "SignIn" });
//     router.push({ name: "SignIn" });
//   } else {
//     console.log("로그인 했다.");
//     next();
//   }
// };

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/sign",
    name: "Sign",
    component: Sign,
    redirect: "/sign/login",
    children: [
      {
        path: "login",
        name: "Login",
        component: Login,
      },
      {
        path: "join",
        name: "UserJoin",
        component: UserJoin,
      },
      {
        path: "password",
        name: "UserPassword",
        component: UserPassword,
      },
    ],
  },
  {
    path: "/admin",
    name: "Admin",
    component: Admin,
    redirect: "/admin/userlist",
    children: [
      {
        path: "userlist",
        name: "AdminUserList",
        component: AdminUserList,
      },
    ],
  },
  {
    path: "/house",
    name: "House",
    component: House,
  },
  {
    path: "/qna",
    name: "Qna",
    component: Qna,
    redirect: "/qna/list",
    children: [
      {
        path: "list",
        name: "QnaList",
        component: QnaList,
      },
      {
        path: "view",
        name: "QnaView",
        component: QnaView,
      },
      {
        path: "write",
        name: "QnaWrite",
        component: QnaWrite,
      },
      {
        path: "update",
        name: "QnaUpdate",
        component: QnaUpdate,
      },
    ],
  },
  {
    path: "/mypage",
    name: "MyPage",
    component: MyPage,
    redirect: "/mypage/update",
    children: [
      {
        path: "update",
        name: "UserUpdate",
        component: UserUpdate,
      },
      {
        path: "likes",
        name: "Likes",
        component: Likes,
      },
    ],
  },
  {
    path: "/notice",
    name: "Notice",
    component: Notice,
    redirect: "/notice/list",
    children: [
      {
        path: "list",
        name: "NoticeList",
        component: NoticeList,
      },
      {
        path: "view",
        name: "NoticeView",
        component: NoticeView,
      },
      {
        path: "write",
        name: "NoticeWrite",
        component: NoticeWrite,
      },
      {
        path: "update",
        name: "NoticeUpdate",
        component: NoticeUpdate,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
