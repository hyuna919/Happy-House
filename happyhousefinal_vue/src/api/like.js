import { apiInstance } from "./instance.js";

const api = apiInstance();

function likeList(params, success, fail) {
  api.get(`/like`, { params: params }).then(success).catch(fail);
}

function unlike(params, success, fail) {
  api
    .delete(`/like`, {
      params: { userId: params.userId, houseNo: params.houseNo },
    })
    .then(success)
    .catch(fail);
}

function like(params, success, fail) {
  api
    .post(
      `/like`,
      {},
      {
        params: { userId: params.userId, houseNo: params.houseNo },
      }
    )
    .then(success)
    .catch(fail);
}

export { likeList, unlike, like };
