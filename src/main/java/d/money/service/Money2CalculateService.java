package d.money.service;

import java.util.List;
import java.util.Map;

import d.money.common.utils.Node;
import d.money.pojo.base.NodeExample;
import d.money.pojo.base.User;


public interface Money2CalculateService {

    public int countByExample(NodeExample example);
    
    /**
     * 保存用户申请升级代理数据
     * @return
     */
    public String saveUpLevelProxyInfo (int userId);
    
    /**
     * 计算某人符合几级代理的升级条件
     * @param userId
     * @return int 如果返回0，表示不满足升级条件，非0，表示满足升到x级的代理条件
     */
    public Map<String, Object> selectProxyByUserId(int userId);
    
    /**
     * 1、插入node数据
     * 2、标记为用户为审核通过
     * 3、计算奖金
     * @param userId 当前新增加的用户ID
     * @param parentId 当前新增加的用户的接点人ID
     */
    public void saveApproveSuccess(int userId, int parentId);
    
    /**
     * 审核未通过，标记用户为审核未通过状态
     * @param userId
     * @param parentId
     */
    public void saveApproveFail(int userId);
    
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
