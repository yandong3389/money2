package d.money.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import d.money.common.utils.CollectionUtils;
import d.money.common.utils.Node;
import d.money.common.utils.NodeUtil;
import d.money.common.utils.StringUtil;
import d.money.mapper.NodeExtMapper;
import d.money.mapper.base.MoneyHistoryMapper;
import d.money.mapper.base.NodeMapper;
import d.money.mapper.base.UserInfoMapper;
import d.money.mapper.base.UserMapper;
import d.money.pojo.base.MoneyHistory;
import d.money.pojo.base.NodeExample;
import d.money.pojo.base.User;
import d.money.pojo.base.UserExample;
import d.money.pojo.base.UserInfo;
import d.money.pojo.base.UserInfoExample;
import d.money.service.Money2CalculateService;
import d.money.service.MoneyCalculateService;

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

	public int countByExample(NodeExample example) {
		return nodeMapper.countByExample(example);
	}
	
	/**
	 * 插入node数据
	 * @param userId 当前新增加的用户ID
	 * @param parentId 当前新增加的用户的接点人ID
	 */
	public void insertNode(int userId, int parentId){
		
		// 取得接点人节点
		d.money.pojo.base.Node parentNode = nodeMapper.selectByPrimaryKey(parentId);
		
		d.money.pojo.base.Node node = new d.money.pojo.base.Node();
		node.setCreateDate(new Date());
		node.setId(userId);
		node.setParentId(parentId);
		// 设置级别为接点人的下一级
		node.setLevel((parentNode.getLevel()+1));
		
		nodeMapper.insert(node);
	}
	
	/**
	 * 更新奖金数据,记录奖金获取历史
	 * @param currentNodeId 本次追加节点ID(当前新增加的用户ID)
	 */
	public void updateMoney (int currentNodeId, int currentUserJsrId) {
		
	    // 当前投资用户对象
	    User currentUser = userMapper.selectByPrimaryKey(currentNodeId);
	    
	    // 当前系统时间
	    Date sysDate = new Date();
	    
		// TODO ****************************处理级差奖金****************************
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
            // 查询这个用户的所有子节点的ID集合
            List<Integer> result = new ArrayList<Integer>();
            getChildsUserIdList(node, result);
            
            UserExample userExample = new UserExample();
            // 审核状态,通过才计算（1：待审核、2：审核通过、3：审核未通过）
            userExample.createCriteria().andIdIn(result).andApproveFlagEqualTo("2");
            List<User> userList = userMapper.selectByExample(userExample);
            
            // TODO 总业绩，需不需要把此次用户投资的金额也计算在内
            int totalMoney = 0;
            // 市场考核人数
            int userCount = node.getChildren().size();
            // 市场业绩
            int subMoney = 0;
            
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
            
            // TODO 等级匹配,三个条件,递归向上逐级匹配
            // TODO 当前用户所属级别对应的比例
            int moneyScale = 20;
            
            
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
        
        
        
        
		// TODO ****************************处理隔代奖金****************************
		/*
		 * 获取当前注册用户上级的上级，增加隔代奖金，上级计算按照推荐人，不
		 * 只给一个人加？
		 */
        
        // 隔代用户
        User gduser = getNodeListForGD(currentUserJsrId);
        
        // TODO 隔代奖金比例
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
		
        
        
		// TODO ****************************处理代理奖金****************************
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
        
        
        
        // TODO ****************************给所有上级重新计算代理级别（非代理可能升县代、县代可能市代、市代可能升省代）****************************
        // TODO 自动根据业绩升级还是人为设置？
        for (Node node : parentNodeList) {
            
            // 投资金额？、县代x个？、客户x个，是指推荐还是接点？
            
            
            
        }
	}
	
	private void getChildsUserIdList(Node node, List<Integer> result){
	    
	    if (CollectionUtils.isNotEmpty(result)) {
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
		
	    // 取得介绍人的介绍人用户信息对象
		return userMapper.selectByPrimaryKey(Integer.parseInt(users.get(0).getJsrId()));
	}

	/**
	 * 代理节点（获取一条线上的所有上级）符合什么代理的要求就给什么代理对应的奖金
	 * @param dataList
	 * @param node
	 * @param level
	 * @return
	 */
	public List<Node> getNodeListForDL(List<Node> dataList, Node node, int level, List<Node> result) {

	    // TODO 
	    
		
		return null;
	}

}
