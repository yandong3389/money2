/**
 * WYSIWYG - jQuery plugin 0.5
 * 
 * Copyright (c) 2008-2009 Juan M Martinez
 * http://plugins.jquery.com/project/jWYSIWYG
 * 
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 * 
 * $Id: $
 */

$(function(){
	$("#adminLogin").click(function() {
		var account = $("#account").val();
		if(!account){
			$("#loginMsg").html("请输入用户名！");
			$("#loginMsg").css("color","red");
			return false;
		}
		var password = $("#password").val();
		if(!password){
			$("#loginMsg").html("请输入密码！");
			$("#loginMsg").css("color","red");
			return false;
		}
		var form1 = document.getElementById("form1");
		form1.action="/admin/signup";
		form1.submit();
	});
	
	// 修改参数
	$("#modify").click(function(){
		var id= $("#t_id").val();
		var bonus= $("#t_bonus").val();
		var tjBonusPercent= $("#t_tjBonusPercent").val();
		var pxBonusPercent= $("#t_pxBonusPercent").val();
		var zxBonusPercent= $("#t_zxBonusPercent").val();
		var comment= $("#t_comment").val();
		
		$("#id").val(id);
		$("#bonus").val(bonus);
		$("#tjBonusPercent").val(tjBonusPercent);
		$("#pxBonusPercent").val(pxBonusPercent);
		$("#zxBonusPercent").val(zxBonusPercent);
		$("#comment").val(comment);
	});
	
	// 保存参数
	$("#argsSave").click(function(){
		if(!$("#id").val()){
			alert("请先点击修改按钮！");
			return false;
		}
		var fomr1 = document.getElementById("form1");
		form1.action="/admin/saveArgs";
		form1.submit();
	});
});
