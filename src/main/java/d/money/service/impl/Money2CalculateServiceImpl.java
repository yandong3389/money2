package d.money.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import d.money.common.utils.CollectionUtils;
import d.money.common.utils.Node;
import d.money.common.utils.NodeUtil;
import d.money.common.utils.StringUtil;
import d.money.mapper.NodeExtMapper;
import d.money.mapper.base.MoneyHistoryMapper;
import d.money.mapper.base.NodeMapper;
import d.money.mapper.base.UserMapper;
import d.money.mapper.base.UserProxyApplicationInfoMapper;
import d.money.pojo.UserProxyInfoView;
import d.money.pojo.base.MoneyHistory;
import d.money.pojo.base.NodeExample;
import d.money.pojo.base.User;
import d.money.pojo.base.UserExample;
import d.money.pojo.base.UserProxyApplicationInfo;
import d.money.pojo.base.UserProxyApplicationInfoExample;
import d.money.service.Money2CalculateService;

@Service
public class Money2CalculateServiceImpl implements Money2CalculateService {
	
	@Autowired
	NodeExtMapper nodeExtMapper;
	@Autowired
	NodeMapper nodeMapper;
	@Autowired
	MoneyHistoryMapper moneyHistoryMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	UserProxyApplicationInfoMapper userProxyApplicationInfoMapper;

	public int countByExample(NodeExample example) {
		return nodeMapper.countByExample(example);
	}
	
	/**
	 * 查询所有待审核的代理升级申请信息数据
	 * @return
	 */
	public List<UserProxyInfoView> selectUserProxyInfoViewList() {
	    
	    // 取得所有待审核代理用户数据
	    UserProxyApplicationInfoExample userProxyApplicationInfoExample = new UserProxyApplicationInfoExample();
	    // 1：待审核、2：审核通过、3：审核未通过
	    userProxyApplicationInfoExample.createCriteria().andApproveFlagEqualTo("1");
        List<UserProxyApplicationInfo> userProxyApplicationInfos = userProxyApplicationInfoMapper.selectByExample(userProxyApplicationInfoExample);
	    
        // 遍历抽取出用户ID集合
        List<Integer> userIdList = new ArrayList<Integer>();
        
        for (UserProxyApplicationInfo userProxyApplicationInfo : userProxyApplicationInfos) {
            userIdList.add(userProxyApplicationInfo.getUserId());
        }
        
        // 根据用户ID集合查询用户信息结果集，用于显示页面
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIn(userIdList);
        
        List<User> users = userMapper.selectByExample(userExample);
        
        List<UserProxyInfoView> result = new ArrayList<UserProxyInfoView>();
        UserProxyInfoView userProxyInfoView = null;
        
        for (User userTemp : users) {
            
            userProxyInfoView = new UserProxyInfoView();
            BeanUtils.copyProperties(userTemp, userProxyInfoView);
            
            for (UserProxyApplicationInfo userProxyApplicationInfo : userProxyApplicationInfos) {
                
                if (userProxyApplicationInfo.getUserId() == userProxyInfoView.getId()) {
                    
                    // 申请的代理级别
                    userProxyInfoView.setApplyProxyFlag(userProxyApplicationInfo.getUpProxyFlag());
                    
                    // 取得代理升级需要考核的指标数据（客户数量、省代个数、市代个数、县代个数）
                    Map<String, Object> map = selectProxyByUserId(userProxyInfoView.getId());
                    
                    // 客户数量
                    userProxyInfoView.setUserClientCount(Integer.parseInt(String.valueOf(map.get("userClientCount"))));
                    
                    // 省代/市代/县代
                    userProxyInfoView.setUserShengProxyCount(Integer.parseInt(String.valueOf(map.get("shengProxyCount"))));
                    userProxyInfoView.setUserShiProxyCount(Integer.parseInt(String.valueOf(map.get("shiProxyCount"))));
                    userProxyInfoView.setUserXianProxyCount(Integer.parseInt(String.valueOf(map.get("xianProxyCount"))));
                    break;
                }
            }
            
            result.add(userProxyInfoView);
        }
	    
	    return result;
	}
	
	/**
	 * 保存用户申请升级代理数据
	 * @return
	 */
	public String saveUpLevelProxyInfo (int userId) {
	    
	    Map<String, Object> result = selectProxyByUserId(userId);
	    
	    // 验证是否符合条件
	    String upProxyLevelFlag = String.valueOf(result.get("upProxyLevelFlag"));
	    
	    if ("0".equals(upProxyLevelFlag)) {
	        // 不满足升级条件
	        return "3";
	    }
	    
	    UserProxyApplicationInfoExample userProxyApplicationInfoExample = new UserProxyApplicationInfoExample();
	    userProxyApplicationInfoExample.createCriteria().andUserIdEqualTo(userId).andUpProxyFlagEqualTo(upProxyLevelFlag);
	    
	    int count = userProxyApplicationInfoMapper.countByExample(userProxyApplicationInfoExample);
	    
	    if (count > 0) {
	        
	        // 申请过升级了
	        return "2";
	    }
	    
	    // 插入申请记录
	    UserProxyApplicationInfo userProxyApplicationInfo = new UserProxyApplicationInfo();
	    
	    userProxyApplicationInfo.setUserId(userId);
	    userProxyApplicationInfo.setUpProxyFlag(upProxyLevelFlag);
	    userProxyApplicationInfo.setCreateDate(new Date());
	    // 1：待审核、2：审核通过、3：审核未通过
	    userProxyApplicationInfo.setApproveFlag("1");
	    userProxyApplicationInfo.setApproveDate(null);
	    
	    userProxyApplicationInfo.setUserMoney(Integer.parseInt(String.valueOf(result.get("userMoney"))));
	    userProxyApplicationInfo.setUserClientCount(Integer.parseInt(String.valueOf(result.get("userClientCount"))));
	    
	    userProxyApplicationInfo.setUserShengProxyCount(Integer.parseInt(String.valueOf(result.get("shengProxyCount"))));
	    userProxyApplicationInfo.setUserShiProxyCount(Integer.parseInt(String.valueOf(result.get("shiProxyCount"))));
	    userProxyApplicationInfo.setUserXianProxyCount(Integer.parseInt(String.valueOf(result.get("xianProxyCount"))));
	    
	    userProxyApplicationInfoMapper.insert(userProxyApplicationInfo);
	    
	    return "1";
	}
	
	// 组织结构树，个人中心(个人、管理员)
	// 个人详情页面，申请升级x级代理，奖金历史明细记录
	
	// 用户审核（验证上级只能有四个接点人），注册后不插入奖金及Node数据，审核通过时才插入
	// 审核x级代理申请
	
	// 奖金发放/周期结算
	
	/**
	 * 计算某人符合几级代理的升级条件
	 * @param userId
	 * @return int 如果返回0，表示不满足升级条件，非0，表示满足升到x级的代理条件
	 */
	public Map<String, Object> selectProxyByUserId(int userId) {
		
		// 当前用户信息对象
		User user = userMapper.selectByPrimaryKey(userId);
		
		// 用户当前代理级别 
		String proxyFlag = user.getProxyFlag();
		
		// 根据当前代理级别取得升级要求，取配置
		Map<String, Integer> proxyInfo = getMoneyScale(proxyFlag);
		int money = proxyInfo.get("money");
		int clientCount = proxyInfo.get("clientCount");
		int proxyCount = proxyInfo.get("proxyCount");
		
		// 当前用户投资额
		int userMoney = user.getUserMoney();
		
		UserExample userExample = new UserExample();
		userExample.createCriteria().andJsrIdEqualTo(String.valueOf(userId));
		
		// TODO 当前用户推荐客户数（客户和代理感觉有重复，如果是代理了还计不计算客户数量？排除掉代理的推荐下线？）
		int userClientCount = userMapper.countByExample(userExample);
		
		// 要求有10个县代，那我下边有9个县代，1个市代，算不算合格？（我下边的代理，计算的是推荐，不是接点）
		List<User> usersTemp = userMapper.selectByExample(userExample);
		
		// 当前用户县代理数
		int xianProxyCount = 0;
		// 当前用户市代理数
		int shiProxyCount = 0;
		// 当前用户省代理数
		int shengProxyCount = 0;
		
		for (User user2 : usersTemp) {
			
			if ("1".equals(user2.getProxyFlag())) {
				xianProxyCount ++;
			}
			if ("2".equals(user2.getProxyFlag())) {
				shiProxyCount ++;
			}
			if ("3".equals(user2.getProxyFlag())) {
				shengProxyCount ++;
			}
		}
		
		// 结果
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("xianProxyCount", xianProxyCount);
		result.put("shiProxyCount", shiProxyCount);
		result.put("shengProxyCount", shengProxyCount);
		result.put("userMoney", userMoney);
		result.put("userClientCount", userClientCount);
		
        // 投资金额不足
        if (userMoney < money) {
            // 不能升级
            result.put("upProxyLevelFlag", "0");
            return result;
        }
        // 客户数量不足
        if (userClientCount < clientCount) {
            // 不能升级
            result.put("upProxyLevelFlag", "0");
            return result;
        }
		
		// 符合要求的代理个数
		int nowProxyCount = 0;
		
		// 非代理
		if ("0".equals(proxyFlag)||StringUtil.isEmpty(proxyFlag)) {
			
			// 升县代不验证代理级别个数
			// 可以升级到1级（县代）
            result.put("upProxyLevelFlag", "1");
            return result;
		}
		// 某人下边的代理按推荐路线进行计算
		if ("1".equals(proxyFlag)) {
			
			// 当前县代升市代
			nowProxyCount = xianProxyCount + shiProxyCount + shengProxyCount;
			
			// 下级代理个数不够
			if (nowProxyCount >= proxyCount) {
				// 可以升级到2级（市代）
	            result.put("upProxyLevelFlag", "2");
	            return result;
			}
		}
		if ("2".equals(proxyFlag)) {
			
			// 当前市代升省代
			nowProxyCount = shiProxyCount + shengProxyCount;
			
			// 下级代理个数不够
			if (nowProxyCount >= proxyCount) {
				// 可以升级到3级（省代）
	            result.put("upProxyLevelFlag", "3");
	            return result;
			}
		}
		if ("3".equals(proxyFlag)) {
			
			// 当前省代，顶级不处理
		}
		
		// 不能升级
        result.put("upProxyLevelFlag", "0");
        return result;
	}
	
	/**
	 * 
	 * 用户注册审核通过
	 * 1、插入node数据
	 * 2、标记为用户为审核通过
	 * 3、计算奖金
	 * @param userId 当前新增加的用户ID
	 * @param parentId 当前新增加的用户的接点人ID
	 */
	public void saveApproveSuccess(int userId, int parentId) {
		
	    // 1、插入node数据
		// 取得接点人节点
		d.money.pojo.base.Node parentNode = nodeMapper.selectByPrimaryKey(parentId);
		d.money.pojo.base.Node node = new d.money.pojo.base.Node();
		node.setCreateDate(new Date());
		node.setId(userId);
		node.setParentId(parentId);
		// 设置级别为接点人的下一级
		node.setLevel((parentNode.getLevel()+1));
		nodeMapper.insert(node);
		
		// 2、标记为用户为审核通过
		User user = new User();
		user.setId(userId);
		user.setApproveFlag("2");
		user.setApproveDate(new Date());
		userMapper.updateByPrimaryKeySelective(user);
		
		// 3、计算奖金
		updateMoney(userId, parentId);
	}
	
    /**
     * 审核未通过，标记用户为审核未通过状态
     * @param userId
     * @param parentId
     */
    public void saveApproveFail(int userId) {
        
        // 标记为用户为审核未通过
        User user = new User();
        user.setId(userId);
        user.setApproveFlag("3");
        user.setApproveDate(new Date());
        userMapper.updateByPrimaryKeySelective(user);
    }
	
	/**
	 * 更新奖金数据,记录奖金获取历史
	 * @param currentNodeId 本次追加节点ID(当前新增加的用户ID)
	 */
	private void updateMoney(int currentNodeId, int currentUserJsrId) {
		
	    // 当前投资用户对象
	    User currentUser = userMapper.selectByPrimaryKey(currentNodeId);
	    
	    // 当前系统时间
	    Date sysDate = new Date();
	    
		// ****************************处理级差奖金****************************
		/*
		 * 计划级别时不算自己的投资金额
		 * 获取一条线上的所有上级
		 * 从最近的上级开始发放级差奖金，
		 * 先计算上级所在级别（三个条件），该级别对应的百分比，得出奖金金额，
		 * 再向上一级时，同样先计算上级所在级别（三个条件，金额条件是大于，不含等于），该级别对应的百分比，得出奖金金额，再减掉之前被拿出的级差资金
		 * A->B->C->D（级差，两级奖金比例之差）
		 * D注册审核通过
		 * A=A%-B%
		 * B=B%-C%
		 * C=C%
		 */
		
	    // 取得所有节点数据
        List<Node> allNodeList = nodeExtMapper.selectByExample(null);
        NodeUtil.convertChild(allNodeList);
        NodeUtil.convertParent(allNodeList);
        
        // 获取一条线上的所有上级节点
        List<Node> parentNodeList = getNodeListForJX(allNodeList, currentNodeId);
        
        // 上一级的级别对应的奖金比例
        int preMoneyScale = -1;
        
        // 遍历一条线上的所有上级节点,计算级别，追加奖金
        for (Node node : parentNodeList) {
            
            // 计算用户的级别（总业绩、考核市场、最小市场业绩），得到级别对应的奖金比例
            // TODO 总业绩，需不需要把此次用户投资的金额也计算在内（目前没算） 
            int totalMoney = 0;
            // 市场考核人数
            int userCount = node.getChildren().size();
            // 市场业绩
            int subMoney = 0;
            
            // 查询这个用户的所有子节点的ID集合
            List<Integer> result = new ArrayList<Integer>();
            getChildsUserIdList(node, result);
            
            if (CollectionUtils.isNotEmpty(result)) {
                
                UserExample userExample = new UserExample();
                // 审核状态,通过才计算（1：待审核、2：审核通过、3：审核未通过）
                userExample.createCriteria().andIdIn(result).andApproveFlagEqualTo("2");
                List<User> userList = userMapper.selectByExample(userExample);
                
                // 市场考核人员
                List<Node> children = node.getChildren();
                
                for (User user : userList) {
                    // 累加总业绩
                    totalMoney += user.getUserMoney();
                    
                    for (Node nodeTemp : children) {
                        if (nodeTemp.getId() == user.getId()) {
                            // 累加市场业绩
                            subMoney += user.getUserMoney();
                            break;
                        }
                    }
                }
            }
            
            // 等级匹配,三个条件,递归向上逐级匹配
            // totalMoney userCount subMoney
            // 当前用户所属级别对应的比例
            int moneyScale = getMoneyScale(totalMoney, userCount, subMoney);
            
            // 级差奖金金额
            int awardMoney = 0;
            
            // 需要与前一个人的比相减,所剩的才是本次应得的
            if (preMoneyScale != -1 && (moneyScale - preMoneyScale) > 0) {
                
                awardMoney = (currentUser.getUserMoney() / 100) * (moneyScale - preMoneyScale);
            } else {
                
                // 投资人的直接上级，不需要计算级差，直接按等级比例发放奖金
                awardMoney = (currentUser.getUserMoney() / 100) * moneyScale;
            }
            
            // 插入级差奖金数据
            MoneyHistory history = new MoneyHistory();
            history.setId(node.getId());
            // 奖金类型 1：级差奖金、2：隔代奖金、3：代理奖金
            history.setType(1);
            history.setCreateDate(sysDate);
            history.setAwardMoney(awardMoney);
            history.setLinkUserId(currentNodeId);
            moneyHistoryMapper.insert(history);
            
            // 记录此次等级对应比例，用于向上一级推的时候计算级差
            preMoneyScale = moneyScale;
        }
        
        
        
        
		// ****************************处理隔代奖金****************************
		/*
		 * 获取当前注册用户上级的上级，增加隔代奖金，上级计算按照推荐人，不
		 * 只给一个人加？
		 */
        
        // 隔代用户
        User gduser = getNodeListForGD(currentUserJsrId);
        
        // 有隔代用户才给隔代奖金
        if (gduser != null) {
            
            // TODO 隔代奖金比例,取配置
            int gdMoneyScale = 10;
            
            // 插入隔代奖金数据
            MoneyHistory history = new MoneyHistory();
            history.setId(gduser.getId());
            // 奖金类型 1：级差奖金、2：隔代奖金、3：代理奖金
            history.setType(2);
            history.setCreateDate(sysDate);
            history.setAwardMoney((currentUser.getUserMoney() / 100) * gdMoneyScale);
            history.setLinkUserId(currentNodeId);
            moneyHistoryMapper.insert(history);
        }
        
        
        
		// ****************************处理代理奖金****************************
		/*
		 *  A->B->C->D 比如这样的关系，D注册进来，代理奖金都给谁加，一条线上的所有上级（接点人树结构），符号什么级别的代理就给计算什么级别的代理奖金
		 *  
		 */
		
        // TODO 代理奖金比例读取配置
        // 省代奖金比例
        int shengDaiMoneyScale = 1;
        // 市代奖金比例
        int shiDaiMoneyScale = 1;
        // 县代奖金比例
        int xianDaiMoneyScale = 3;
        
        // 遍历一条线上的所有上级节点,计算级别，追加奖金
        for (Node node : parentNodeList) {
            
            // 代理用户信息数据对象
            User user = userMapper.selectByPrimaryKey(node.getId());
            // 0：非代理
            if (StringUtil.isEmpty(user.getProxyFlag()) || "0".equals(user.getProxyFlag())) {
                break;
            }
            
            // 插入代理奖金数据
            MoneyHistory history2 = new MoneyHistory();
            history2.setId(gduser.getId());
            // 奖金类型 1：级差奖金、2：隔代奖金、3：代理奖金
            history2.setType(3);
            history2.setCreateDate(sysDate);
            history2.setLinkUserId(currentNodeId);
            
            // 代理类型，1：县代、2：市代、3：省代
            if ("1".equals(user.getProxyFlag())) {
                history2.setAwardMoney((currentUser.getUserMoney() / 100) * xianDaiMoneyScale);
            } else if ("2".equals(user.getProxyFlag())) {
                history2.setAwardMoney((currentUser.getUserMoney() / 100) * shiDaiMoneyScale);
            } else if ("3".equals(user.getProxyFlag())) {
                history2.setAwardMoney((currentUser.getUserMoney() / 100) * shengDaiMoneyScale);
            }
            
            moneyHistoryMapper.insert(history2);
        }
        
	}
	
	private void getChildsUserIdList(Node node, List<Integer> result){
	    
	    if (CollectionUtils.isEmpty(result)) {
	        // 首次调用不向result中追加，排除自己
	        result.add(node.getId());
	    }
	    
	    List<Node> children = node.getChildren();
	    if (CollectionUtils.isNotEmpty(children)) {
	        for (Node node2 : children) {
	            getChildsUserIdList(node2, result);
	        }
	    }
	}
	
	
	/**
	 * 级差节点（获取一条线上的所有上级）
	 * @param node
	 * @return
	 */
	public List<Node> getNodeListForJX(List<Node> dataList, int id) {

        // 取得自己节点的数据
        Node thisNode = NodeUtil.getNodeById(dataList, id);
        Node parentNode = thisNode.getParentNode();
        List<Node> result = new ArrayList<Node>();
		if (parentNode != null) {
		    getNodeForJX(parentNode, id, result);
		}

		return result;
	}
	private void getNodeForJX(Node parentNode, int id, List<Node> result){
	    
	    result.add(parentNode);
	    parentNode = parentNode.getParentNode();
	    if (parentNode != null) {
	        getNodeForJX(parentNode, id, result);
	    }
	}
	
	/**
	 * 隔代节点（上级的上级节点）
	 * @param dataList
	 * @param id 本次追加节点ID
	 * @return
	 */
	public User getNodeListForGD(int jsrId) {

	    UserExample userExample = new UserExample();
	    userExample.createCriteria().andIdEqualTo(jsrId);
	    List<User> users = userMapper.selectByExample(userExample);
	    
	    if (CollectionUtils.isEmpty(users)) {
	        return null;
	    }
		
	    // 取得介绍人的介绍人用户信息对象
		return userMapper.selectByPrimaryKey(Integer.parseInt(users.get(0).getJsrId()));
	}

    /**
     * 根据用户业绩的三个指标取得等级对应的级差奖金比率
     * @param totalMoney
     * @param userCount
     * @param subMoney
     */
    private Map<String, Integer> getMoneyScale(String proxyLevelFlag) {
        
        // TODO 取数据库配置
        
        Map<String, Integer> result = new HashMap<String, Integer>();
        
        // 当前非代理
        if ("0".equals(proxyLevelFlag)||StringUtil.isEmpty(proxyLevelFlag)) {
            result.put("money", 20000);
            result.put("clientCount", 10);
            result.put("proxyCount", 0);
        }
        // 当前县代升市代
        if ("1".equals(proxyLevelFlag)) {
            result.put("money", 50000);
            result.put("clientCount", 10);
            result.put("proxyCount", 10);
        }
        // 当前市代升省代
        if ("2".equals(proxyLevelFlag)) {
            result.put("money", 100000);
            result.put("clientCount", 10);
            result.put("proxyCount", 10);
        }
//        // 当前省代，不能再升了
//        if ("3".equals(proxyLevelFlag)){
//            result.put("money", 9999);
//            result.put("clientCount", 9999);
//            result.put("proxyCount", 9999);
//        }
        
        return result;   
    }
    
	/**
	 * 根据用户业绩的三个指标取得等级对应的级差奖金比率
	 * @param totalMoney
	 * @param userCount
	 * @param subMoney
	 */
	private int getMoneyScale(int totalMoney, int userCount, int subMoney) {

	    // TODO 取数据库配置
	    
	    // 十二级
	    if (totalMoney > 200000000 && userCount >= 4 && subMoney >= 15000000) {
	        return 65;
	    }
	    // 十一级
	    if (totalMoney > 100000000 && userCount >= 4 && subMoney >= 10000000) {
	        return 60;
	    }
	    // 十级
	    if (totalMoney > 80000000 && userCount >= 3 && subMoney >= 10000000) {
	        return 55;
	    }
	    // 九级
	    if (totalMoney > 50000000 && userCount >= 3 && subMoney >= 5000000) {
	        return 50;
	    }
	    // 八级
	    if (totalMoney > 20000000 && userCount >= 3 && subMoney >= 2000000) {
	        return 45;
	    }
	    // 七级
	    if (totalMoney > 10000000 && userCount >= 3 && subMoney >= 1500000) {
	        return 40;
	    }
	    // 六级
	    if (totalMoney > 6000000 && userCount >= 2 && subMoney >= 800000) {
	        return 35;
	    }
	    // 五级
	    if (totalMoney > 3000000 && userCount >= 2 && subMoney >= 500000) {
	        return 30;
	    }
	    // 四级
	    if (totalMoney > 1000000 && userCount >= 2 && subMoney >= 100000) {
	        return 25;
	    }
	    // 三级
	    if (totalMoney > 500000 && userCount >= 1 && subMoney >= 10000) {
	        return 20;
	    }
	    // 二级
	    if (totalMoney > 100000 && userCount >= 1 && subMoney >= 10000) {
	        return 15;
	    }
	    // 一级
	    if (totalMoney > 10000 && userCount >= 1 && subMoney >= 10000) {
	        return 10;
	    }
	    
	    // 无等级
	    return 0;
    }

}
