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
	$("#login").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		if(username == "" || password == ""){
			alert("用户名或密码不能为空");
			return false;
		}
		var form1 = document.getElementById("form1");
		form1.action="/user/login";
		form1.submit();
	});
	
	// 修改参数
	$("#register").click(function(){
		var form1 = document.getElementById("form1");
		form1.action="/user/regInvite";
		form1.submit();
	});
	$("#inviteConfirm").click(function(){
		var code = $("#inviteCode").val();
		$.ajax({
	          url:"/user/confirmUser",
	          type:"post",
	          dataType:"text",
	          data:{
	        	 code:code
	          },
	          success:function(responseText){
	        	  if(responseText == "success"){
	        		  window.location.href="/user/regUser";
	        	  }else{
	        		  alert("请输入正确的邀请码");
	        	  }
	          },
	          error:function(e){
	            alert(e);
	          }
        });
	});
});
