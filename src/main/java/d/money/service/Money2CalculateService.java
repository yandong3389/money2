package d.money.service;

import java.util.List;

import d.money.common.utils.Node;
import d.money.pojo.base.NodeExample;
import d.money.pojo.base.User;


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
     * @param currentNodeId 本次追加节点ID(当前新增加的用户ID)
     */
    public void updateMoney (int currentNodeId, int currentUserJsrId);
    
    /**
     * 级差节点（获取一条线上的所有上级）
     * @param node
     * @return
     */
    public List<Node> getNodeListForJX(List<Node> dataList, int id);
    
    /**
     * 隔代节点（上级的上级节点）
     * @param dataList
     * @param id 本次追加节点ID
     * @return
     */
    public User getNodeListForGD(int jsrId);

    /**
     * 代理节点（获取一条线上的所有上级）符合什么代理的要求就给什么代理对应的奖金
     * @param dataList
     * @param node
     * @param level
     * @return
     */
    public List<Node> getNodeListForDL(List<Node> dataList, Node node, int level, List<Node> result);





}
