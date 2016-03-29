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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import d.money.common.utils.CollectionUtils;
import d.money.common.utils.MD5Util;
import d.money.common.utils.PageUtil;
import d.money.common.utils.StringUtil;
import d.money.pojo.MoneyHistoryView;
import d.money.pojo.base.Args;
import d.money.pojo.base.MoneyHistory;
import d.money.pojo.base.User;
import d.money.pojo.base.UserExample;
import d.money.service.Money2CalculateService;
import d.money.service.MoneyDetailService;
import d.money.service.UserService;

@Controller
public class MoneyDetailController {

	@Autowired
	MoneyDetailService moneyDetailService;
	@Autowired
	UserService userservice;
	@Autowired
	Money2CalculateService money2CalculateService;

	@RequestMapping("/userIndex")
	public ModelAndView toNode(HttpServletRequest request,
			HttpServletResponse response) {

		// 当前登录用户ID
		int uid = Integer.valueOf(String.valueOf(request.getSession()
				.getAttribute("username")));

		// 取得当前用户下的所有节点数据(包含当前用户)
		List<d.money.common.utils.Node> nodes = moneyDetailService
				.getDefaultTree(uid);

		if (CollectionUtils.isNotEmpty(nodes)) {
			request.setAttribute("node", JSONObject.toJSONString(nodes.get(0)));
		}

		return new ModelAndView("module2/index");
	}

	@RequestMapping("/userModify")
	public String modifyUser(HttpServletRequest request) {
		int uid = Integer.valueOf(String.valueOf(request.getSession()
				.getAttribute("username")));
		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(uid);
		List<User> user = userservice.selectByExample(example);
		request.setAttribute("userinfo", user.get(0));
		
		// 是否可升级
		Map<String, Object> result = money2CalculateService.selectProxyByUserId(uid);
		request.setAttribute("result", result);
		
		return "module2/index1";
	}
	
	/**
	 * 申请升级代理等级
	 * @param user
	 * @param request
	 * @return
	 */
    @RequestMapping(value="/upLevelProxy",  produces = {"application/json;charset=UTF-8"})
    @ResponseBody
	public String upLevelProxy(User user, HttpServletRequest request) {
        
        int uid = Integer.valueOf(String.valueOf(request.getSession().getAttribute("username")));
	    
        return money2CalculateService.saveUpLevelProxyInfo(uid);
	}

	
	@RequestMapping("/userSave")
	public String saveUser(User user, HttpServletRequest request) {
		String newPass = request.getParameter("newPass");
		
		int uid = Integer.parseInt(request.getParameter("userId"));
		user.setId(uid);
		if(!"".equals(newPass)&&null!=newPass){
			user.setPassword(MD5Util.MD5(newPass));
		}
		int i = userservice.updateByPrimaryKeySelective(user);
		if(i>0){
			request.setAttribute("msg", "保存成功");
		}
		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(uid);
		List<User> userinfo = userservice.selectByExample(example);
		request.setAttribute("userinfo", userinfo.get(0));
		return "module2/index1";
	}

	@RequestMapping("/toMoneyDetail")
	public ModelAndView toMoneyDetail(HttpServletRequest request,
			HttpServletResponse response) {

		int userId = Integer.parseInt(request.getParameter("userId"));

		String currentPageStr = request.getParameter("page");

		int currentPage = 1;
		int perpage = 10;
		if (StringUtil.isNotEmpty(currentPageStr)) {
			currentPage = Integer.parseInt(currentPageStr);
		}

		// 列表数据
		List<MoneyHistory> histories = moneyDetailService.getHistoryDetail(
				userId, currentPage, perpage);
		// 总记录数
		int total = moneyDetailService.getHistoryDetailCount(userId);
		// 用户详细
		User userinfo = moneyDetailService.getUserById(userId);
		// 配置信息
		Args configData = moneyDetailService.getConfig();

		// 统计
		List<Integer> data = moneyDetailService.getData(userId);

		List<MoneyHistoryView> historyViews = new ArrayList<MoneyHistoryView>();

		MoneyHistoryView historyView = null;

		for (MoneyHistory history : histories) {

			historyView = new MoneyHistoryView();

			BeanUtils.copyProperties(history, historyView);

			int money = 0;

			if (historyView.getType() == 1) {
				money = (int) (configData.getBonus() / 100 * configData
						.getTjBonusPercent());
			}
			if (historyView.getType() == 2) {
				money = (int) (configData.getBonus() / 100 * configData
						.getZxBonusPercent());
			}
			if (historyView.getType() == 3) {
				money = (int) (configData.getBonus() / 100 * configData
						.getPxBonusPercent());
			}

			historyView.setMoney(money);

			historyViews.add(historyView);
		}

		// 分页请求数据URL地址
		String url = "toMoneyDetail?userId=" + userId;

		// 取得分页工具条
		String pageHtml = PageUtil.getBackPageHtml(currentPage, perpage, total,
				url);

		request.setAttribute("moneyDetailList", null);

		request.setAttribute("pageHtml", pageHtml);

		request.setAttribute("historyViews", historyViews);
		request.setAttribute("userinfo", userinfo);
		request.setAttribute("data30", data.get(0));
		request.setAttribute("data20", data.get(1));
		request.setAttribute("data5", data.get(2));

		return new ModelAndView("module2/money_detail");
	}
}
