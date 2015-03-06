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
    <!-- Page Head -->
    <h2>欢迎登录网站后台管理</h2>
    <p id="page-intro">你想做些什么？</p>
    <!-- End .shortcut-buttons-set -->
    <div class="clear"></div>
    <!-- End .clear -->
    <div class="content-box">
    
    <b>用户信息数据</b>
    
    <div>
    ${userinfo.id}
    ${userinfo.name}
    ${userinfo.identityCard}
    ${userinfo.jsrId}
    ${userinfo.jdrId}
    ${userinfo.nhCard}
    ${userinfo.tel}
    ${userinfo.address}
    ${userinfo.code}
    ${userinfo.sex}
    ${userinfo.hkTime}
    ${userinfo.adminCode}
    ${userinfo.comment}
    </div>
    
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
                  <div class="bulk-actions align-left">
                    <select name="dropdown">
                      <option value="option1">Choose an action...</option>
                      <option value="option2">Edit</option>
                      <option value="option3">Delete</option>
                    </select>
                    <a class="button" href="#">Apply to selected</a> </div>
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
