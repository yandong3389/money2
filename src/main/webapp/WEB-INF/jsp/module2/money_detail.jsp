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
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>用户信息管理</h3>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <!-- This is the target div. id must match the href of this div's tab -->
          <table>
            <thead>
              <tr>
                <th>
                  <input class="check-all" type="checkbox" />
                </th>
                <th>用户账号</th>
                <th>邮箱</th>
                <th>姓名</th>
                <th>性别</th>
                <th>注册时间</th>
                <th>最后登录</th>
                <th>操作</th>
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
                <c:forEach items="${backUserInfoViews}" var="backUserInfo">
	              <tr>
	                <td>
	                  <input type="checkbox" />
	                </td>
	                <td>${backUserInfo.userAccount}</td>
	                <td>${backUserInfo.userMail}</td>
	                <td>${backUserInfo.userName}</td>
	                <td>${backUserInfo.userSex == "0" ? "女" : "男"}</td>
	                <td><fmt:formatDate value="${backUserInfo.registerDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	                <td><fmt:formatDate value="${backUserInfo.lastLoginDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	                <td>
	                  <!-- Icons -->
	                  <a href="#" title="Edit"><img src="resources_back/images/common/icons/pencil.png" alt="Edit" /></a> <a href="#" title="Delete"><img src="resources_back/images/common/icons/cross.png" alt="Delete" /></a> <a href="#" title="Edit Meta"><img src="resources_back/images/common/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </td>
	              </tr>
                </c:forEach>
            </tbody>
          </table>
        </div>
        <!-- End #tab1 -->
        <div class="tab-content" id="tab2">
          <form action="#" method="post">
            <fieldset>
            <!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
            <p>
              <label>Small form input</label>
              <input class="text-input small-input" type="text" id="small-input" name="small-input" />
              <span class="input-notification success png_bg">Successful message</span>
              <!-- Classes for input-notification: success, error, information, attention -->
              <br />
              <small>A small description of the field</small> </p>
            <p>
              <label>Medium form input</label>
              <input class="text-input medium-input datepicker" type="text" id="medium-input" name="medium-input" />
              <span class="input-notification error png_bg">Error message</span> </p>
            <p>
              <label>Large form input</label>
              <input class="text-input large-input" type="text" id="large-input" name="large-input" />
            </p>
            <p>
              <label>Checkboxes</label>
              <input type="checkbox" name="checkbox1" />
              This is a checkbox
              <input type="checkbox" name="checkbox2" />
              And this is another checkbox </p>
            <p>
              <label>Radio buttons</label>
              <input type="radio" name="radio1" />
              This is a radio button<br />
              <input type="radio" name="radio2" />
              This is another radio button </p>
            <p>
              <label>This is a drop down list</label>
              <select name="dropdown" class="small-input">
                <option value="option1">Option 1</option>
                <option value="option2">Option 2</option>
                <option value="option3">Option 3</option>
                <option value="option4">Option 4</option>
              </select>
            </p>
            <p>
              <label>Textarea with WYSIWYG</label>
              <textarea class="text-input textarea wysiwyg" id="textarea" name="textfield" cols="79" rows="15"></textarea>
            </p>
            <p>
              <input class="button" type="submit" value="Submit" />
            </p>
            </fieldset>
            <div class="clear"></div>
            <!-- End .clear -->
          </form>
        </div>
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
