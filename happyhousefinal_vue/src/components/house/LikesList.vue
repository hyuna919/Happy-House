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
import { mapActions, mapState } from "vuex";
import { houseLikeList } from "@/api/house.js";

const userStore = "userStore";
const likeStore = "likeStore";
const houseStore = "houseStore";

export default {
  name: "HouseList",
  data() {
    return { word: "", houses: [] };
  },
  computed: {
    ...mapState(userStore, ["userInfo"]),
    ...mapState(likeStore, ["likes"]),
  },
  mounted() {
    const params = {
      userId: this.userInfo.userId,
    };

    houseLikeList(
      params,
      ({ data }) => {
        console.log(data);
        this.houses = data;
      },
      (error) => {
        console.log(error);
      }
    );

    console.log(this.likes);
  },
  methods: {
    ...mapActions(likeStore, ["deleteLike", "setLike", "getLike"]),
    ...mapActions(houseStore, ["detailHouse", "getHouseList"]),

    selectHouse(house) {
      this.detailHouse(house);
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
        userId: this.userInfo.userId,
      };
      houseLikeList(
        params,
        ({ data }) => {
          console.log(data);
          this.houses = data;
        },
        (error) => {
          console.log(error);
        }
      );
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
