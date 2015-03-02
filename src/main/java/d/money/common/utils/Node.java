package d.money.common.utils;

import java.util.List;

public class Node {

	private int id;
	private int parentId;
	private int leftFlag; 
	private int level;
	private Node parentNode;
	private List<Node> children;
	
	public Node(int id, int parentId, int leftFlag, int level){
		this.id = id;
		this.parentId = parentId;
		this.leftFlag = leftFlag;
		this.level = level;
	}
	
	public Node getParentNode() {
		return parentNode;
	}
	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getLeftFlag() {
		return leftFlag;
	}
	public void setLeftFlag(int leftFlag) {
		this.leftFlag = leftFlag;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
}
