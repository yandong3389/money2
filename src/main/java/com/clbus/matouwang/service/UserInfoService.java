package com.clbus.matouwang.service;

import java.util.List;

import com.clbus.matouwang.pojo.base.Criteria;
import com.clbus.matouwang.pojo.base.UserInfo;

public interface UserInfoService {
    int countByExample(Criteria example);

    UserInfo selectByPrimaryKey(Integer id);

    List<UserInfo> selectByExample(Criteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    int deleteByExample(Criteria example);

    int updateByExampleSelective(UserInfo record, Criteria example);

    int updateByExample(UserInfo record, Criteria example);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);
}