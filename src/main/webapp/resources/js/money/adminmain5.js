$(function() {
	
	$("a[name='updateBtn']").bind("click", function () {
		
		var pkId = $(this).attr("pkId");
		window.open("/toUpdateUserInfo?userId=" + pkId,'_blank');
		
	});
	
});

