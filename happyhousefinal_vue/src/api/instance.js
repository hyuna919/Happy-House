import axios from "axios";
import { API_BASE_URL, APT_HOUSE_URL, QNA_URL } from "@/config/http-common.js";

// 사용 안하는것 때문에 에러나서

// axios 객체 생성
function apiInstance() {
  const instance = axios.create({
    baseURL: API_BASE_URL,
    headers: {
      "Content-type": "application/json",
    },
  });
  return instance;
}

function houseInstance() {
  const instance = axios.create({
    baseURL: APT_HOUSE_URL,
    headers: {
      "Content-type": "application/json",
    },
  });
  return instance;
}

function qnaInstance() {
  const instance = axios.create({
    baseURL: QNA_URL,
    headers: {
      "Content-type": "application/json",
    },
  });
  return instance;
}

export { apiInstance, houseInstance, qnaInstance };
