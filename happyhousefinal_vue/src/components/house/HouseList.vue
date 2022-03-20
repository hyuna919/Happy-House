<template>
  <div>
    <input
      type="text"
      v-model="word"
      placeholder="검색할 아파트 이름을 입력하세요"
    />
    <b-container
      v-if="houses && houses.length != 0"
      class="bv-example-row mt-3"
    >
      <div
        v-for="(house, index) in houses"
        :key="index"
        v-if="house.aptName.includes(word)"
      >
        <b-row class="m-2" @click="selectHouse(house)">
          <b-col cols="10">
            [{{ house.no }}] : {{ house.aptName }}
            <img
              v-if="house.userId != null"
              src="@/assets/house/fullheart.png"
              alt="unlike"
              @click="unlike(house.no)"
            />
            <img
              v-else
              src="@/assets/house/heart.png"
              alt="unlike"
              @click="setlike(house.no)"
            />
            <br />
          </b-col>
        </b-row>
      </div>
    </b-container>
    <b-container v-else class="bv-example-row mt-3">
      <b-row>
        <b-col><b-alert show>주택 목록이 없습니다.</b-alert></b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import { mapState } from "vuex";
// 카카오맵으로 찜하기 옮기기?
const houseStore = "houseStore";
const likeStore = "likeStore";
const userStore = "userStore";

export default {
  name: "HouseList",
  data() {
    return { word: "", isColor: false, heartCraeate: false, count: 1 };
  },
  computed: {
    ...mapState(houseStore, ["houses", "gugunCode", "dongName"]),
    ...mapState(likeStore, ["likes"]),
    ...mapState(userStore, ["userInfo"]),
  },

  methods: {
    ...mapActions(houseStore, ["detailHouse", "getHouseList"]),
    ...mapActions(likeStore, ["deleteLike", "setLike"]),

    selectHouse(house) {
      this.detailHouse(house);
    },

    setlike(houseNo) {
      const params = {
        userId: this.userInfo.userId,
        houseNo: houseNo,
      };
      this.setLike(params);
      alert(houseNo + "번 매물이 찜 되었습니다!!");
      this.aptListReloading();
    },
    unlike(houseNo) {
      const params = {
        userId: this.userInfo.userId,
        houseNo: houseNo,
      };
      this.deleteLike(params);
      alert(houseNo + "번 매물이 찜 취소되었습니다!!");
      this.aptListReloading();
    },
    aptListReloading() {
      const params = {
        dong: this.dongName,
        gugun: this.gugunCode,
        userId: this.userInfo.userId,
      };
      this.getHouseList(params);
    },
  },
};
</script>

<style scoped>
img {
  width: 15px;
  height: 15px;
}
</style>
