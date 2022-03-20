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
        <div class="sidebar-brand-text mx-3">관리자 페이지</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider" />

      <!-- Heading -->
      <div class="sidebar-heading">회원관리</div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <router-link
          :to="{ name: 'Admin' }"
          class="text-white nav-link"
          style="text-decoration: none"
        >
          <i class="fas fa-fw fa-chart-area"></i>
          <span>회원 목록</span></router-link
        >
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider" />

      <!-- Heading -->
      <div class="sidebar-heading">통계</div>

      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <router-link
          :to="{ name: 'Admin' }"
          class="text-white nav-link"
          style="text-decoration: none"
        >
          <i class="fas fa-fw fa-chart-area"></i>
          <span>작고 소중한 우리 프로젝트....</span></router-link
        >
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "AdminSideBar",
  components: {},
};
</script>

<style scoped src="@/css/sidebar.css"></style>
