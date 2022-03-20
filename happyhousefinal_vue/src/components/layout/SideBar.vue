<template>
  <div>
    <ul class="navbar-nav sidebar bg-gradient-primary sidebar-dark accordion">
      <!-- Sidebar - Brand -->
      <a
        class="sidebar-brand d-flex align-items-center justify-content-center"
        href="index.html"
      >
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">마이페이지</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider" />

      <!-- Heading -->
      <div class="sidebar-heading">개인정보</div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <router-link
          to="/mypage/update"
          class="text-white nav-link"
          style="text-decoration: none"
        >
          <i class="fas fa-fw fa-chart-area"></i>
          <span>마이페이지</span></router-link
        >
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider" />

      <!-- Heading -->
      <div class="sidebar-heading">기타</div>

      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <router-link
          to="/mypage/likes"
          class="text-white nav-link"
          style="text-decoration: none"
        >
          <i class="fas fa-fw fa-chart-area"></i>
          <span>찜한 거래내역 보기</span></router-link
        >
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "SideBar",
  components: {},
};
</script>

<style scoped src="@/css/sidebar.css"></style>
