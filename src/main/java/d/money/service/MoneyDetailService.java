package d.money.service;

import java.util.List;
import java.util.Map;

import d.money.pojo.base.Node;
import d.money.pojo.base.User;

public interface MoneyDetailService {

	public List<d.money.common.utils.Node> getDefaultTree(int userId);
	
	public List<Node> getNodeDetail(int id, int currentPage, int perPage);

	public User getUserById(int id);

	public Map<String, Integer> getConfig();
}
