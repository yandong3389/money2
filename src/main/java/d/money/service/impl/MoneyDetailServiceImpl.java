package d.money.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import d.money.common.utils.PageUtil;
import d.money.mapper.NodeExtMapper;
import d.money.mapper.base.MoneyHistoryMapper;
import d.money.mapper.base.NodeMapper;
import d.money.pojo.base.Node;
import d.money.pojo.base.NodeExample;
import d.money.service.MoneyDetailService;

@Service
public class MoneyDetailServiceImpl implements MoneyDetailService {
	
	@Autowired
	NodeExtMapper nodeExtMapper;
	@Autowired
	NodeMapper nodeMapper;
	@Autowired
	MoneyHistoryMapper moneyHistoryMapper;

	/**
	 * 取得用户奖金明细
	 * @param id
	 * @param currentPage
	 * @param perPage
	 * @return
	 */
	public List<Node> getNodeDetail(int id, int currentPage, int perPage){
		
		NodeExample example = new NodeExample();
		example.setMysqlLength(perPage);
		example.setMysqlOffset(PageUtil.getStartRecord(currentPage, perPage));
		example.createCriteria().andIdEqualTo(id);
		example.setOrderByClause("create_date desc");
		
		List<Node> nodes = nodeMapper.selectByExample(example);
		
		return nodes;
	}

}
