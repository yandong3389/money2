package d.money.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import d.money.common.utils.CollectionUtils;
import d.money.common.utils.Node;
import d.money.common.utils.NodeUtil;
import d.money.mapper.NodeExtMapper;
import d.money.mapper.base.MoneyHistoryMapper;
import d.money.mapper.base.NodeMapper;
import d.money.pojo.base.MoneyHistory;
import d.money.service.MoneyCalculateService;

@Service
public class MoneyCalculateServiceImpl implements MoneyCalculateService {
	
	@Autowired
	NodeExtMapper nodeExtMapper;
	@Autowired
	NodeMapper nodeMapper;
	@Autowired
	MoneyHistoryMapper moneyHistoryMapper;

	/**
	 * 更新奖金数据,记录奖金获取历史
	 * @param nodeId 本次追加节点ID
	 */
	public void updateMoney (int nodeId) {
		
		// 取得所有节点数据
		List<Node> allNodeList = nodeExtMapper.selectByExample(null);
		
		NodeUtil.convertChild(allNodeList);
		NodeUtil.convertParent(allNodeList);
		
		// 推荐人
		int node30Id = NodeUtil.getNodeById(allNodeList, nodeId).getParentId();
		
		// 直系人
		Node node20 = this.get20Node(allNodeList, nodeId);

		// 旁系人
		List<Node> node5List = this.get5NodeList(node20);
		
		// 插入推荐奖金数据
		MoneyHistory history30 = new MoneyHistory();
		history30.setId(node30Id);
		// 1:推荐、2:直系、3:旁系
		history30.setType(1);
		history30.setCreateDate(new Date());

		// 如果有直系节点
		if (node20 != null) {
			
			// 插入直系奖金数据
			MoneyHistory history20 = new MoneyHistory();
			history20.setId(node20.getId());
			// 1:推荐、2:直系、3:旁系
			history20.setType(2);
			history20.setCreateDate(new Date());
			moneyHistoryMapper.insert(history20);
		}
		
		// 有旁系节点
		if (CollectionUtils.isNotEmpty(node5List)) {
			
			// 循环插入旁系奖金数据
			for (Node node : node5List) {
				
				MoneyHistory history5 = new MoneyHistory();
				history5.setId(node.getId());
				// 1:推荐、2:直系、3:旁系
				history5.setType(3);
				history5.setCreateDate(new Date());
				moneyHistoryMapper.insert(history5);
			}
		}
	}
	
	
	
	
	
	
	
	/**
	 * 获取旁系节点集合
	 * @param node
	 * @return
	 */
	public List<Node> get5NodeList(Node node) {

		List<Node> nodes = new ArrayList<Node>();

		while (node.getParentId() != 0) {
			nodes.add(node.getParentNode());
			node = node.getParentNode();
		}

		return nodes;
	}

	/**
	 * 获取直系节点
	 * @param dataList
	 * @param id 本次追加节点ID
	 * @return
	 */
	public Node get20Node(List<Node> dataList, int id) {

		Node thisNode = NodeUtil.getNodeById(dataList, id);

		return get20Node(dataList, thisNode, thisNode.getLevel());
	}

	/**
	 * 递归计算符合配对节点
	 * @param dataList
	 * @param node
	 * @param level
	 * @return
	 */
	private Node get20Node(List<Node> dataList, Node node, int level) {

		Node parentNode = node.getParentNode();

		// 无节点符合要求
		if (parentNode == null || node.getParentId() == 0) {
			return null;
		}

		List<Node> nodeChildren = parentNode.getChildren();

		if (nodeChildren.size() == 2) {

			int childNodesCount0 = new NodeUtil().getChildNodes(dataList,
					nodeChildren.get(0).getId(), level).size();
			int childNodesCount1 = new NodeUtil().getChildNodes(dataList,
					nodeChildren.get(1).getId(), level).size();

			if ((nodeChildren.get(0).getId() == node.getId()
					&& childNodesCount0 <= childNodesCount1 && childNodesCount1 > 0)
					|| (nodeChildren.get(1).getId() == node.getId()
							&& childNodesCount1 <= childNodesCount0 && childNodesCount0 > 0)) {
				return node.getParentNode();
			} else {
				return get20Node(dataList, node.getParentNode(), level);
			}

		} else if (nodeChildren.size() == 1) {
			return get20Node(dataList, node.getParentNode(), level);
		}
		return null;
	}

}
