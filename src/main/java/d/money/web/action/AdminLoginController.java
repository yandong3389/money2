package d.money.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import d.money.common.utils.MD5Util;
import d.money.mapper.NodeExtMapper;
import d.money.pojo.base.Admin;
import d.money.pojo.base.AdminExample;
import d.money.pojo.base.Args;
import d.money.pojo.base.ArgsExample;
import d.money.pojo.base.User;
import d.money.service.AdminService;
import d.money.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

	@Autowired
	AdminService adminservice;
	@Autowired
	UserService userservice;
	@Autowired
	NodeExtMapper nodeExtMapper;

	@RequestMapping("/login")
	public String toAdminLogin(HttpServletRequest request) {
		request.setAttribute("message", "请输入管理员账号与密码");
		return "adminLogin";
	}

	@RequestMapping("/signup")
	public String validatorAdmin(Admin admin, HttpServletRequest request,
			HttpServletResponse response) {
		String account = admin.getAccount();
		String password = MD5Util.MD5(admin.getPassword());

		AdminExample example = new AdminExample();
		example.createCriteria().andAccountEqualTo(account)
				.andPasswordEqualTo(password);

		List<Admin> list = adminservice.selectByExample(example);

		if (list.size() > 0) {
			request.getSession()
					.setAttribute("username", list.get(0).getName());
			request.getSession().setAttribute("isAdmin", true);

			List<User> userlist = nodeExtMapper.selectUserByzctime();
			request.setAttribute("userlist", userlist);

			return "money/adminmain1";
		} else {
			request.setAttribute("message", "用户名或密码错误");
			return "adminLogin";
		}
	}

	@RequestMapping("main1")
	public String skipMain1(HttpServletRequest request) {
		List<User> list = nodeExtMapper.selectUserByzctime();
		request.setAttribute("userlist", list);
		return "money/adminmain1";
	}

	@RequestMapping("deleteUser")
	public String deleteUser(HttpServletRequest request) {
		String[] check = request.getParameterValues("check");
		for (int i = 0; i < check.length; i++) {
			userservice.deleteByPrimaryKey(Integer.valueOf(check[i]));
		}
		return this.skipMain1(request);
	}

	@RequestMapping("main2")
	public String skipMain2() {
		return "money/adminmain2";
	}

	@RequestMapping("main3")
	public String skipMain3(HttpServletRequest request,
			HttpServletResponse response) {
		ArgsExample example = new ArgsExample();
		example.setMysqlOffset(0);
		example.setMysqlLength(10);
		Args args = adminservice.selectByExmple(example).get(0);
		request.setAttribute("args", args);
		return "money/adminmain3";
	}

	@RequestMapping("main4")
	public String skipMain4(HttpServletRequest request,
			HttpServletResponse response) {
		return "money/adminmain4";
	}

	@RequestMapping("saveArgs")
	public String saveArgs(Args args, HttpServletRequest request,
			HttpServletResponse response) {
		adminservice.updateByPrimaryKey(args);
		return "money/adminmain3";
	}
}
