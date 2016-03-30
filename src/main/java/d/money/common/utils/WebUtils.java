package d.money.common.utils;

import javax.servlet.http.HttpServletRequest;


public class WebUtils {

	/**
	 * 
	 * 方法名:	getBasePath
	 * 方法描述：获得html标签<base href>的base_path值
	 * 参数：	@return 
	 * 返回值：	String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String getBasePath(HttpServletRequest request) {
		String scheme=request.getScheme()+"://";
		String requestURL=request.getRequestURL().toString();
		requestURL=requestURL.substring(scheme.length());
		int last=requestURL.indexOf("/");
		if(last==-1){
			last=requestURL.length();
		}
		requestURL=requestURL.substring(0,last);
		String basePath=scheme+requestURL+request.getContextPath()+"/";
		return basePath;
	}
	
	/**
	 * 取出比较地址中的参数
	 * @param url
	 * @return
	 */
	public static String removeParm(String url){
		int flag = url.indexOf("?");
		if(flag==-1){
			return url;
		}
		return url.substring(0,flag);		
	}
	
}
