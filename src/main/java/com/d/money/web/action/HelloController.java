//package com.d.money.web.action;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Random;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.clbus.matouwang.pojo.base.Criteria;
//import com.clbus.matouwang.pojo.base.TArticle;
//import com.clbus.matouwang.service.TArticleService;
//
//@Controller
//public class HelloController {
//
//    @Autowired
//    TArticleService tArticleService;
//    
//    
//    Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @RequestMapping("/hello")
//    public ModelAndView hello(HttpServletRequest request, HttpServletResponse response) {
//        
//        Criteria example = new Criteria();
//        
//        example.setOrderByClause("DATE_ADD desc");
//        
//        example.setMysqlLength(50);
//        example.setMysqlOffset(0);
//        
//        
//        
//        List<TArticle> articles = tArticleService.selectByExample(example);
//        
//        request.setAttribute("articles", articles);;
//        
//        logger.debug("hello ...");
//        
//        // 转发请求
//        return new ModelAndView("module1/index");
//    }
//    @RequestMapping("/hello2")
//    public ModelAndView hello2(HttpServletRequest request, HttpServletResponse response) {
//
//        logger.debug("hello2 ...");
//        
//        TArticle record = new TArticle();
//        record.setId(new Random().nextInt(999)+"");
//        record.setSortId("1");
//        record.setArticleTitle("test" + new Random().nextInt(999));
//        record.setDateAdd(new Date());
//        
//        tArticleService.insertSelective(record);
//        
//        // 重定向
//        return new ModelAndView("redirect:hello");
//    }
//}
