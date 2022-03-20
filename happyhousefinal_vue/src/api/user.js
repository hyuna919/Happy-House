import { apiInstance } from "./instance.js";

const api = apiInstance();

function login(user, success, fail) {
  api
    .get(`/user/login/${user.userId}/${user.userPw}`)
    .then(success)
    .catch(fail);
}

async function findById(userId) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  return await api.get(`/user/${userId}`);
}

async function regist(joinInfo) {
  await api.post(`/user`, JSON.stringify(joinInfo));
}

function update(userInfo, success, fail) {
  api.put(`user`, userInfo).then(success).catch(fail);
}

async function getUserList(page) {
  console.log("page " + page.pg);
  return await api.get(`/user`, { params: page });
}

async function remove(userId) {
  return await api.delete(`/user/${userId}`);
}

async function execPasswordMail(userId) {
  await api.post(`/user/password/${userId}`);
}

export {
  login,
  findById,
  regist,
  update,
  getUserList,
  remove,
  execPasswordMail,
};
