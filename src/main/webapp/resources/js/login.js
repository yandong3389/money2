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
	
	var msg = $("#msg").val();
	if(msg!=null&&msg!=""){
		alert(msg);
		return false;
	}
	
	$("#login").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		if(username == "" || password == ""){
			alert("用户名或密码不能为空");
			return false;
		}
		if(isNaN(username)){
			alert("用户名是数字！");
			return false;
		}
		$.ajax({
          url:"/user/login",
          type:"post",
          dataType:"text",
          data:{
        	 username:username,
        	 password:password
          },
          success:function(responseText){
        	  if(responseText == "success"){
        		  var form1 = document.getElementById("form1");
        		  form1.action="/userIndex";
        		  form1.submit();
        	  }else{
        		  alert("用户名或密码错误!");
        	  }
          },
          error:function(e){
            alert(e);
          }
      });
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
	        		  window.location.href="/user/regUser?code="+code;
	        	  }else{
	        		  alert("请输入正确的邀请码");
	        	  }
	          },
	          error:function(e){
	            alert(e);
	          }
        });
	});
	
	$("#returnLogin").click(function(){
		window.location.href="/";
	});
	
	// 用户修改
	$("#userModify").click(function(){
		var pass1 = $("#password1").val();
		var pass2 = $("#password2").val();
		if(pass1!=pass2){
			alert("两次密码不一致");
			return false;
		}
		var form1 = document.getElementById("form1");
		form1.action = "/userSave";
		form1.submit();
	});
	
	$("#upLevelBtn").click(function(){
		
		$.ajax({
			url:"upLevelProxy",
			dataType:"text",
			success:function(msg){
				
				if (msg == '1') {
					alert("申请成功，请等待管理员进行审核！");
				} else if (msg == '2') {
					alert("已经提交申请，请不要重复提交！");
				} else {
					alert("目前还不符合升级条件！");
				}
			}
		});
		
	});
	
});
