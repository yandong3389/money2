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
});
