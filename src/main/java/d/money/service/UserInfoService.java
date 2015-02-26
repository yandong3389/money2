package d.money.service;

import java.util.List;

import d.money.pojo.base.UserInfo;
import d.money.pojo.base.UserInfoExample;


public interface UserInfoService {
    
    public List<UserInfo> selectByExample(UserInfoExample example);
    
    public int insertUserInfo(String userName, String userPass);
    
}