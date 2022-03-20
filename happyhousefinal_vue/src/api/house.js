import { houseInstance } from "./instance.js";

const house = houseInstance();

function sidoList(success, fail) {
  house.get(`/sido`).then(success).catch(fail);
}

function gugunList(params, success, fail) {
  house.get(`/gugun`, { params: params }).then(success).catch(fail);
}

function dongList(params, success, fail) {
  house.get(`/dong`, { params: params }).then(success).catch(fail);
}

function houseList(params, success, fail) {
  house.get(`/apt`, { params: params }).then(success).catch(fail);
}

function houseLikeList(params, success, fail) {
  house.get(`/aptLike`, { params: params }).then(success).catch(fail);
}

export { sidoList, gugunList, dongList, houseList, houseLikeList };
