<template>
  <div>
    <div><br /></div>
    <div id="map"></div>
    <br />
  </div>
</template>

<script>
import { mapState } from "vuex";

const houseStore = "houseStore";

export default {
  name: "KakaoMap",
  data() {
    return {
      map: null,
      markerPositions: [],
      markers: [],
      geocoder: null,
      overlay: null,
    };
  },
  computed: {
    ...mapState(houseStore, ["houses", "house"]),
  },
  watch: {
    house: function () {
      this.displayHouseDeatail();
    },
    houses: function () {
      this.displayHouses();
    },
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=0b37950431ae22c469aa0f9d0ab027a6&libraries=services";
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 5,
      };
      this.map = new kakao.maps.Map(container, options);
    },
    changeSize(size) {
      const container = document.getElementById("map");
      container.style.width = `${size}px`;
      container.style.height = `${size}px`;
      this.map.relayout();
    },
    displayHouses() {
      if (this.overlay) this.closeOverlay();
      let i = 0;
      for (let k = 0; k < this.markers.length; k++) {
        this.markers[k].setMap(null);
      }
      this.markers = [];
      this.geocoder = new kakao.maps.services.Geocoder();
      this.houses.forEach((item) => {
        var coords = new kakao.maps.LatLng(item.lat, item.lng);

        var marker = new kakao.maps.Marker({
          map: this.map,
          position: coords,
          title: item.aptName,
          clickable: true,
        });

        var infowindow = new kakao.maps.InfoWindow({
          content: "<div style='padding:5px;'>" + item.aptName + "</div>",
          position: coords,
        });

        kakao.maps.event.addListener(
          marker,
          "mouseover",
          this.makeOverListener(this.map, marker, infowindow)
        );

        kakao.maps.event.addListener(
          marker,
          "mouseout",
          this.makeOutListener(infowindow)
        );

        i++;
        this.markers.push(marker);

        if (i == 1) {
          this.map.panTo(coords);
        }
      });
    },
    displayHouseDeatail() {
      console.log("house : ", this.house);
      for (let k = 0; k < this.markers.length; k++) {
        this.markers[k].setMap(null);
      }
      if (this.overlay) this.closeOverlay();
      this.markers = [];
      this.geocoder = new kakao.maps.services.Geocoder();
      var coords = new kakao.maps.LatLng(this.house.lat, this.house.lng);

      var marker = new kakao.maps.Marker({
        map: this.map,
        position: coords,
        title: this.house.aptName,
        clickable: true,
      });
      var content =
        '<div class="wrap">' +
        '    <div class="info">' +
        '        <div class="title">' +
        this.house.aptName +
        "</div>" +
        '        <div class="body">' +
        '            <div class="desc">' +
        '                <div class="jibun ellipsis"> 넓이: ' +
        this.house.area +
        "㎡</div>" +
        '                <div class="jibun ellipsis"> 건축년도: ' +
        this.house.buildYear +
        "년</div>" +
        '                <div class="jibun ellipsis"> 법정동: ' +
        this.house.dong +
        "</div>" +
        '                <div class="jibun ellipsis"> 층수: ' +
        this.house.floor +
        "층</div>" +
        '                <div class="jibun ellipsis"> 거래금액: ' +
        this.house.dealAmount +
        ",000원</div>" +
        '                <div class="jibun ellipsis"> 거래일: ' +
        this.house.dealYear +
        "-" +
        this.house.dealMonth +
        "-" +
        this.house.dealDay +
        "</div>" +
        "            </div>" +
        "        </div>" +
        "    </div>" +
        "</div>";

      this.overlay = new kakao.maps.CustomOverlay({
        content: content,
        map: this.map,
        position: marker.getPosition(),
      });

      kakao.maps.event.addListener(marker, "click", function () {
        this.overlay.setMap(this.map);
      });

      this.markers.push(marker);

      this.map.panTo(coords);
    },

    makeOverListener(map, marker, infowindow) {
      return function () {
        infowindow.open(map, marker);
      };
    },

    makeOutListener(infowindow) {
      return function () {
        infowindow.close();
      };
    },
    closeOverlay() {
      this.overlay.setMap(null);
    },
  },
};
</script>

<style>
#map {
  width: 800px;
  height: 800px;
}

.button-group {
  margin: 10px 0px;
}

button {
  margin: 0 3px;
}
</style>
