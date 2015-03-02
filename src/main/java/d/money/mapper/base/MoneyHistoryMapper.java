package d.money.mapper.base;

import d.money.pojo.base.MoneyHistory;
import d.money.pojo.base.MoneyHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoneyHistoryMapper {
    int countByExample(MoneyHistoryExample example);

    int deleteByExample(MoneyHistoryExample example);

    int deleteByPrimaryKey(Integer pkid);

    int insert(MoneyHistory record);

    int insertSelective(MoneyHistory record);

    List<MoneyHistory> selectByExample(MoneyHistoryExample example);

    MoneyHistory selectByPrimaryKey(Integer pkid);

    int updateByExampleSelective(@Param("record") MoneyHistory record, @Param("example") MoneyHistoryExample example);

    int updateByExample(@Param("record") MoneyHistory record, @Param("example") MoneyHistoryExample example);

    int updateByPrimaryKeySelective(MoneyHistory record);

    int updateByPrimaryKey(MoneyHistory record);
}