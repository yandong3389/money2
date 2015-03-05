package d.money.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import d.money.common.utils.NodeUtil;
import d.money.common.utils.PageUtil;
import d.money.mapper.NodeExtMapper;
import d.money.mapper.base.MoneyHistoryMapper;
import d.money.mapper.base.NodeMapper;
import d.money.mapper.base.UserMapper;
import d.money.pojo.base.Node;
import d.money.pojo.base.NodeExample;
import d.money.pojo.base.User;
import d.money.pojo.base.UserExample;
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
	
	/**
	 * 取得指定用户的所有子节点
	 */
	public List<d.money.common.utils.Node> getDefaultTree(int userId) {
		
		// 取得所有节点数据
		List<d.money.common.utils.Node> allNodeList = nodeExtMapper.selectByExample(null);
		
		List<Integer> nodeIdList = new NodeUtil().getChildNodes(allNodeList, userId, -1);
		
		
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
	public List<Node> getNodeDetail(int id, int currentPage, int perPage){
		
		NodeExample example = new NodeExample();
		example.setMysqlLength(perPage);
		example.setMysqlOffset(PageUtil.getStartRecord(currentPage, perPage));
		example.createCriteria().andIdEqualTo(id);
		example.setOrderByClause("create_date desc");
		
		List<Node> nodes = nodeMapper.selectByExample(example);
		
		return nodes;
	}
	
	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public Map<String, Integer> getConfig(){
		return null;
	}
	
}
