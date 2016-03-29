package d.money.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import d.money.common.utils.PageUtil;
import d.money.common.utils.StringUtil;
import d.money.mapper.NodeExtMapper;
import d.money.pojo.base.Admin;
import d.money.pojo.base.User;
import d.money.pojo.base.UserExample;
import d.money.service.AdminService;
import d.money.service.Money2CalculateService;
import d.money.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminApproveController {

	@Autowired
	AdminService adminservice;
	@Autowired
	UserService userService;
	@Autowired
	NodeExtMapper nodeExtMapper;
	@Autowired
	Money2CalculateService money2CalculateService;
	
	@RequestMapping("/showUserList")
	public String toAdminLogin(HttpServletRequest request) {
		
		Object isAdmin = request.getSession().getAttribute("isAdmin");
		
		if (null == isAdmin || !Boolean.getBoolean(isAdmin.toString())) {
			return "not admin";
		}
		
		String currentPageStr = request.getParameter("page");
		
		int currentPage = 1;
		int perpage = 10;
		if (StringUtil.isNotEmpty(currentPageStr)) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		
		UserExample userExample = new UserExample();
		userExample.setMysqlOffset(PageUtil.getStartRecord(currentPage, perpage));
		userExample.setMysqlLength(perpage);
		
		List<User> users = userService.selectByExample(userExample);
		
		// 总记录数
		int total = userService.countByExample(null);
        
        // 分页请求数据URL地址
        String url = "toUserList?";
        
        // 取得分页工具条
        String pageHtml = PageUtil.getBackPageHtml(currentPage, perpage, total, url);
		
        request.setAttribute("users", users);
		request.setAttribute("pageHtml", pageHtml);
		
		return "adminLogin";
	}

	
	@RequestMapping("/doApprove")
	public String validatorAdmin(Admin admin, HttpServletRequest request, HttpServletResponse response) {
		
		Object isAdmin = request.getSession().getAttribute("isAdmin");
		
		if (null == isAdmin || !Boolean.getBoolean(isAdmin.toString())) {
			return "not admin";
		}
		
		String userId = request.getParameter("userId");
		
		String approveFlag = request.getParameter("approveFlag");

		User user = userService.selectByPrimaryKey(Integer.parseInt(userId));
		
		// 审核通过
		if ("2".equals(approveFlag)) {
		    
		    // 1、插入node数据；2、标记为用户为审核通过；3、计算奖金；
		    money2CalculateService.saveApproveSuccess(user.getId(), Integer.valueOf(user.getJsrId()));
		} else {
		    
		    // 审核未通过
		    money2CalculateService.saveApproveFail(user.getId());
		}
		
		return null;
	}
}
