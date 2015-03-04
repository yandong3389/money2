package d.money.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import d.money.common.utils.StringUtil;
import d.money.pojo.MoneyHistoryView;
import d.money.pojo.base.Node;
import d.money.pojo.base.User;
import d.money.service.MoneyDetailService;

@Controller
@RequestMapping("/money")
public class MoneyDetailController {

	@Autowired
	MoneyDetailService moneyDetailService;
	
	@RequestMapping("/center")
	public ModelAndView toNode(HttpServletRequest request, HttpServletResponse response) {
		
		// 当前登录用户ID
		String uid = String.valueOf(request.getSession().getAttribute("userId"));
		
		// 取得当前用户下的所有节点数据(包含当前用户)
		List<d.money.common.utils.Node> nodes = null;
		
		request.setAttribute("nodes", nodes);
		
		return new ModelAndView("user/index");
	}
	
	@RequestMapping("/detail")
	public ModelAndView toMoneyDetail(HttpServletRequest request, HttpServletResponse response) {
		
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		String currentPageStr = request.getParameter("");
		
		int currentPage = 0;
		if (StringUtil.isNotEmpty(currentPageStr)) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		
		// 列表数据
		List<Node>  nodes = moneyDetailService.getNodeDetail(userId, currentPage, 10);
		// 用户详细
		User userinfo = moneyDetailService.getUserById(userId);
		// 配置信息
		Map<String, Integer> configData = moneyDetailService.getConfig();
		
		// 统计
		int data30 = 0;
		int data20 = 0;
		int data5 = 0;
		
		List<MoneyHistoryView> historyViews = new ArrayList<MoneyHistoryView>();
		
		MoneyHistoryView historyView = null;
		
		for (Node node : nodes) {
			
			historyView = new MoneyHistoryView();
			
			BeanUtils.copyProperties(node, historyView);
			
			int money = 0;
			
			if (historyView.getType() == 1) {
				money = configData.get("money30");
				data30 += money;
			}
			if (historyView.getType() == 2) {
				money = configData.get("money20");
				data20 += money;
			}
			if (historyView.getType() == 3) {
				money = configData.get("money5");
				data5 += money;
			}
			
			historyView.setMoney(money);
			
			historyViews.add(historyView);
		}
		
		request.setAttribute("historyViews", historyViews);
		request.setAttribute("userinfo", userinfo);
		request.setAttribute("data30", data30);
		request.setAttribute("data20", data20);
		request.setAttribute("data5", data5);
		
		return new ModelAndView("user/money_detail");
	}
}
