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

import d.money.pojo.base.UserInfo;
import d.money.pojo.base.UserInfoExample;
import d.money.service.UserInfoService;


@Controller
public class HelloController {

    @Autowired
    UserInfoService userInfoService;
    
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public ModelAndView hello(HttpServletRequest request, HttpServletResponse response) {
        
        UserInfoExample example = new UserInfoExample();
        
        example.setMysqlLength(50);
        example.setMysqlOffset(0);
        
        example.setOrderByClause("add_date desc");
        
        List<UserInfo> userinfos = userInfoService.selectByExample(example);
        
        request.setAttribute("userinfos", userinfos);
        
        logger.debug("hello ...");
        
        // 转发请求
        return new ModelAndView("module1/index");
    }
    @RequestMapping("/hello2")
    public ModelAndView hello2(HttpServletRequest request, HttpServletResponse response) {

        logger.debug("hello2 ...");
        
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");

        userInfoService.insertUserInfo(userName, userPass);
        
        // 重定向
        return new ModelAndView("redirect:hello");
    }
}
