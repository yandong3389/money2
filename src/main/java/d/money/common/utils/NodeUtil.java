package d.money.common.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 获取子节点
 */
public class NodeUtil {

	private List<Integer> returnList = new ArrayList<Integer>();

	/**
	 * 根据父节点的ID获取所有子节点
	 * 
	 * @param list
	 *            分类表
	 * @param parentId
	 *            传入的父节点ID
	 * @return String
	 */
	public List<Integer> getChildNodes(List<Node> list, int parentId, int level) {
		if (list == null)
			return returnList;
		for (Iterator<Node> iterator = list.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			// 根据传入的某个父节点ID,遍历该父节点的所有子节点
			if (parentId == node.getId()) {
				recursionFn(list, node, level);
			}
			// 遍历所有的父节点下的所有子节点
		}
		return returnList;
	}

	private void recursionFn(List<Node> list, Node node, int level) {
		
		// 得到子节点列表
		List<Node> childList = getChildList(list, node);
		
		// 判断是否有子节点
		if (hasChild(list, node)) {
			if (node.getLevel() == level) {
				returnList.add(node.getId());
			}
			Iterator<Node> it = childList.iterator();
			while (it.hasNext()) {
				Node n = (Node) it.next();
				recursionFn(list, n, level);
			}
		} else {
			if (node.getLevel() == level) {
				returnList.add(node.getId());
			}
		}
	}

	/**
	 * 得到子节点列表
	 * @param list
	 * @param node
	 * @return
	 */
	private List<Node> getChildList(List<Node> list, Node node) {
		List<Node> nodeList = new ArrayList<Node>();
		Iterator<Node> it = list.iterator();
		while (it.hasNext()) {
			Node n = (Node) it.next();
			if (n.getParentId() == node.getId()) {
				nodeList.add(n);
			}
		}
		return nodeList;
	}

	/**
	 * 判断是否有子节点
	 * @param list
	 * @param node
	 * @return
	 */
	private boolean hasChild(List<Node> list, Node node) {
		return getChildList(list, node).size() > 0 ? true : false;
	}

	/**
	 * 根据ID取得节点
	 * @param dataList
	 * @param id
	 * @return
	 */
	public static Node getNodeById(List<Node> dataList, int id) {

		Node thisNode = null;

		for (Node node : dataList) {
			if (node.getId() == id) {
				thisNode = node;
				break;
			}
		}
		return thisNode;
	}
}