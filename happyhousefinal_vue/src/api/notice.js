import { apiInstance } from "./instance.js";

const api = apiInstance();

// 목록
async function listArticle(page) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  return await api.get(`/notice`, { params: page });
}

// 번호로 조회
async function getArticle(no) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  return await api.get(`/notice/${no}`);
}

// 글 작성
async function writeArticle(notice) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  return await api.post(`/notice`, notice);
}

// 글 수정
async function modifyArticle(notice) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  return await api.put(`/notice/`, notice);
}

// 글 삭제
async function deleteArticle(no) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  return await api.delete(`/notice/${no}`);
}

export { listArticle, getArticle, writeArticle, modifyArticle, deleteArticle };
