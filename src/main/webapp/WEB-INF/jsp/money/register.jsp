<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>基里科技网站后台管理</title>
<!--[if lt IE 9]>
<script src="<%=request.getContextPath() %>/js/html5shiv.js"></script>
<![endif]-->
<link href="<%=request.getContextPath() %>/resources/css/normalize.css" rel="stylesheet"/>
<link href="<%=request.getContextPath() %>/resources/css/jquery-ui.css" rel="stylesheet"/>
<link href="<%=request.getContextPath() %>/resources/css/jquery.idealforms.min.css" rel="stylesheet" media="screen"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/invalid.css" type="text/css" media="screen" />
<style type="text/css">
body{font:normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;color: #222;background:url(<%=request.getContextPath() %>/resources/images/pattern.png);overflow-y:scroll;padding:60px 0 0 0;}
#my-form{width:880px;margin:0 auto;border:1px solid #ccc;padding:3em;border-radius:3px;box-shadow:0 0 2px rgba(0,0,0,.2);}
#comments{width:350px;height:100px;}
</style>
</head>
<body>
<input type="hidden" value="${msg}" id="errMsg" />
<div class="row">
  <div class="eightcol last">
    <!-- Begin Form -->
    <form id="my-form" method="post" action="/user/regsubmit">
      <table style="width:100%">
      	<tr>
      		<td><div><label>姓名:</label><input id="name" name="name" type="text"/></div></td>
      		<td><div><label>身份证号:</label><input id="identityCard" name="identityCard" type="text"/></div></td>
      	</tr>
      	<tr>
      		<td><div><label>密码:</label><input id="pass" name="password" type="password"/></div></td>
      		<td><div><label>汇款时间:</label><input id="hkTime" name="hkTime" class="datepicker" data-ideal="date" type="text" placeholder="秒/分/时/月/日/年"/></div></td>
      	</tr>
      	<tr>
      		<td><div><label>介绍人Id:</label><input id="jsrId" name="jsrId" type="text"/></div></td>
      		<td><div><label>接点人Id:</label><input id="jdrId" name="jdrId" type="text"/></div></td>
      	</tr>
      	<tr>
      		<td><div><label>农行卡号:</label><input id="nhCard" name="nhCard" type="text"/></div></td>
      		<td><div><label>邮编:</label><input id="code" name="code" type="text"/></div></td>
      	</tr>
      	<tr>
      		<td><div><label>电话号:</label><input id="tel" name="tel" type="text"/></div></td>
      		<td><div><label>联系地址:</label><input id="address" name="address" type="text"/></div></td>
      	</tr>
      	<tr>
      		<td><div><label>性别:</label>
			<select id="sex" name="sex">
	            <option value="男">男</option>
	            <option value="女">女</option>
         	</select></div></td>
      		<td><div><label>备注:</label><input id="comment" name="comment" type="text"/></div></td>
      	</tr>
      </table>
      <div><hr/></div>
      <div style="float:right">
        <button type="submit" id="confirm" style="width:100px">确认注册</button>
        <button id="reset" type="button" style="width:100px">重置</button>
      </div>
    </form>
    <!-- End Form -->
</div>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.idealforms.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/login.js" type="text/javascript"></script>
<script type="text/javascript">
var options = {
	onFail: function(){
		alert( $myform.getInvalid().length +' invalid fields.' )
	},
	inputs: {
		'password': {
			filters: 'required'
		},
		'name': {
			filters: 'required'
		},
		'identityCard': {
			filters: 'required number'
		},
		'hkTime': {
			filters: 'required'
		},
		'jsrId': {
			filters: 'required number'
		},
		'jdrId': {
			filters: 'required number'
		},
		'nhCard': {
			filters: 'required number'
		},
		'sex': {
			filters: 'required'
		}
	}
};
var $myform = $('#my-form').idealforms(options).data('idealforms');
$('#reset').click(function(){
	$myform.reset().fresh().focusFirst()
});
$myform.focusFirst();

var msg = $("#errMsg").val();
if(msg!=""&&msg!=null){
	alert(msg);
}
</script>
<div style="text-align:center;">
</div>
</body>
<!-- Download From www.exet.tk-->
</html>
