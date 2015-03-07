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
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/money/adminmain4.js"></script>
</head>
<body>
<div id="body-wrapper">
  <div id="sidebar">
    <div id="sidebar-wrapper">
      <h1 id="sidebar-title"><a href="#">Simpla Admin</a></h1>
      <a href="http://www.865171.cn"><img id="logo" src="<%=request.getContextPath() %>/resources/images/logo.png" alt="Simpla Admin logo" /></a>
      <div id="profile-links"> 您好, <a href="#" title="Edit your profile">${sessionScope.username}</a><br />
        <br />
        <a href="#" title="View the Site">进入网站</a> | <a href="#" title="Sign Out">退出</a> 
      </div>
      <ul id="main-nav">
        <!-- Accordion Menu -->
        <li> <a href="javascript:void(0);" class="nav-top-item">管理员配置</a>
          <ul>
            <li><a href="/admin/main1">注册用户审核</a></li>
            <li><a href="/userIndexAdmin">推荐系统图</a></li>
            <li><a href="/admin/main3">奖金比例配置</a></li>
            <li><a href="/toMoneyWeek" class="current">奖金发放</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
  <!-- End #sidebar -->
<div id="main-content" style="padding-top:40px;">
    <!--  start     表单-->
    
    
    
    
        <div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>奖金发放</h3>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <!-- 统计数据 -->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <!-- This is the target div. id must match the href of this div's tab -->
          <table>
            <thead>
              <tr style="border-bottom: 1px solid #E2E2E2;">
                <th>
                  <input class="check-all" type="checkbox" />
                </th>
                <th>序号</th>
                <th>用户ID</th>
                <th>姓名</th>
                <th>奖金金额</th>
                <th>发放状态</th>
                <th>操作</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
                <td colspan="8">
                  <div class="pagination">${pageHtml}</div>
                  <!-- End .pagination -->
                  <div class="clear"></div>
                </td>
              </tr>
            </tfoot>
            <tbody>
                <c:forEach items="${weekEnds}" var="week" varStatus="status">
	              <tr <c:if test="${week.flag == 1}">style="background-color: white;border-bottom: 1px solid #E2E2E2;"</c:if>
	                <c:if test="${week.flag == 2}">style="background-color: rgb(255, 27, 27);border-bottom: 1px solid #E2E2E2;"</c:if>
	                <c:if test="${week.flag == 3}">style="background-color: rgb(0, 238, 0);border-bottom: 1px solid #E2E2E2;"</c:if>> 
	                <td>
	                  <input type="checkbox" />
	                </td>
	                <td>${status.count}</td>
	                <td>${week.userId}</td>
	                <td>${week.userId}</td>
	                <td>${week.money}</td>
	                <td>
	                <c:if test="${week.flag == 1}">无奖金</c:if>
	                <c:if test="${week.flag == 2}">有奖金，未发放</c:if>
	                <c:if test="${week.flag == 3}">有奖金，已发放</c:if>
	                </td>
	                <td>
	                   <c:if test="${week.flag == 2}">
	                       <a class="button" href="javascript:void(0)" pkid="${week.pkId}" name="weekBtn">点击发放</a>
	                   </c:if>
	                </td>
	              </tr>
                </c:forEach>
            </tbody>
          </table>
        </div>
        <!-- End #tab1 -->
        <!-- End #tab2 -->
      </div>
      <!-- End .content-box-content -->
    </div>
    
</div>
</div>
</body>
</html>
