package d.money.mapper.base;

import d.money.pojo.base.UserProxyApplicationInfo;
import d.money.pojo.base.UserProxyApplicationInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserProxyApplicationInfoMapper {
    int countByExample(UserProxyApplicationInfoExample example);

    int deleteByExample(UserProxyApplicationInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserProxyApplicationInfo record);

    int insertSelective(UserProxyApplicationInfo record);

    List<UserProxyApplicationInfo> selectByExample(UserProxyApplicationInfoExample example);

    UserProxyApplicationInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserProxyApplicationInfo record, @Param("example") UserProxyApplicationInfoExample example);

    int updateByExample(@Param("record") UserProxyApplicationInfo record, @Param("example") UserProxyApplicationInfoExample example);

    int updateByPrimaryKeySelective(UserProxyApplicationInfo record);

    int updateByPrimaryKey(UserProxyApplicationInfo record);
}