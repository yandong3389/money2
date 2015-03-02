package d.money.mapper;

import java.util.List;

import d.money.common.utils.Node;
import d.money.pojo.base.NodeExample;

public interface NodeExtMapper {
    List<Node> selectByExample(NodeExample example);
}