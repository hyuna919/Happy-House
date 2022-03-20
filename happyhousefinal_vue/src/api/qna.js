import { qnaInstance } from "./instance.js";

const api = qnaInstance();

// 목록
async function listArticle(page) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  return await api.get(``, { params: page });
}

// 번호로 조회
async function getArticle(no) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  return await api.get(`/${no}`);
}

// 글 작성
async function writeArticle(qna) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  return await api.post(``, qna);
}

// 글 수정
async function modifyArticle(qna) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  return await api.put(`/`, qna);
}

// 글 삭제
async function deleteArticle(no) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  return await api.delete(`/${no}`);
}

async function modifyAnswer(qna) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  return await api.put(`/answer`, qna);
}

async function deleteAnswer(no) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  return await api.delete(`/answer/${no}`);
}

export {
  listArticle,
  getArticle,
  writeArticle,
  modifyArticle,
  deleteArticle,
  modifyAnswer,
  deleteAnswer,
};
