<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
  <!-- Wrapper for the radial gradient background -->
  <div id="sidebar">
    <div id="sidebar-wrapper">
      <!-- Sidebar with logo and menu -->
      <h1 id="sidebar-title"><a href="#">Simpla Admin</a></h1>
      <!-- Logo (221px wide) -->
      <a href="javascript:window.location.reload();"><img id="logo" src="resources/images/common/logo.png" alt="Simpla Admin logo" /></a>
      <div id="profile-links"> 您好, <a href="javascript:;" title="Edit your profile">${sessionScope.username}</a><br />
        <br />
        <a href="sysLogout" title="Sign Out">退出</a> </div>
      <ul id="main-nav">
        <li> <a href="javascript:void(0);" class="nav-top-item">个人信息</a>
          <ul>
            <li><a href="/userIndex" class="current">推荐系统图</a></li>
            <li><a href="/userModify">个人信息修改</a></li>
          </ul>
        </li>
      </ul>
      <!-- End #messages -->
    </div>
  </div>