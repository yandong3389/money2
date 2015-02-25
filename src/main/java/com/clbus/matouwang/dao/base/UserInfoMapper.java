package com.clbus.matouwang.dao.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clbus.matouwang.pojo.base.Criteria;
import com.clbus.matouwang.pojo.base.UserInfo;

public interface UserInfoMapper {
    /**
     * 根据条件查询记录总数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(UserInfo record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(UserInfo record);

    /**
     * 根据条件查询记录集
     */
    List<UserInfo> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    UserInfo selectByPrimaryKey(Integer id);

    /**
     * 根据条件更新属性不为空的记录
     */
    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") Criteria example);

    /**
     * 根据条件更新记录
     */
    int updateByExample(@Param("record") UserInfo record, @Param("example") Criteria example);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(UserInfo record);
}