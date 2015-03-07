<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>基里科技网站后台管理</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/reset.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/invalid.css" type="text/css" media="screen" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/facebox.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.wysiwyg.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.date.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin.js"></script>
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
            <li><a href="/admin/main1" class="current">注册用户审核</a></li>
            <li><a href="/userIndexAdmin">推荐系统图</a></li>
            <li><a href="/admin/main3">奖金比例配置</a></li>
            <li><a href="/toMoneyWeek">奖金发放</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
  <!-- End #sidebar -->
  <div id="main-content">
  	<div class="content-box">
  		<!-- Start Content Box -->
      <div class="content-box-header">
        <h3>截止本周所注册人员</h3>
        <div class="clear"></div>
      </div>
      <div class="tab-content default-tab" id="tab1">
          <!-- This is the target div. id must match the href of this div's tab -->
          <form id="form1" action="" method="post">
          <table>
            <thead>
              <tr>
                <th>
                  <input class="check-all" type="checkbox" />
                </th>
                <th>用户Id</th>
                <th>姓名</th>
                <th>身份证号</th>
                <th>推荐人Id</th>
                <th>接点人Id</th>
                <th>tel</th>
                <th>zcTime</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
                <td colspan="8">
                  <div class="bulk-actions align-right">
                    <a class="button" id="deleteUser" >&nbsp;&nbsp;&nbsp;&nbsp;删&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;除&nbsp;&nbsp;&nbsp;&nbsp;</a> </div>
                  <!-- End .pagination -->
                  <div class="clear"></div>
                </td>
              </tr>
            </tfoot>
            <tbody>
                <c:forEach items="${userlist}" var="view" varStatus="status">
	              <tr> 
	                <td>
	                  <input type="checkbox" name="check" value="${view.id}" />
	                </td>
	                <td>${view.id}</td>
	                <td>${view.name}</td>
	                <td>${view.identityCard}</td>
	                <td>${view.jsrId}</td>
	                <td>${view.jdrId}</td>
	                <td>${view.tel}</td>
	                <td><fmt:formatDate value="${view.zcTime}" pattern="yyyy年MM月dd日 HH:mm:ss" /></td>
	              </tr>
                </c:forEach>
            </tbody>
          </table>
          </form>
        </div>
  	</div>
  </div>
 </div>
</body>
<!-- Download From www.exet.tk-->
</html>
