package d.money.service;

import java.util.List;

import d.money.pojo.WeekEndView;
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
	
	/**
	 * 最后一期奖金结算数据条数
	 * @return
	 */
	public int getWeekEndsCount();
	
	/**
	 * 最后一期奖金结算数据
	 * @return
	 */
	public List<WeekEndView> getWeekEnds(int currentPage, int perPage);
	
	/**
	 * 更新结算状态（由未结算更新至已结算）
	 * @param pkId 结算数据主键
	 * @return
	 */
	public int updateWeekFlag(int pkId);
}
