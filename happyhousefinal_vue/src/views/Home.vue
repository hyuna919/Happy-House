<template>
  <div class="d-flex flex-column h-100">
    <main class="flex-shrink-0">
      <header class="py-5">
        <div class="h-100 row align-items-center">
          <div class="text-center">
            <h1 class="display-5 fw-bolder text-white mb-2">HAPPY HOUSE</h1>
            <p class="lead fw-normal text-white-50 mb-4">
              쉽고 편한 부동산 거래 내역 조회 및 비교 서비스 공공데이터 포털에서
              가져오는 신뢰 가능한 데이터를 제공합니다.
            </p>
            <div class="d-grid gap-3 d-sm-flex justify-content-sm-center">
              <a class="btn btn-outline-light btn-lg px-4 me-sm-3"
                ><router-link
                  :to="{ name: 'House' }"
                  class="text-white"
                  style="text-decoration: none"
                  >아파트 거래내역 조회하러 가기 -></router-link
                ></a
              >
            </div>
          </div>
        </div>
      </header>
      <!-- Features section-->
      <section class="py-5" id="features">
        <div class="container px-5 my-5">
          <div class="row gx-5">
            <div class="col-lg-4 mb-5 mb-lg-0">
              <h2 class="fw-bolder mb-0">
                쌈박한 부동산 정보를 얻는 최고의 웹사이트
              </h2>
            </div>
            <div class="col-lg-8">
              <div class="row gx-5 row-cols-1 row-cols-md-2">
                <div class="col mb-5 h-100">
                  <div
                    class="
                      feature
                      bg-primary bg-gradient
                      text-white
                      rounded-3
                      mb-3
                    "
                  >
                    <i class="bi bi-collection"></i>
                  </div>
                  <h2 class="h5">부동산 거래내역 조회</h2>
                  <p class="mb-0">
                    공공데이터포털에서 가져온 신뢰성 높은 데이터를 검색과
                    필터링을 통해 쉽게 찾을 수 있습니다
                  </p>
                </div>
                <div class="col mb-5 h-100">
                  <div
                    class="
                      feature
                      bg-primary bg-gradient
                      text-white
                      rounded-3
                      mb-3
                    "
                  >
                    <i class="bi bi-building"></i>
                  </div>
                  <h2 class="h5">지도 제공</h2>
                  <p class="mb-0">
                    이 집은 어디있지? 매물의 위치를 지도상으로 보여드립니다.
                  </p>
                </div>
                <div class="col mb-5 mb-md-0 h-100">
                  <div
                    class="
                      feature
                      bg-primary bg-gradient
                      text-white
                      rounded-3
                      mb-3
                    "
                  >
                    <i class="bi bi-toggles2"></i>
                  </div>
                  <h2 class="h5">내 마음 속에 저.장.★</h2>
                  <p class="mb-0">
                    마음에 드는 매물을 찜하고 한 페이지에서 모아볼 수 있습니다.
                  </p>
                </div>
                <div class="col h-100">
                  <div
                    class="
                      feature
                      bg-primary bg-gradient
                      text-white
                      rounded-3
                      mb-3
                    "
                  >
                    <i class="bi bi-toggles2"></i>
                  </div>
                  <h2 class="h5">헛소리</h2>
                  <p class="mb-0">
                    솔직히 이 한글폰트 별로 안어울리는 것 같아요. 시간나면
                    폰트도 바꾸고싶은데 이건 안바꾸겠단 소리죠
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      <!-- <img alt="Vue logo" src="../assets/main.jpg" />
    <HelloWorld msg="Welcome to Your Vue.js App" /> -->
    </main>
    <!-- <Footer /> -->
  </div>
</template>

<script>
export default {
  name: "Home",
  components: {},
};
</script>

<style scoped>
@import url("../css/styles.css");
</style>
