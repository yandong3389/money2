package d.money.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import d.money.common.utils.CollectionUtils;
import d.money.common.utils.NodeUtil;
import d.money.common.utils.PageUtil;
import d.money.mapper.MoneyHistoryExtMapper;
import d.money.mapper.NodeExtMapper;
import d.money.mapper.base.ArgsMapper;
import d.money.mapper.base.MoneyHistoryMapper;
import d.money.mapper.base.NodeMapper;
import d.money.mapper.base.UserMapper;
import d.money.mapper.base.WeekEndMapper;
import d.money.pojo.base.Args;
import d.money.pojo.base.MoneyHistory;
import d.money.pojo.base.MoneyHistoryExample;
import d.money.pojo.base.NodeExample;
import d.money.pojo.base.User;
import d.money.pojo.base.UserExample;
import d.money.pojo.base.WeekEnd;
import d.money.pojo.base.WeekEndExample;
import d.money.service.MoneyDetailService;

@Service
public class MoneyDetailServiceImpl implements MoneyDetailService {
	
	@Autowired
	NodeExtMapper nodeExtMapper;
	@Autowired
	NodeMapper nodeMapper;
	@Autowired
	MoneyHistoryMapper moneyHistoryMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	ArgsMapper argsMapper;
	@Autowired
	MoneyHistoryExtMapper moneyHistoryExtMapper;
	@Autowired
	WeekEndMapper weekEndMapper;
	
	/**
	 * 取得指定用户的所有子节点
	 */
	public List<d.money.common.utils.Node> getDefaultTree(int userId) {
		
		// 取得所有节点数据
		List<d.money.common.utils.Node> allNodeList = nodeExtMapper.selectByExample(null);
		
		List<Integer> nodeIdList = new NodeUtil().getChildNodes(allNodeList, userId, -1);
		
		nodeIdList.add(userId);
		
		NodeExample nodeExample = new NodeExample();
		nodeExample.createCriteria().andIdIn(nodeIdList);
		
		List<d.money.common.utils.Node> nodes = nodeExtMapper.selectByExample(null);
		
		UserExample userExample = new UserExample();
		userExample.createCriteria().andIdIn(nodeIdList);
		List<User> userList = userMapper.selectByExample(userExample);
		
		NodeUtil.convertChild(nodes);
//		NodeUtil.convertParent(nodes);

		for (d.money.common.utils.Node node : nodes) {
			
			for (User user : userList) {
				
				if (node.getId() == user.getId()) {
					node.setUser(user);
					continue;
				}
			}
		}
		
		return nodes;
	}
	
	/**
	 * 取得用户奖金明细
	 * @param id
	 * @param currentPage
	 * @param perPage
	 * @return
	 */
	public List<MoneyHistory> getHistoryDetail(int id, int currentPage, int perPage){
		
		MoneyHistoryExample example = new MoneyHistoryExample();
		example.setMysqlLength(perPage);
		example.setMysqlOffset(PageUtil.getStartRecord(currentPage, perPage));
		example.createCriteria().andIdEqualTo(id);
		example.setOrderByClause("create_date desc");
		
		List<MoneyHistory> histories = moneyHistoryMapper.selectByExample(example);
		
		return histories;
	}
	
	public List<Integer> getData(int userId){
		
		// 取得默认一条配置数据
		Args args = argsMapper.selectByExample(null).get(0);
		
		Map<String, Integer> param1 = new HashMap<String, Integer>();
		param1.put("userId", userId);
		param1.put("type", 1);
		Map<String, Integer> param2 = new HashMap<String, Integer>();
		param2.put("userId", userId);
		param2.put("type", 2);
		Map<String, Integer> param3 = new HashMap<String, Integer>();
		param3.put("userId", userId);
		param3.put("type", 3);
		
		// 奖金类型1：推荐奖金、2：直系奖金、3：旁系奖金
		int type1 = moneyHistoryExtMapper.countByType(param1);
		int type2 = moneyHistoryExtMapper.countByType(param2);
		int type3 = moneyHistoryExtMapper.countByType(param3);
		
		List<Integer> result = new ArrayList<Integer>();
		
		result.add(((int) (args.getBonus()/100*args.getTjBonusPercent()*type1)));
		result.add(((int) (args.getBonus()/100*args.getZxBonusPercent()*type2)));
		result.add(((int) (args.getBonus()/100*args.getPxBonusPercent()*type3)));
		
		return result;
	}
	
	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public Args getConfig(){
		return argsMapper.selectByExample(null).get(0);
	}

	public int getHistoryDetailCount(int id) {
		
		MoneyHistoryExample example = new MoneyHistoryExample();
		example.createCriteria().andIdEqualTo(id);
		
		return moneyHistoryMapper.countByExample(example);
	}
	
	/**
	 * 最后一期奖金结算数据条数
	 * @return
	 */
	public int getWeekEndsCount(){
		
        // 默认期数为1
        int weekCount = 1;
        
        WeekEndExample weekEndExample = new WeekEndExample();
        weekEndExample.setOrderByClause("week_count desc");
        weekEndExample.setMysqlOffset(0);
        weekEndExample.setMysqlLength(1);
        
        // 取得最后一个周结的期数
        List<WeekEnd> weekEnds = weekEndMapper.selectByExample(weekEndExample);
        
        if (CollectionUtils.isNotEmpty(weekEnds)) {
        	
        	// 取得最后一个周结的期数
        	weekCount = weekEnds.get(0).getWeekCount();
        }
		
        weekEndExample.clear();
        weekEndExample.createCriteria().andWeekCountEqualTo(weekCount);
		
        // 取得最后一期奖金结算数据
		return weekEndMapper.countByExample(weekEndExample);
	}
	
	/**
	 * 最后一期奖金结算数据
	 * @return
	 */
	public List<WeekEnd> getWeekEnds(int currentPage, int perPage){
		
        // 默认期数为1
        int weekCount = 1;
        
        WeekEndExample weekEndExample = new WeekEndExample();
        weekEndExample.setOrderByClause("week_count desc");
        weekEndExample.setMysqlOffset(0);
        weekEndExample.setMysqlLength(1);
        
        // 取得最后一个周结的期数
        List<WeekEnd> weekEnds = weekEndMapper.selectByExample(weekEndExample);
        
        if (CollectionUtils.isNotEmpty(weekEnds)) {
        	
        	// 取得最后一个周结的期数
        	weekCount = weekEnds.get(0).getWeekCount();
        }
		
        weekEndExample.clear();
        weekEndExample.createCriteria().andWeekCountEqualTo(weekCount);
        weekEndExample.setMysqlLength(perPage);
        weekEndExample.setMysqlOffset(PageUtil.getStartRecord(currentPage, perPage));
		
        // 取得最后一期奖金结算数据
		return weekEndMapper.selectByExample(weekEndExample);
	}
	
	/**
	 * 更新结算状态（由未结算更新至已结算）
	 * @param pkId 结算数据主键
	 * @return
	 */
	public int updateWeekFlag(int pkId) {
		
		WeekEnd weekEnd = weekEndMapper.selectByPrimaryKey(pkId);
		weekEnd.setFlag(3);
		
		return weekEndMapper.updateByPrimaryKeySelective(weekEnd);
	}
	
}
