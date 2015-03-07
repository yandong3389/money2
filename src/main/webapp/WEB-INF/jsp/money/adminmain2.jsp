<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>网站后台管理</title>
<link rel="stylesheet" href="<c:url value="/resources/css/reset.css"/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value="/resources/css/invalid.css"/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value="/resources/css/module2/org5.css"/>" type="text/css" media="screen" />
<link rel="shortcut icon" href="resources/images/favicon.ico" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/money/index.js"/>"></script>
</head>
<body>
<div id="body-wrapper">
  <div id="sidebar">
    <div id="sidebar-wrapper">
      <h1 id="sidebar-title"><a href="#">Simpla Admin</a></h1>
      <a href="javascript:void(0);"><img id="logo" src="<%=request.getContextPath() %>/resources/images/logo.png" alt="Simpla Admin logo" /></a>
      <div id="profile-links"> 您好, <a href="#" title="Edit your profile">${sessionScope.username}</a><br />
        <br />
        <a href="#" title="View the Site">进入网站</a> | <a href="#" title="Sign Out">退出</a> 
      </div>
      <ul id="main-nav">
        <!-- Accordion Menu -->
        <li> <a href="javascript:void(0);" class="nav-top-item">管理员配置</a>
          <ul>
            <li><a href="/admin/main1">注册用户审核</a></li>
            <li><a href="/userIndexAdmin" class="current">推荐系统图</a></li>
            <li><a href="/admin/main3">奖金比例配置</a></li>
            <li><a href="/admin/main4">奖金发放</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
  <!-- End #sidebar -->
  <div id="main-content">
    <!-- Main Content Section with everything -->
    <!-- Page Head -->
    <h2>欢迎登录网站后台管理</h2>
    <p id="page-intro">你想做些什么？</p>
    <!-- End .shortcut-buttons-set -->
    <div class="clear"></div>
    <!-- End .clear -->
    <div class="content-box"  style="float: left">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>组织结构图</h3>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <!-- 统计数据 -->
      <div class="content-box-content" style="float: left;padding: 50px 100px 100px 100px;">
      
      <input id="nodeJson" type="hidden" value='${node}' />
      
      <div id="contain">
         <ul class="solo" id="xflow">
         </ul>
      </div>
      </div>
      <!-- End .content-box-content -->
    </div>
    <!-- End .content-box -->
    <div class="clear"></div>

    <!-- End #footer -->
  </div>
  <!-- End #main-content -->
</div>
</body>
<!-- Download From www.exet.tk-->
</html>
