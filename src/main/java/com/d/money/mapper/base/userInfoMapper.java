package com.d.money.mapper.base;

import com.d.money.pojo.base.userInfo;
import com.d.money.pojo.base.userInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userInfoMapper {
    int countByExample(userInfoExample example);

    int deleteByExample(userInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(userInfo record);

    int insertSelective(userInfo record);

    List<userInfo> selectByExample(userInfoExample example);

    userInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") userInfo record, @Param("example") userInfoExample example);

    int updateByExample(@Param("record") userInfo record, @Param("example") userInfoExample example);

    int updateByPrimaryKeySelective(userInfo record);

    int updateByPrimaryKey(userInfo record);
}