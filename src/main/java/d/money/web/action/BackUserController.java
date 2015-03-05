package d.money.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import d.money.common.utils.PageUtil;


/**
 * 用户列表
 */
@Controller
public class BackUserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/findUserDetail")
    public ModelAndView findUserList(HttpServletRequest request, HttpServletResponse response) {

    	
    	
    	String userId = null;
        
     // 从请求参数中取得当前页码
        String currentPageStr = request.getParameter("page");
        
        // 默认为第一页
        int currentPage = 1;
        // TODO 每页显示条数
        int perpage = 10;
        
        if (d.money.common.utils.StringUtil.isNotEmpty(currentPageStr)) {
            currentPage = Integer.valueOf(currentPageStr);
        }
        
        int total = 0;
        
     // 分页请求数据URL地址
        String url = "findUserDetail?";
        
        // 取得分页工具条
        String pageHtml = PageUtil.getBackPageHtml(currentPage, perpage, total, url);
        
        request.setAttribute("moneyDetailList", null);
        
        request.setAttribute("pageHtml", pageHtml);
        
        return new ModelAndView("module2/money_detail");
    }
}
