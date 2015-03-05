
$(function(){

	var jsonData = eval('(' + '{"children":[{"children":[{"children":[{"id":8,"level":4,"parentId":4},{"id":9,"level":4,"parentId":4}],"id":4,"level":3,"parentId":2},{"children":[{"id":10,"level":4,"parentId":5},{"id":11,"level":4,"parentId":5}],"id":5,"level":3,"parentId":2}],"id":2,"level":2,"parentId":1},{"children":[{"children":[{"id":12,"level":4,"parentId":6},{"id":13,"level":4,"parentId":6}],"id":6,"level":3,"parentId":3},{"children":[{"id":14,"level":4,"parentId":7},{"id":15,"level":4,"parentId":7}],"id":7,"level":3,"parentId":3}],"id":3,"level":2,"parentId":1}],"id":1,"level":1,"parentId":0}'+')');
	
	
	var html = '';
	$("#xflow").html("");
	$("#xflow").append('<li id="li_' + jsonData.id + '"><div class=\'root section\'><a>'+ jsonData.id +'</a></div></li>');
	
	if (jsonData.children[0] != undefined) {
		showChild(jsonData.children[0], jsonData.id, true);
	} 
	if (jsonData.children[1] != undefined) {
		showChild(jsonData.children[1], jsonData.id, false);
	}
	
	function showChild(node, parentId, isLeft){
		
		if ($("ul[id='ul_"+parentId+"']").length == 0) {
			$("li[id='li_"+ parentId +"']").append("<ul id='ul_" + parentId + "'></ul>");
		}
		
		var nodeHtml = '';
		
		var hasChildren = false;
		
		if (node.children != undefined) {
			hasChildren = true;
		}
		
		// 是否为左节点
		if (isLeft) {
			nodeHtml = "<li id='li_" + node.id + "'><div class='first' " + (hasChildren?'id="section"':'') + "><a>"+node.id+"</a></div></li>";
		} else {
			nodeHtml = "<li id='li_" + node.id + "'><div class='last' " + (hasChildren?'id="section"':'') + "><a>"+node.id+"</a></div></li>";
		}
		$("#ul_" + parentId).append(nodeHtml);
		console.info("追加节点：" + nodeHtml);
		
		if (hasChildren) {
			
			if (node.children[0] != undefined) {
				showChild(node.children[0], node.id, true);
			} 
			if (jsonData.children[1] != undefined) {
				showChild(node.children[1], node.id, false);
			}
		}
		
	}
	
	
});
