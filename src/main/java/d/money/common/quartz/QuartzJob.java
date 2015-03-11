package d.money.common.quartz;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import d.money.common.spring.SpringContextHolder;
import d.money.common.utils.CollectionUtils;
import d.money.common.utils.DateUtil;
import d.money.mapper.base.ArgsMapper;
import d.money.mapper.base.MoneyHistoryMapper;
import d.money.mapper.base.UserMapper;
import d.money.mapper.base.WeekEndMapper;
import d.money.pojo.base.Args;
import d.money.pojo.base.MoneyHistory;
import d.money.pojo.base.MoneyHistoryExample;
import d.money.pojo.base.User;
import d.money.pojo.base.UserExample;
import d.money.pojo.base.WeekEnd;
import d.money.pojo.base.WeekEndExample;

/**
 * 任务调度实现类
 * @version 2015-03-07
 * @author Lawliet
 */
@Controller
public class QuartzJob {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * 任务调度
     * 奖金周结,向周结表中插入数据
     */
    public void moneyWeekEnd() {
    	
    	logger.info("开始周结,当前时间为：" + DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
    	
    	UserMapper userMapper = SpringContextHolder.getBean("userMapper");
    	MoneyHistoryMapper moneyHistoryMapper = SpringContextHolder.getBean("moneyHistoryMapper");
    	WeekEndMapper weekEndMapper = SpringContextHolder.getBean("weekEndMapper");
    	ArgsMapper argsMapper = SpringContextHolder.getBean("argsMapper");
    	
    	// 取得默认一条配置数据
    	Args args = argsMapper.selectByExample(null).get(0);
    	
    	// 按姓名正序排列
    	UserExample userExample = new UserExample();
    	userExample.setOrderByClause("name asc");
    	
    	// 取得所有用户数据
    	List<User> userList = userMapper.selectByExample(null); 
    	
    	// 取得过去七天的奖金明细数据,以用户ID分组,列出每个用户对应获取的不同类型的奖金各多少个
    	Date nowDate = new Date();
    	Date backDate = DateUtil.rollDate(nowDate, Calendar.DATE, -7);
    	MoneyHistoryExample moneyHistoryExample = new MoneyHistoryExample();
    	moneyHistoryExample.createCriteria().andCreateDateBetween(backDate, nowDate);
    	// 前七天的奖金记录数据
        List<MoneyHistory> histories = moneyHistoryMapper.selectByExample(moneyHistoryExample);

        // 默认期数为1
        int weekCount = 1;
        
        WeekEndExample weekEndExample = new WeekEndExample();
        weekEndExample.setOrderByClause("week_count desc");
        weekEndExample.setMysqlOffset(0);
        weekEndExample.setMysqlLength(1);
        
        // 取得最后一个周结的期数
        List<WeekEnd> weekEnds = weekEndMapper.selectByExample(weekEndExample);
        
        if (CollectionUtils.isNotEmpty(weekEnds)) {
        	
        	// 本期期数为上周期数+1
        	weekCount = (weekEnds.get(0).getWeekCount() + 1);
        }
        
        // 周结对象
        WeekEnd weekEnd = null;
        
        List<WeekEnd> noMoneyWeekEnd = new ArrayList<WeekEnd>();
        
        int sortFlag = 1;
        
        for (User user : userList) {
			
        	weekEnd = new WeekEnd();
        	
        	weekEnd.setBeginDate(backDate);
        	weekEnd.setEndDate(nowDate);
        	weekEnd.setUserId(user.getId());
        	weekEnd.setWeekCount(weekCount);
        	
        	int money = 0;
        	
        	int m30 = 0;
        	int m20 = 0;
        	int m5 = 0;
        	
        	for (MoneyHistory moneyHistory : histories) {
        		
        		if (user.getId() == moneyHistory.getId()) {
        			
        			// 推荐
        			if (moneyHistory.getType() == 1) {
        				m30 += args.getBonus() / 100 * args.getTjBonusPercent();
        			}
        			// 直系
        			else if (moneyHistory.getType() == 2) {
        				m20 += args.getBonus() / 100 * args.getZxBonusPercent();
        			}
        			// 旁系
        			else if (moneyHistory.getType() == 3) {
        				m5 += args.getBonus() / 100 * args.getPxBonusPercent();
        			}
        		}
        	}
        	
        	// 推荐奖金总额 + (直系奖金总额  + 旁系奖金总额)(大于10000按10000算)
        	money = m30 + ((m20 + m5) > 10000 ? 10000 : (m20 + m5));
        	// 设置奖金
        	weekEnd.setMoney(money);
        	
        	// 如果没奖金
        	if (money == 0) {
        		
        		// 1：没钱、2：有钱没结算、3：有钱已结算
        		weekEnd.setFlag(1);
        		noMoneyWeekEnd.add(weekEnd);
        	} else {
        		
        		// 1：没钱、2：有钱没结算、3：有钱已结算
        		weekEnd.setFlag(2);
        		// 排序条件
        		weekEnd.setSortFlag(sortFlag);
        		sortFlag ++;
        		// 插入数据至数据库,无奖金用户数据在最新再执行插入
        		weekEndMapper.insert(weekEnd);
        	}
		}
        
        // 插入无奖金用户数据
        if (CollectionUtils.isNotEmpty(noMoneyWeekEnd)) {
        	
        	for (WeekEnd weekEnd2 : noMoneyWeekEnd) {
        		
        		weekEnd2.setSortFlag(sortFlag);
        		sortFlag ++;
        		weekEndMapper.insert(weekEnd2);
        	}
        }
        
    	logger.info("奖金周结结束，结算时间为：" + DateUtil.formatDate(backDate, "yyyy-MM-dd HH:mm:ss") + "至" + DateUtil.formatDate(nowDate, "yyyy-MM-dd HH:mm:ss"));
    }
    
}
