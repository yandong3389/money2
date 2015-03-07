package d.money.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import d.money.common.utils.PageUtil;
import d.money.common.utils.StringUtil;
import d.money.pojo.base.User;
import d.money.pojo.base.UserExample;
import d.money.service.UserService;

@Controller
public class AdminUserInfoController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/toUserList")
	public ModelAndView toUserList(HttpServletRequest request, HttpServletResponse response) {
		
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
		
		return new ModelAndView("money/adminmain5");
	}
	
	@RequestMapping("/toUpdateUserInfo")
	public ModelAndView toUpdateUserInfo(HttpServletRequest request, HttpServletResponse response) {
		
		int userId = Integer.valueOf(String.valueOf(request.getParameter("userId")));
		
		// 取得用户信息
		User user = userService.selectByPrimaryKey(userId);
		
		request.setAttribute("user", user);
		
		return new ModelAndView("money/adminmain55");
	}
	@RequestMapping("/updateUserInfo")
	public ModelAndView updateUserInfo(HttpServletRequest request, HttpServletResponse response) {
		
		int userId = Integer.valueOf(String.valueOf(request.getParameter("userId")));
		
		// 取得用户信息
		User user = userService.selectByPrimaryKey(userId);
		
		
		return new ModelAndView("money/adminmain55");
	}
	
}
