package d.money.service;

import java.util.List;

import d.money.common.utils.Node;

public interface MoneyCalculateService {
	
	/**
	 * 更新奖金数据,记录奖金获取历史
	 * @param nodeId 本次追加节点ID
	 */
	public void updateMoney (int nodeId);
	
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
	public Node get20Node(List<Node> dataList, int id);

}
