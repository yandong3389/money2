package d.money.mapper;

import java.util.List;

import d.money.common.utils.Node;
import d.money.pojo.base.NodeExample;
import d.money.pojo.base.User;

public interface NodeExtMapper {
	List<Node> selectByExample(NodeExample example);

	List<User> selectUserByzctime();
}