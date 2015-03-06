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
<div class="row">
  <div class="eightcol last">
    <!-- Begin Form -->
    <form id="my-form" method="post" action="/user/regUser">
      <table style="width:100%">
      	<tr>
      		<td align="center">
      			<div style="padding-left: 260px;"><label>邀请码:</label><input id="inviteCode" name="inviteCode" type="text"/></div>
      		</td>
      	</tr>
      </table>
      <div><hr/></div>
      <div style="float:right">
        <button type="button" id="inviteConfirm" style="width:100px">确认</button>
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
		'inviteCode': {
			filters: 'required'
		}
	}
};
var $myform = $('#my-form').idealforms(options).data('idealforms');
$('#reset').click(function(){
	$myform.reset().fresh().focusFirst()
});
$myform.focusFirst();
</script>
<div style="text-align:center;">
</div>
</body>
<!-- Download From www.exet.tk-->
</html>
