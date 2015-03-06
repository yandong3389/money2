$(function() {

	 var jsonData = eval('(' + '{"children":[{"children":[{"children":[{"id":8,"level":4,"parentId":4},{"id":9,"level":4,"parentId":4}],"id":4,"level":3,"parentId":2},{"children":[{"id":10,"level":4,"parentId":5},{"id":11,"level":4,"parentId":5}],"id":5,"level":3,"parentId":2}],"id":2,"level":2,"parentId":1},{"children":[{"children":[{"id":12,"level":4,"parentId":6},{"id":13,"level":4,"parentId":6}],"id":6,"level":3,"parentId":3},{"children":[{"id":14,"level":4,"parentId":7},{"id":15,"level":4,"parentId":7}],"id":7,"level":3,"parentId":3}],"id":3,"level":2,"parentId":1}],"id":1,"level":1,"parentId":0}' + ')');

	
	
	console.info(jsonData);
	var html = '';
	$("#xflow").html("");
	$("#xflow").append('<li id="li_' + jsonData.id + '"><div class=\'root section\'><a href=\'javascript:void(0);\'>' + jsonData.id + '</a></div></li>');

	if (jsonData.children[0] != undefined) {
		showChild(jsonData.children[0], jsonData.id, true);
	}
	if (jsonData.children[1] != undefined) {
		showChild(jsonData.children[1], jsonData.id, false);
	}

	function showChild(node, parentId, isLeft) {

		if ($("ul[id='ul_" + parentId + "']").length == 0) {
			$("li[id='li_" + parentId + "']").append("<ul id='ul_" + parentId + "'></ul>");
		}

		var user = node.user;

		var name = '张三';
		var date = '2015年02月05日 03:12:11';
		var addr = '辽宁省大连市高新园区xxx号';

		var userinfo = '姓名：' + name + '<br/>注册时间：' + date + '<br/>地址：' + addr;

		var nodeHtml = '';

		var hasChildren = false;

		if (node.children != undefined) {
			hasChildren = true;
		}

		// 是否为左节点
		if (isLeft) {
			nodeHtml = "<li id='li_" + node.id + "'><div class='first' " + (hasChildren ? 'id="section"' : '') + "><a title=\""
					+ userinfo + "\" rel=\"tooltip\" href='javascript:void(0);'>" + node.id + "</a></div></li>";
		} else {
			nodeHtml = "<li id='li_" + node.id + "'><div class='last' " + (hasChildren ? 'id="section"' : '') + "><a title=\""
					+ userinfo + "\" rel=\"tooltip\" href='javascript:void(0);'>" + node.id + "</a></div></li>";
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
	var targets = $('[rel~=tooltip]'), target = false, tooltip = false, title = false;

	targets.live('mouseenter', function() {
		target = $(this);
		tip = target.attr('title');
		tooltip = $('<div id="tooltip"></div>');

		if (!tip || tip == '')
			return false;

		target.removeAttr('title');
		tooltip.css('opacity', 0).html(tip).appendTo('body');

		var init_tooltip = function() {
			if ($(window).width() < tooltip.outerWidth() * 1.5)
				tooltip.css('max-width', $(window).width() / 2);
			else
				tooltip.css('max-width', 340);

			var pos_left = target.offset().left + (target.outerWidth() / 2)
					- (tooltip.outerWidth() / 2), pos_top = target.offset().top
					- tooltip.outerHeight() - 20;

			if (pos_left < 0) {
				pos_left = target.offset().left + target.outerWidth() / 2 - 20;
				tooltip.addClass('left');
			} else
				tooltip.removeClass('left');

			if (pos_left + tooltip.outerWidth() > $(window).width()) {
				pos_left = target.offset().left - tooltip.outerWidth()
						+ target.outerWidth() / 2 + 20;
				tooltip.addClass('right');
			} else
				tooltip.removeClass('right');

			if (pos_top < 0) {
				var pos_top = target.offset().top + target.outerHeight();
				tooltip.addClass('top');
			} else
				tooltip.removeClass('top');

			tooltip.css({
				left : pos_left,
				top : pos_top
			}).animate({
				top : '+=10',
				opacity : 1
			}, 50);
		};

		init_tooltip();
		$(window).resize(init_tooltip);

		var remove_tooltip = function() {
			tooltip.animate({
				top : '-=10',
				opacity : 0
			}, 50, function() {
				$(this).remove();
			});

			target.attr('title', tip);
		};

		target.live('mouseleave', remove_tooltip);
		tooltip.live('click', remove_tooltip);
	});

});
