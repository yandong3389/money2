<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>注册成功</title>
<base href="${base_path}" target="_self" />
<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<![endif]-->
<link href="resources/css/normalize.css" rel="stylesheet"/>
<link href="resources/css/jquery-ui.css" rel="stylesheet"/>
<link href="resources/css/jquery.idealforms.min.css" rel="stylesheet" media="screen"/>
<link rel="stylesheet" href="resources/css/invalid.css" type="text/css" media="screen" />
<style type="text/css">
body{font:normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;color: #222;background:url(resources/images/pattern.png);overflow-y:scroll;padding:60px 0 0 0;}
#my-form{width:880px;margin:0 auto;border:1px solid #ccc;padding:3em;border-radius:3px;box-shadow:0 0 2px rgba(0,0,0,.2);}
#comments{width:350px;height:100px;}
</style>
</head>
<body>
<div class="row">
  <div class="eightcol last">
    <form id="my-form" method="post" action="/user/regUser">
      <table style="width:100%">
      	<tr>
      		<td align="center">
      			<div style="padding-left: 160px;"><label style="" >注册成功、请谨记你的登陆ID号:</label><input style="color:red;font-size: 24px" type="text" value="${id}" disabled="disabled" /></div>
      		</td>
      	</tr>
      </table>
      <div><hr/></div>
      <div style="float:right">
        <button type="button" id="returnLogin" style="width:100px">返回登陆</button>
      </div>
    </form>
    <!-- End Form -->
</div>
</div>
<script type="text/javascript" src="resources/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.idealforms.js"></script>
<script src="resources/js/login.js" type="text/javascript"></script>
<div style="text-align:center;">
</div>
</body>
</html>
