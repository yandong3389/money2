//package com.d.money.service.impl;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.clbus.matouwang.dao.base.UserInfoMapper;
//import com.clbus.matouwang.pojo.base.Criteria;
//import com.clbus.matouwang.pojo.base.UserInfo;
//import com.clbus.matouwang.service.UserInfoService;
//
//@Service
//public class UserInfoServiceImpl implements UserInfoService {
//    @Autowired
//    private UserInfoMapper userInfoMapper;
//
//    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
//
//    public int countByExample(Criteria example) {
//        int count = this.userInfoMapper.countByExample(example);
//        logger.debug("count: {}", count);
//        return count;
//    }
//
//    public UserInfo selectByPrimaryKey(Integer id) {
//        return this.userInfoMapper.selectByPrimaryKey(id);
//    }
//
//    public List<UserInfo> selectByExample(Criteria example) {
//        return this.userInfoMapper.selectByExample(example);
//    }
//
//    public int deleteByPrimaryKey(Integer id) {
//        return this.userInfoMapper.deleteByPrimaryKey(id);
//    }
//
//    public int updateByPrimaryKeySelective(UserInfo record) {
//        return this.userInfoMapper.updateByPrimaryKeySelective(record);
//    }
//
//    public int updateByPrimaryKey(UserInfo record) {
//        return this.userInfoMapper.updateByPrimaryKey(record);
//    }
//
//    public int deleteByExample(Criteria example) {
//        return this.userInfoMapper.deleteByExample(example);
//    }
//
//    public int updateByExampleSelective(UserInfo record, Criteria example) {
//        return this.userInfoMapper.updateByExampleSelective(record, example);
//    }
//
//    public int updateByExample(UserInfo record, Criteria example) {
//        return this.userInfoMapper.updateByExample(record, example);
//    }
//
//    public int insert(UserInfo record) {
//        return this.userInfoMapper.insert(record);
//    }
//    
//    public int insertSelective(UserInfo record) {
//        return this.userInfoMapper.insertSelective(record);
//    }
//}