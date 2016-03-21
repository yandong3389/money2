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
import d.money.pojo.base.NodeExample;
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
	 * @param nodeId 本次追加节点ID(当前新增加的用户ID)
	 * @param 介绍人ID(30%获取人)
	 */
	public void updateMoney (int nodeId, int jsrId) {
		
		// TODO 处理级差
		/*
		 * 获取一条线上的所有上级
		 * 从最近的上级开始发放级差奖金，
		 * 先计算上级所在级别（三个条件），该级别对应的百分比，得出奖金金额，
		 * 再向上一级时，同样先计算上级所在级别（三个条件），该级别对应的百分比，得出奖金金额，再减掉之前被拿出的级差资金
		 * A->B->C->D（级差，两级奖金比例之差）
		 * D注册审核通过
		 * A=A%-B%
		 * B=B%-C%
		 * C=C%
		 */
		
		
		// TODO 处理隔代
		/*
		 * 获取当前注册用户上级的上级，增加隔代奖金，
		 * 只给一个人加？
		 */
		
		
		// TODO 处理总代
		/*
		 *  A->B->C->D 比如这样的关系，D注册进来，代理奖金都给谁加？
		 *  
		 */
		
	}
	
	/**
	 * 级差节点（获取一条线上的所有上级）
	 * @param node
	 * @return
	 */
	public List<Node> getNodeListForJX(Node node) {

		List<Node> nodes = new ArrayList<Node>();

		if (node != null) {
			
			while (node.getParentId() != 0) {
				nodes.add(node.getParentNode());
				node = node.getParentNode();
			}
		}

		return nodes;
	}

	/**
	 * 隔代节点（上级的上级节点）
	 * @param dataList
	 * @param id 本次追加节点ID
	 * @return
	 */
	public List<Node> getNodeForGD(List<Node> dataList, int id) {


		List<Node> result = new ArrayList<Node>();
		
		
		return result;
	}

	/**
	 * TODO 代理节点（获取一条线上的所有上级?）
	 * @param dataList
	 * @param node
	 * @param level
	 * @return
	 */
	public List<Node> getNodeForDL(List<Node> dataList, Node node, int level, List<Node> result) {

		
		return null;
	}

}
