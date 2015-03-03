package d.money.mapper.base;

import d.money.pojo.base.Args;
import d.money.pojo.base.ArgsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArgsMapper {
    int countByExample(ArgsExample example);

    int deleteByExample(ArgsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Args record);

    int insertSelective(Args record);

    List<Args> selectByExample(ArgsExample example);

    Args selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Args record, @Param("example") ArgsExample example);

    int updateByExample(@Param("record") Args record, @Param("example") ArgsExample example);

    int updateByPrimaryKeySelective(Args record);

    int updateByPrimaryKey(Args record);
}