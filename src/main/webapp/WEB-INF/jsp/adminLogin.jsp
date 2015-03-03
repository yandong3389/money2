<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>基里生物科技后台</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/reset.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/invalid.css" type="text/css" media="screen" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/facebox.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.wysiwyg.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin.js"></script>
</head>
<body id="login">
<div id="login-wrapper" class="png_bg">
  <div id="login-top">
    <h1>基里生物后台管理</h1>
    <!-- Logo (221px width) -->
    <a href="javascript:void(0);"><img id="logo" src="<%=request.getContextPath() %>/resources/images/logo.png"/></a> </div>
  <!-- End #logn-top -->
  <div id="login-content">
    <form id="form1" action="" method="post">
      <div class="notification information png_bg">
        <div id="loginMsg">${message}</div>
      </div>
      <p>
        <label>用  户  名：</label>
        <input class="text-input" id="account" name="account" type="text" />
      </p>
      <div class="clear"></div>
      <p>
        <label>密 &nbsp;&nbsp;&nbsp;&nbsp;码：</label>
        <input class="text-input" id="password" name="password" type="password" />
      </p>
      <div class="clear"></div>
      <p id="remember-password">
        <input type="checkbox" />
       记住密码 </p>
      <div class="clear"></div>
      <p>
        <input class="button" type="button" id="adminLogin" value="登陆"/>
      </p>
    </form>
  </div>
</div>
</body>
</html>
