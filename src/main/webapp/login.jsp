<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="<%=request.getContextPath() %>/resources/css/stylelogin.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/cloud.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/js/login.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 
</head>

<body style="background-color:#1c77ac; background-image:url(<%=request.getContextPath() %>/resources/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  
    <div class="loginbody">
    <span class="systemlogo"></span> 
    <div class="loginbox">
    <form id="form1" action="" method="post">
    <ul>
	    <li><input type="text" class="loginpwd" value="用户id" name="username" id="username" onclick="JavaScript:this.value=''"/></li>
	    <li><input type="password" class="loginpwd" value="" name="password" id="password" onclick="JavaScript:this.value=''"/></li>
	    <li><input type="button" class="loginbtn" id="login" value="登录" style="margin-left: 40px" />
	    	<input type="button" class="loginbtn" id="register" value="注册" style="margin-left: 40px" /></li>
    </ul>
    </form>
    </div>
    </div>
</body>
</html>
