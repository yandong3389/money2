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
<link rel="shortcut icon" href="resources/images/favicon.ico" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.3.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/simpla.jquery.configuration.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/facebox.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.wysiwyg.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.datePicker.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.date.js"/>"></script>

</head>
<body>
<div id="body-wrapper">

  <%@include file="/common/left.jsp"%>
  <!-- End #sidebar -->
  <div id="main-content">
    <!-- Main Content Section with everything -->
    <noscript>
    <!-- Show a notification if the user has disabled javascript -->
    <div class="notification error png_bg">
      <div> Javascript is disabled or is not supported by your browser. Please <a href="###" title="Upgrade to a better browser">upgrade</a> your browser or <a href="#" title="Enable Javascript in your browser">enable</a> Javascript to navigate the interface properly.
        Download From <a href="###">exet.tk</a></div>
    </div>
    </noscript>
    <!-- Page Head -->
    <h2>欢迎登录见网站</h2>
    <p id="page-intro">你想做些什么？</p>
    <!-- End .shortcut-buttons-set -->
    <div class="clear"></div>
    <!-- End .clear -->
    <div class="content-box">
    <!-- End .content-box -->
    <div class="clear"></div>

    <%@include file="/common/footer.jsp"%>

    <!-- End #footer -->
  </div>
  <!-- End #main-content -->
</div>
</body>
<!-- Download From www.exet.tk-->
</html>
