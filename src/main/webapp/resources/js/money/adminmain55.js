$(function() {
	
	// 保存参数
	$("#argsSave").click(function(){
		if(!$("#id").val()){
			alert("请先点击修改按钮！");
			return false;
		}
		var fomr1 = document.getElementById("form1");
		form1.action="/updateUserInfo";
		form1.submit();
	});
	
});

