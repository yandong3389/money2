package d.money.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

	@RequestMapping("/login")
	public String toAdminLogin() {
		return "adminLogin";
	}
}
