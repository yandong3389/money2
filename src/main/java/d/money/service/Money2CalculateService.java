package d.money.service;

import java.util.ArrayList;
import java.util.List;

import d.money.common.utils.Node;
import d.money.pojo.base.NodeExample;

public interface Money2CalculateService {
	
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
	 * 级差节点（获取一条线上的所有上级）
	 * @param node
	 * @return
	 */
	public List<Node> getNodeListForJX(Node node);

	/**
	 * 隔代节点（上级的上级节点）
	 * @param dataList
	 * @param id 本次追加节点ID
	 * @return
	 */
	public List<Node> getNodeForGD(List<Node> dataList, int id);

	/**
	 * TODO 代理节点（获取一条线上的所有上级?）
	 * @param dataList
	 * @param node
	 * @param level
	 * @return
	 */
	public List<Node> getNodeForDL(List<Node> dataList, Node node, int level, List<Node> result);
}
