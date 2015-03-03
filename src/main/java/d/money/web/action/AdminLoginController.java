package d.money.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import d.money.common.utils.MD5Util;
import d.money.pojo.base.Admin;
import d.money.pojo.base.AdminExample;
import d.money.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

	@Autowired
	AdminService adminservice;

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
		example.or().andAccountEqualTo(account);
		example.or().andAccountEqualTo(password);
		

		List<Admin> list = adminservice.selectByExample(example);

		if (list.size() > 0) {
			request.getSession().setAttribute("username", list.get(0).getName());
			request.getSession().setAttribute("password", password);
			return "money/adminmain";
		} else {
			request.setAttribute("message", "用户名或密码错误");
			return "adminLogin";
		}

	}
}
