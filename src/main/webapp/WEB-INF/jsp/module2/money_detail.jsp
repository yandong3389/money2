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
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/simpla.jquery.configuration.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.wysiwyg.js"/>"></script>

</head>
<body>
<div id="body-wrapper">

  <%@include file="/common/left.jsp"%>
  <!-- End #sidebar -->
  <div id="main-content">
    <!-- Main Content Section with everything -->
    <!-- Page Head -->
    <h2>欢迎登录网站后台管理</h2>
    <p id="page-intro">你想做些什么？</p>
    <!-- End .shortcut-buttons-set -->
    <div class="clear"></div>
    <!-- End .clear -->
    
    <div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3 style="cursor: s-resize;">用户信息数据</h3>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1" style="display: block;">
          <form id="form1" action="" method="post">
            <fieldset>
            <table>
            	<tbody>
            	<tr>
            	<td>用户ID：${userinfo.id}</td>
            	<td>用户姓名：${userinfo.name}</td>
            	<td>性别：${userinfo.sex}</td>
            	</tr>
            	<tr>
            	<td>介绍人：${userinfo.jsrId}</td>
            	<td>接点人：${userinfo.jdrId}</td>
            	<td></td>
            	</tr>
            	<tr>
            	<td>农行卡号：${userinfo.nhCard}</td>
            	<td>汇款时间：<fmt:formatDate value="${userinfo.hkTime}" pattern="yyyy年MM月dd日 HH:mm:ss" /></td>
            	<td>身份证：${userinfo.identityCard}</td>
            	</tr>
            	<tr>
            	<td>电话：${userinfo.tel}</td>
            	<td>邮编：${userinfo.code}</td>
            	<td>地址：${userinfo.address}</td>
            	</tr>
            	<tr>
            	<td>管理密码：${userinfo.adminCode}</td>
            	<td>注册时间：<fmt:formatDate value="${userinfo.zcTime}" pattern="yyyy年MM月dd日 HH:mm:ss" /></td>
            	<td>备注：${userinfo.comment}</td>
            	</tr>
            </tbody></table>
            </fieldset>
            <div class="clear"></div>
            <!-- End .clear -->
          </form>
        </div>
      </div>
    </div>
    
    <div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>推荐奖金总额：${data30}；直系奖金总额：${data20}；旁系奖金总额：${data5}；</h3>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <!-- 统计数据 -->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <!-- This is the target div. id must match the href of this div's tab -->
          <table>
            <thead>
              <tr>
                <th>
                  <input class="check-all" type="checkbox" />
                </th>
                <th>序号</th>
                <th>ID</th>
                <th>奖金类型</th>
                <th>获取金额</th>
                <th>获取时间</th>
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
                <c:forEach items="${historyViews}" var="view" varStatus="status">
	              <tr> 
	                <td>
	                  <input type="checkbox" />
	                </td>
	                <td>${status.count}</td>
	                <td>${view.id}</td>
	                <td>
	                <c:if test="${view.type == 1}">推荐奖金</c:if>
	                <c:if test="${view.type == 2}">直系奖金</c:if>
	                <c:if test="${view.type == 3}">旁系奖金</c:if>
	                </td>
	                <td>${view.money}</td>
	                <td><fmt:formatDate value="${view.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	                <td>
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
