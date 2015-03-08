package d.money.web.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import d.money.common.utils.MD5Util;
import d.money.pojo.base.User;
import d.money.pojo.base.UserExample;
import d.money.service.AdminService;
import d.money.service.MoneyCalculateService;
import d.money.service.UserService;

@Controller
@RequestMapping("/user")
public class UserLoginController {

	@Autowired
	UserService userservice;
	@Autowired
	AdminService adminservice;
	@Autowired
	MoneyCalculateService moneyservice;

	@RequestMapping("/login")
	public void toAdminLogin(HttpServletRequest request, PrintWriter pw) {
		String id = request.getParameter("username");
		String password = MD5Util.MD5(request.getParameter("password"));

		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(Integer.valueOf(id))
				.andPasswordEqualTo(password);

		List<User> list = userservice.selectByExample(example);
		if (list.size() > 0) {
			request.getSession().setAttribute("username", id);
			request.getSession().setAttribute("isAdmin", false);
			pw.print("success");
		} else {
			pw.print("error");
		}
	}

	/**
	 * 跳转至注册邀请页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/regInvite")
	public String userRegister(HttpServletRequest request,
			HttpServletResponse response) {
		return "money/registerInvite";
	}

	/**
	 * 确认邀请码
	 * 
	 * @param request
	 * @param pw
	 * @throws Exception
	 */
	@RequestMapping("/confirmUser")
	public void confirmUser(HttpServletRequest request, PrintWriter pw) {
		String inviteCode = request.getParameter("code");
		UserExample example = new UserExample();

		example.createCriteria().andAdminCodeEqualTo(inviteCode);
		List<User> list = userservice.selectByExample(example);
		if (list.size() > 0) {
			pw.print("success");
		} else {
			pw.print("error");
		}
	}

	/**
	 * 跳转到注册页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/regUser")
	public String regUser(User user, HttpServletRequest request) {
		String code = request.getParameter("code");
		if ("".equals(code) || code == null) {
			return "money/registerInvite";
		}
		return "money/register";
	}

	/**
	 * 
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/regsubmit")
	public String userRegSubmit(User user, HttpServletRequest request) {
		String name = user.getName();
		UserExample example = new UserExample();
		example.createCriteria().andNameEqualTo(name);

		List<User> list = userservice.selectByExample(example);
		if (list.size() > 0) {
			request.setAttribute("msg", "此姓名已注册，请换另一个名字，例张三1、张三2");
			return "money/register";
		}

		user.setPassword(MD5Util.MD5(user.getPassword()));
		user.setZcTime(new Date());
		int i = userservice.insert(user);
		if (i == 0) {
			request.setAttribute("msg", "注册出错，请从新注册");
			return "money/register";
		} else {
			List<User> list1 = userservice.selectByExample(example);
			String id = String.valueOf(list1.get(0).getId());
			request.setAttribute("id", id);

			// 计算奖金，节点
			moneyservice.insertNode(Integer.valueOf(id),
					Integer.valueOf(list1.get(0).getJdrId()));
			moneyservice.updateMoney(Integer.valueOf(id));

			return "money/registerSuccess";
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/userlogout")
	public String loginout(HttpServletRequest request) {
		Enumeration em = request.getSession().getAttributeNames();
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString());
		}
		return "redirect:/";
	}
}
