package d.money.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;

import d.money.common.utils.CollectionUtils;
import d.money.common.utils.Node;
import d.money.common.utils.NodeUtil;
import d.money.mapper.base.UserInfoMapper;
import d.money.pojo.base.UserInfo;
import d.money.pojo.base.UserInfoExample;
import d.money.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(UserInfoServiceImpl.class);

	public List<UserInfo> selectByExample(UserInfoExample example) {
		logger.debug("selectByExample....start");
		;
		return userInfoMapper.selectByExample(example);
	}

	public int insertUserInfo(String userName, String userPass) {

		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(userName);
		userInfo.setUserPass(userPass);
		userInfo.setId(userInfoMapper.countByExample(null) + 1);
		userInfo.setAddDate(new Date());

		return userInfoMapper.insert(userInfo);
	}
	
	public void convertChild (List<Node> dataList) {
		
		List<Node> nodeList = new ArrayList<Node>();  
		for(Node node1 : dataList){
			boolean markChild = false;
			for(Node node2 : dataList){
				if(node1.getParentId()!=0 && node1.getParentId() == node2.getId()){  
					markChild = true;
					if(node2.getChildren() == null)
						node2.setChildren(new ArrayList<Node>());  
					node2.getChildren().add(node1);
					break;
				}  
			}  
			if(!markChild){  
				nodeList.add(node1);   
			}
		}
		
		//转为json格式        
		String json = JSONArray.toJSONString(nodeList).toString();  
		System.out.println("json:"+json);  
	}
	
    public void convertParent(List<Node> dataList) {
    	
    	for(Node node1 : dataList){  
    	    for(Node node2 : dataList){  
    	        if(node1.getParentId()!=0 && node1.getParentId() == node2.getId()){  
    	        	node1.setParentNode(node2);  
    	            break;  
    	        }
    	    }  
    	}
    	
    	//转为json格式        
    	String json = JSONArray.toJSONString(dataList).toString();  
    	System.out.println("json:"+json);  
    }
	
    public List<Node> y(Node node){
    	
    	return get5NodeList(node);
    }
    
    public List<Node> get5NodeList(Node node){
    	
    	List<Node> nodes = new ArrayList<Node>();
    	
    	while (node.getParentId() != 0) {
    		nodes.add(node.getParentNode());
    		node = node.getParentNode();
		}
    	
    	return nodes;
    }
    
	public Node x(List<Node> dataList, int id) {

		Node thisNode = NodeUtil.getNodeById(dataList, id);
		
		return get20Node(dataList, thisNode, thisNode.getLevel());
	}
	
	public Node get20Node(List<Node> dataList, Node node, int level){
		
		Node parentNode = node.getParentNode();
		
		// 无节点符合要求
		if (parentNode == null || node.getParentId() == 0) {
			return null;
		}
		
		List<Node> nodeChildren = parentNode.getChildren();
		
		if (nodeChildren.size() == 2) {
			
			int childNodesCount0 = new NodeUtil().getChildNodes(dataList, nodeChildren.get(0).getId(), level).size();
			int childNodesCount1 = new NodeUtil().getChildNodes(dataList, nodeChildren.get(1).getId(), level).size();
			
			if ((nodeChildren.get(0).getId() == node.getId() && childNodesCount0 <= childNodesCount1 && childNodesCount1 > 0)
					|| (nodeChildren.get(1).getId() == node.getId() && childNodesCount1 <= childNodesCount0 && childNodesCount0 > 0)) {
				return node.getParentNode();
			} else {
				return get20Node(dataList, node.getParentNode(), level);
			}
			
		} else if (nodeChildren.size() == 1) {
			return get20Node(dataList, node.getParentNode(), level);
		}
		return null;
        // 
//        new NodeUtil().getChildNodes(dataList, 2);
//        new NodeUtil().getChildNodes(dataList, 2);
	}
	
}