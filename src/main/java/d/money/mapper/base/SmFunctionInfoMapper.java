package d.money.mapper.base;

import d.money.pojo.base.SmFunctionInfo;
import d.money.pojo.base.SmFunctionInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmFunctionInfoMapper {
    int countByExample(SmFunctionInfoExample example);

    int deleteByExample(SmFunctionInfoExample example);

    int deleteByPrimaryKey(String functionId);

    int insert(SmFunctionInfo record);

    int insertSelective(SmFunctionInfo record);

    List<SmFunctionInfo> selectByExample(SmFunctionInfoExample example);

    SmFunctionInfo selectByPrimaryKey(String functionId);

    int updateByExampleSelective(@Param("record") SmFunctionInfo record, @Param("example") SmFunctionInfoExample example);

    int updateByExample(@Param("record") SmFunctionInfo record, @Param("example") SmFunctionInfoExample example);

    int updateByPrimaryKeySelective(SmFunctionInfo record);

    int updateByPrimaryKey(SmFunctionInfo record);
}