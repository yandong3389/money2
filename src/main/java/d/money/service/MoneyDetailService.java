package d.money.service;

import java.util.List;

import d.money.pojo.base.Args;
import d.money.pojo.base.MoneyHistory;
import d.money.pojo.base.User;

public interface MoneyDetailService {

	public List<d.money.common.utils.Node> getDefaultTree(int userId);
	
	public List<MoneyHistory> getHistoryDetail(int id, int currentPage, int perPage);

	public int getHistoryDetailCount(int id);
	
	public User getUserById(int id);

	public Args getConfig();

	public List<Integer> getData(int id);
}
