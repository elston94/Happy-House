<template>
  <!-- 카카오맵 Vue -->
  <div>
    <div id="map" style="width: 100%; height: 500px"></div>
    <div hidden>
      {{ aptlist }}
      {{ aptName }}
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "KakaoMap",
  data() {
    return {
      container: Document,
    };
  },
  props: {
    islist: Boolean,
    aptlist: Array,
    si: String,
    gugun: String,
    dong: String,
    aptName: String,
    jibun: String,
  },
  computed: {
    ...mapGetters(["subwaylist"]),
  },
  created() {
    this.$store.dispatch("getSubwayList");
  },
  mounted() {
    window.kakao && window.kakao.maps ? this.initMap() : this.addScript();
  },
  updated() {
    this.addMarker();
  },
  methods: {
    //지도 초기화
    initMap() {
      var container = document.getElementById("map");
      var options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 3,
      };
      var map = new kakao.maps.Map(container, options);
      var marker = new kakao.maps.Marker({
        position: map.getCenter(),
      });
      marker.setMap(map);
    },
    //script에 지도 표출 추가
    addScript() {
      const script = document.createElement("script");
      // /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=3a2dc22797715739695f9d702a74201a&libraries=services,clusterer";
      document.head.appendChild(script);
    },
    // 지도에 마커 추가
    addMarker() {
      // islist = false -> 아파트 상세조회
      if (!this.islist) {
        // 지도 생성
        var mapOption = {
          center: new kakao.maps.LatLng(33.450701, 126.570667),
          level: 4,
        };
        this.container = document.getElementById("map");

        var map = new kakao.maps.Map(this.container, mapOption); // 주소-좌표 변환 객체 생성
        var geocoder = new kakao.maps.services.Geocoder(); // 주소로 좌표를 검색
        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

        var imageSize = new kakao.maps.Size(24, 35);
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); // 마커 이미지를 생성
        var addrFullName = this.dong + " " + this.jibun + ", " + this.aptName;

        var sList = this.subwaylist;

        geocoder.addressSearch(addrFullName, function (result, status) {
          if (status === kakao.maps.services.Status.OK) {
            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
            var marker = new kakao.maps.Marker({
              map: map,
              position: coords,
              image: markerImage,
            });

            sList.forEach((element) => {
              geocoder.addressSearch(element.address, function (s_result, s_status) {
                if (s_status === kakao.maps.services.Status.OK) {
                  var s_coords = new kakao.maps.LatLng(s_result[0].y, s_result[0].x); //역의 좌표

                  var polyline = new kakao.maps.Polyline({
                    /* map:map, */
                    path: [s_coords, coords],
                    strokeWeight: 2,
                    strokeColor: "#FF00FF",
                    strokeOpacity: 0.8,
                    strokeStyle: "dashed",
                  });

                  var distance = Math.floor(polyline.getLength()); // 아파트와 역 사이의 거리

                  if (distance < 5000) {
                    var marker = new kakao.maps.Marker({
                      map: map,
                      position: s_coords,
                      title: element.name + "역",
                    });

                    // 도보 시간 계산 (도보 시속 : 평균 4km/h , 도보 분속 : 67m/min)
                    var walkkTime = (distance / 67) | 0;
                    var walkHour = "",
                      walkMin = "";

                    if (walkkTime > 60) {
                      walkHour =
                        '<span class="number">' + Math.floor(walkkTime / 60) + "</span>시간 ";
                    }
                    walkMin = '<span class="number">' + (walkkTime % 60) + "</span>분";

                    // 자전거 시간 계산 (자전거 평균 시속 : 16km/h, 이것을 기준으로 자전거 분속 : 267m/min)
                    var bycicleTime = (distance / 227) | 0;
                    var bycicleHour = "",
                      bycicleMin = "";

                    if (bycicleTime > 60) {
                      bycicleHour =
                        '<span class="number">' + Math.floor(bycicleTime / 60) + "</span>시간 ";
                    }
                    bycicleMin = '<span class="number">' + (bycicleTime % 60) + "</span>분";

                    //HTML Content
                    var content = '<div class="">';
                    content += `        <span class="label">${element.name}역 ${element.line}호선 </span><br>`;
                    content +=
                      '        <span class="label">총거리 : </span><span class="number">' +
                      distance +
                      "m</span><br>";
                    content +=
                      '        <span class="label">도보 : </span>' + walkHour + walkMin + "<br>";
                    content +=
                      '        <span class="label">자전거 : </span>' + bycicleHour + bycicleMin;
                    content += "</div>";
                    var infowindow = new kakao.maps.InfoWindow({
                      content: '<div style="width:200px;">' + content + "</div>",
                      removable: true,
                    });

                    marker.setMap(map);

                    kakao.maps.event.addListener(marker, "click", function () {
                      infowindow.open(map, marker);
                    });
                  }
                }
              });
            });

            var infowindow = new kakao.maps.InfoWindow({
              content:
                '<div style="width:150px;text-align:center;padding:6px 0;">' +
                addrFullName +
                " " +
                "</div>",
            });
            infowindow.open(map, marker);
            marker.setMap(map);
            map.setCenter(coords);
          }
        });
      }
      // 해당 동에 아파트 거래내역이 없으면 해당 동으로 위치 조정
      else if (this.aptlist.length == 0) {
        mapOption = {
          center: new kakao.maps.LatLng(33.450701, 126.570667),
          level: 4,
        };
        this.container = document.getElementById("map");
        map = new kakao.maps.Map(this.container, mapOption);
        geocoder = new kakao.maps.services.Geocoder();
        imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

        addrFullName = this.si + " " + this.gugun + " ";
        geocoder.addressSearch(addrFullName, function (result, status) {
          if (status === kakao.maps.services.Status.OK) {
            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
            var marker = new kakao.maps.Marker({
              map: map,
              position: coords,
            });
            var infowindow = new kakao.maps.InfoWindow({
              content:
                '<div style="width:150px;text-align:center;padding:6px 0;">' +
                "해당 도시에 거래 내역이 없습니다." +
                "</div>",
            });
            infowindow.open(map, marker);
            marker.setMap(map);
            map.setCenter(coords);
          }
        });
      } else {
        mapOption = {
          center: new kakao.maps.LatLng(33.450701, 126.570667),
          level: 5,
        };
        this.container = document.getElementById("map");
        map = new kakao.maps.Map(this.container, mapOption);
        geocoder = new kakao.maps.services.Geocoder();
        imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

        this.aptlist.forEach((element) => {
          var imageSize = new kakao.maps.Size(24, 35);
          var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
          var addrFullName = element.dong + " " + element.jibun + ", " + element.aptName;
          geocoder.addressSearch(addrFullName, function (result, status) {
            if (status === kakao.maps.services.Status.OK) {
              var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
              var marker = new kakao.maps.Marker({
                map: map,
                position: coords,
                image: markerImage,
                title: element.아파트,
              });
              var infowindow = new kakao.maps.InfoWindow({
                content:
                  '<div style="width:200px;text-align:center;padding:20px 0;">' +
                  addrFullName +
                  " " +
                  "</div>",
                removable: true,
              });
              marker.setMap(map);

              kakao.maps.event.addListener(marker, "click", function () {
                infowindow.open(map, marker);
              });

              map.setCenter(coords);
            }
          });
        });
      }
    },
  },
};
</script>
<style>
.number {
  font-weight: bold;
  color: #ee6152;
}
.distanceInfo {
  position: relative;
  top: 5px;
  left: 5px;
  list-style: none;
  margin: 0;
}
.distanceInfo .label {
  display: inline-block;
  width: 50px;
}
.distanceInfo:after {
  content: none;
}
</style>
