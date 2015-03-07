<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
            <li><a href="/admin/main4" class="current">奖金发放</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
  <!-- End #sidebar -->
<div id="main-content" style="padding-top:40px;">
	<!--       表格 -->
  <div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>奖金配置</h3>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <div class="notification attention png_bg">
            <div>此页面为动态奖金比例配置，影响资金发放，请谨慎配置</div>
          </div>
          <table>
            <thead>
              <tr>
                <th>
                  <input class="check-all" type="checkbox" />
                </th>
                <th>价格（元）</th>
                <th>推荐奖金比例（%）</th>
                <th>直接奖金比例（%）</th>
                <th>旁系奖金比例（%）</th>
                <th>备注</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
                <td colspan="6">
                  <div class="bulk-actions align-right">
                    <a class="button" href="javascript:void(0)" id="modify" >&nbsp;&nbsp;&nbsp;&nbsp;修&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;改&nbsp;&nbsp;&nbsp;&nbsp;</a> </div>
                  <!-- End .pagination -->
                  <div class="clear"></div>
                </td>
              </tr>
            </tfoot>
            <tbody>
              <tr>
                <td>
                  <input type="checkbox" /> <input type="hidden" id="t_id" value="${args.id}" />
                </td>
                <td><input type="text" value="${args.bonus}" id="t_bonus" disabled="disabled" style="width:80px;border:0;background: #f3f3f3;" /></td>
                <td><input type="text" value="${args.tjBonusPercent}" id="t_tjBonusPercent" disabled="disabled" style="width:80px;border:0;background: #f3f3f3;" /></td>
                <td><input type="text" value="${args.pxBonusPercent}" id="t_pxBonusPercent" disabled="disabled" style="width:80px;border:0;background: #f3f3f3;" /></td>
                <td><input type="text" value="${args.zxBonusPercent}" id="t_zxBonusPercent" disabled="disabled" style="width:80px;border:0;background: #f3f3f3;" /></td>
                <td>
                	<input type="text" value="${args.comment}" id="t_comment" disabled="disabled" style="width:180px;border:0;background: #f3f3f3;" />
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <!--  end     表格 -->
    <!--  start     表单-->
    <div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>奖金配置修改</h3>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <form id="form1" action="" method="post">
            <fieldset>
            <table>
            	<tr>
            	<td>
		              <label>价格（元）</label>
		              <input class="text-input small-input" type="text" id="bonus" name="bonus" />
<!-- 		              <span class="input-notification success png_bg">Successful message</span> -->
            	</td>
            	<td>
		              <label>推荐奖金比例（%）</label>
		              <input class="text-input small-input" type="text" id="tjBonusPercent" name="tjBonusPercent" />
<!-- 		              <span class="input-notification success png_bg">Successful message</span> -->
            	</td>
            	<td>
		              <label>旁系奖金比例（%）</label>
		              <input class="text-input small-input" type="text" id="pxBonusPercent" name="pxBonusPercent" />
<!-- 		              <span class="input-notification success png_bg">Successful message</span> -->
            	</td>
            	</tr>
            	<tr>
            	<td>
		              <label>直系奖金比例（%）</label>
		              <input class="text-input small-input" type="text" id="zxBonusPercent" name="zxBonusPercent" />
<!-- 		              <span class="input-notification success png_bg">Successful message</span> -->
            	</td>
            	<td colspan="2">
		              <label>备注</label>
		              <input class="text-input medium-input" type="text" id="comment" name="comment" />
<!-- 		              <span class="input-notification success png_bg">Successful message</span> -->
            	</td>
            	<td></td>
            	</tr>
            	<tr>
            		<td></td><td></td><td><div class="bulk-actions align-right">
            		  <input type="hidden" value="" name="id" id="id" />
		              <input class="button" type="button" value="保     存" id="argsSave" style="width:100px;" />
            		</div></td>
            	</tr>
            </table>
            </fieldset>
            <div class="clear"></div>
            <!-- End .clear -->
          </form>
        </div>
      </div>
    </div>
</div>
</div>
</body>
</html>
