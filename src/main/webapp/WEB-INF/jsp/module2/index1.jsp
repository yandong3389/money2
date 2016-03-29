<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>网站后台管理</title>
<link rel="stylesheet" href="resources/css/reset.css" type="text/css" media="screen" />
<link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen" />
<link rel="stylesheet" href="resources/css/invalid.css" type="text/css" media="screen" />
<link rel="stylesheet" href="resources/css/module2/org5.css" type="text/css" media="screen" />
<link rel="shortcut icon" href="resources/images/favicon.ico" />
<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="resources/js/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="resources/js/facebox.js"></script>
<script type="text/javascript" src="resources/js/jquery.wysiwyg.js"></script>
<script type="text/javascript" src="resources/js/login.js"></script>
</head>
<body>
<div id="body-wrapper">
	<div id="sidebar">
    <div id="sidebar-wrapper">
      <!-- Sidebar with logo and menu -->
      <h1 id="sidebar-title"><a href="#">Simpla Admin</a></h1>
      <!-- Logo (221px wide) -->
      <a href="javascript:window.location.reload();"><img id="logo" src="resources/images/logo.png" alt="Simpla Admin logo" /></a>
      <div id="profile-links"> 您好, <a href="javascript:;" title="Edit your profile">${sessionScope.username}</a><br />
        <br />
        <a href="/user/userlogout" title="Sign Out">退出</a> </div>
      <ul id="main-nav">
        <li> <a href="javascript:void(0);" class="nav-top-item">个人信息</a>
          <ul>
            <li><a href="/userIndex">推荐系统图</a></li>
            <li><a href="/userModify"  class="current">个人信息修改</a></li>
          </ul>
        </li>
      </ul>
      <!-- End #messages -->
    </div>
  </div>
  <!-- End #sidebar -->
  <div id="main-content">
  <div class="content-box">
    <div class="content-box-header">
	  <h3>个人基本信息修改</h3>
    </div>
    <div class="tab-content default-tab" id="tab1" style="display: block;">
      <form id="form1" action="" method="post">
        <fieldset>
        <table>
        	<tbody>
        	<tr style="background: #ffffff">
        	<td><label>用户ID</label>
        		<input type="hidden" name="userId" value="${userinfo.id}" />
                <input class="text-input medium-input" style="background: #f3f3f3" type="text" id="id" name="id" value="${userinfo.id}" disabled="disabled" /></td>
        	<td><label>用户姓名</label>
                <input class="text-input medium-input" style="background: #f3f3f3" type="text" id="name" name="name" value="${userinfo.name}" disabled="disabled" /></td>
        	<td><label>性别</label>
        		<input class="text-input medium-input" style="background: #f3f3f3" type="text" id="sex" name="sex" value="${userinfo.sex}" disabled="disabled" /></td>
        	</tr>
        	<tr>
        	<td><label>介绍人</label>
        		<input class="text-input medium-input" style="background: #f3f3f3" type="text" id="jsrId" name="jsrId" value="${userinfo.jsrId}" disabled="disabled" /></td>
        	<td><label>接点人</label>
        		<input class="text-input medium-input" style="background: #f3f3f3" type="text" id="jdrId" name="jdrId" value="${userinfo.jdrId}" disabled="disabled" /></td>
        	<td></td>
        	</tr>
        	<tr style="background: #ffffff">
        	<td><label>农行卡号</label>
        		<input class="text-input medium-input" type="text" id="nhCard" name="nhCard" value="${userinfo.nhCard}" /></td>
        	<td><label>汇款时间</label>
        		<input class="text-input medium-input" type="text" id="hkTime" name="hkTime" value="<fmt:formatDate value="${userinfo.hkTime}" pattern="yyyy年MM月dd日 HH:mm:ss" />" disabled="disabled" /></td>
        	<td><label>身份证</label>
        		<input class="text-input medium-input" type="text" id="identityCard" name="identityCard" value="${userinfo.identityCard}" /></td>
        	</tr>
        	<tr>
        	<td><label>电话</label>
        		<input class="text-input medium-input" type="text" id="tel" name="tel" value="${userinfo.tel}" /></td>
        	<td><label>邮编</label>
        		<input class="text-input medium-input" type="text" id="code" name="code" value="${userinfo.code}" /></td>
        	<td><label>地址</label>
        		<input class="text-input medium-input" type="text" id="address" name="address" value="${userinfo.address}" /></td>
        	</tr>
        	<tr style="background: #ffffff">
        	<td><label>密码</label>
        		<input class="text-input medium-input" type="text" id="password1" name="newPass" value="" /></td>
        	<td><label>确认密码</label>
        		<input class="text-input medium-input" type="text" id="password2" name="newPass" value="" /></td>
        	<td><label>注册时间</label>
        		<input class="text-input medium-input" style="background: #f3f3f3" type="text" id="zcTime" name="zcTime" value="<fmt:formatDate value="${userinfo.zcTime}" pattern="yyyy年MM月dd日 HH:mm:ss" />" disabled="disabled" /></td>
        	</tr>
        	<tr>
        		<td colspan="5"><label>备注</label>
        		<input class="text-input large-input" type="text" id="comment" name="comment" value="${userinfo.comment}" /></td>
        	</tr>
        	<tr>
          		<td></td>
          		<td></td>
          		<td><div class="bulk-actions align-right">
          		  <input type="hidden" value="" name="id" id="id" />
              		<input class="button" type="button" value="保     存" id="userModify" style="width:100px;" />
          		</div></td>
          	</tr>
        	<tr class="alt-row" style="border-top: 1px solid #ffffff;">
          		<td colspan="2"><span style="font-size: 14px;font-weight: bold;color:red;">投资金额：${result.userMoney}元；&nbsp;&nbsp;客户数量：${result.userClientCount}个；&nbsp;&nbsp;下级省代：${result.shengProxyCount}个；&nbsp;&nbsp;下级市代：${result.shiProxyCount}个；&nbsp;&nbsp;下级县代：${result.xianProxyCount}个；</span></td>
          		<td>
          		<div class="bulk-actions align-right">
          		<span style="font-size: 14px;font-weight: bold;color:red;">当前代理等级：
	          		<c:if test="${userinfo.proxyFlag == '0'}">非代理</c:if>
	          		<c:if test="${userinfo.proxyFlag == '1'}">县代</c:if>
	          		<c:if test="${userinfo.proxyFlag == '2'}">市代</c:if>
	          		<c:if test="${userinfo.proxyFlag == '3'}">省代</c:if>
          		</span>
          		<c:if test="${result.upProxyLevelFlag != '0'}">
          		  <input class="button" type="button" value="申请升级" id="upLevelBtn" style="width:100px;" />
          		</c:if>
          		</div>
          		</td>
          	</tr>
        </tbody></table>
        </fieldset>
        <div class="clear"></div>
        <!-- End .clear -->
      </form>
    </div>
  </div>
  </div>
  <input type="hidden" id="msg" value="${msg }" />
  <!-- End #main-content -->
</div>
</body>
<!-- Download From www.exet.tk-->
</html>
