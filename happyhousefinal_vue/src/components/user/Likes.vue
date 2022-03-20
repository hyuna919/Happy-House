<template>
  <div class="d-flex flex-column">
    <main class="flex-shrink-0">
      <section class="py-5">
        <div class="container px-5 my-5">
          <div class="row gx-5">
            <div class="col-lg-9">
              <!-- Post content-->
              <!-- Post header-->
              <div class="mb-4">
                <!-- Post title-->
                <h1 class="fw-bolder mb-1">찜한 거래내역 보기</h1>
              </div>
              <!-- Post content-->
              <section class="mb-5">
                <div class="row">
                  <div class="col-md-5">
                    <likes-list />
                  </div>

                  <div class="col-md-7">
                    <kakao-map />
                  </div>
                </div>
              </section>
            </div>
          </div>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
import LikesList from "@/components/house/LikesList.vue";
import KakaoMap from "@/components/house/KakaoMap.vue";
export default {
  components: {
    LikesList,
    KakaoMap,
  },
};
</script>

<style></style>
