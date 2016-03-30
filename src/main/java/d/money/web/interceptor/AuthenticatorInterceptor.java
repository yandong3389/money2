package d.money.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import d.money.common.utils.WebUtils;

public class AuthenticatorInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj, ModelAndView modelAndView)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {

	       // 获取基准路径
        String basePath = WebUtils.getBasePath(request);
        
        request.setAttribute("base_path", basePath);
	    
		// System.out.println("request.getRequestURL().toString(); -=========="
		// + request.getRequestURL().toString());
		// System.out.println("request.getRequestURI().toString(); -=========="
		// + request.getRequestURI().toString());
		//
		// System.out.println("request.getLocalName()  =============" +
		// request.getLocalName());
		// System.out.println("request.getLocalAddr()  =============" +
		// request.getLocalAddr());
		// System.out.println("request.getServerName()  =============" +
		// request.getServerName());
		//
		// System.out.println("preHandle3.................");
		String url = request.getRequestURL().toString();
		if (url.contains("login")||(url.contains("signup"))) {
			return true;
		}
		System.out.println(url);

		String username = (String) request.getSession()
				.getAttribute("username");
		if ("".equals(username) || null == username) {
			response.sendRedirect("/");
			return false;
		}
		return true;
	}

}
