package d.money.service;

import java.util.List;

import d.money.pojo.base.User;
import d.money.pojo.base.UserExample;

public interface UserService {
	public int countByExample(UserExample example);
	public User selectByPrimaryKey(int userId);
	public int updateByExampleSelective(User user, UserExample example);
	public List<User> selectByExample(UserExample example);

	public int insert(User record);
	
	public int deleteByPrimaryKey(Integer id);
	
	int updateByPrimaryKeySelective(User record);
}