<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
  <!-- Wrapper for the radial gradient background -->
  <div id="sidebar">
    <div id="sidebar-wrapper">
      <!-- Sidebar with logo and menu -->
      <h1 id="sidebar-title"><a href="#">Simpla Admin</a></h1>
      <!-- Logo (221px wide) -->
      <a href="javascript:window.location.reload();"><img id="logo" src="resources/images/common/logo.png" alt="Simpla Admin logo" /></a>
      <div id="profile-links"> 您好, <a href="javascript:;" title="Edit your profile">管理员</a>, 您有 <a href="#messages" rel="modal" title="3 Messages">3 条消息</a><br />
        <br />
        <a href="javascript:void();" target="_blank" title="View the Site">进入网站</a> | <a href="sysLogout" title="Sign Out">退出</a> </div>
      <ul id="main-nav">
        <li> <a href="javascript:;" class="nav-top-item ${empty activeFlag || activeFlag == 'feedback' || activeFlag == 'backInfo' ? 'current' : ''}">用户数据一览</a>
          <ul>
            <li><a href="backInfo" ${empty activeFlag || activeFlag == 'backInfo' ? 'class="current"' : ''}>网站状态概况</a></li>
            <li><a href="findFeedbackList" ${activeFlag == "feedback" ? 'class="current"' : ''}>用户反馈</a></li>
          </ul>
        </li>
      </ul>
      <!-- End #messages -->
    </div>
  </div>