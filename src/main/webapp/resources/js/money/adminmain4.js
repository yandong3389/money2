$(function() {
	
	$("a[name='weekBtn']").bind("click", function () {
		
		var pkId = $(this).attr("pkId");
		
		if (confirm("确认要结算吗？")) {
			
			$.ajax({
				url:"/updateWeekFlag",
				data:{pkId:pkId},
				type:"post",
				dataType:"json",
				success:function(msg){
					window.location.reload();
				}
			});
		}
	});
	
});

