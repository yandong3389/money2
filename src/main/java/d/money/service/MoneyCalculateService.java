package d.money.service;

import java.util.List;

import d.money.common.utils.Node;
import d.money.pojo.base.NodeExample;

public interface MoneyCalculateService {
	
	public int countByExample(NodeExample example);
	/**
	 * 插入node数据
	 * @param userId 当前新增加的用户ID
	 * @param parentId 当前新增加的用户的接点人ID
	 */
	public void insertNode(int userId, int parentId);
	
	/**
	 * 更新奖金数据,记录奖金获取历史
	 * @param nodeId 本次追加节点ID
	 * @param 介绍人ID(30%获取人)
	 */
	public void updateMoney (int nodeId, int jsrId);
	
	/**
	 * 获取旁系节点集合
	 * @param node
	 * @return
	 */
	public List<Node> get5NodeList(Node node);

	/**
	 * 获取直系节点
	 * @param dataList
	 * @param id 本次追加节点ID
	 * @return
	 */
	public List<Node> get20Node(List<Node> dataList, int id);

}
