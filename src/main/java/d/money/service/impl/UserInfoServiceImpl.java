package d.money.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import d.money.mapper.base.UserInfoMapper;
import d.money.pojo.base.UserInfo;
import d.money.pojo.base.UserInfoExample;
import d.money.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(UserInfoServiceImpl.class);

	public List<UserInfo> selectByExample(UserInfoExample example) {
		logger.debug("selectByExample....start");
		;
		return userInfoMapper.selectByExample(example);
	}

	public int insertUserInfo(String userName, String userPass) {

		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(userName);
		userInfo.setUserPass(userPass);
		userInfo.setId(userInfoMapper.countByExample(null) + 1);
		userInfo.setAddDate(new Date());

		return userInfoMapper.insert(userInfo);
	}
}