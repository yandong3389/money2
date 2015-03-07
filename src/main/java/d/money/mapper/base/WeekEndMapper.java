package d.money.mapper.base;

import d.money.pojo.base.WeekEnd;
import d.money.pojo.base.WeekEndExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeekEndMapper {
    int countByExample(WeekEndExample example);

    int deleteByExample(WeekEndExample example);

    int deleteByPrimaryKey(Integer pkId);

    int insert(WeekEnd record);

    int insertSelective(WeekEnd record);

    List<WeekEnd> selectByExample(WeekEndExample example);

    WeekEnd selectByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") WeekEnd record, @Param("example") WeekEndExample example);

    int updateByExample(@Param("record") WeekEnd record, @Param("example") WeekEndExample example);

    int updateByPrimaryKeySelective(WeekEnd record);

    int updateByPrimaryKey(WeekEnd record);
}