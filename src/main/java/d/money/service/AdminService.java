package d.money.service;

import java.util.List;

import d.money.pojo.base.Admin;
import d.money.pojo.base.AdminExample;
import d.money.pojo.base.Args;
import d.money.pojo.base.ArgsExample;

public interface AdminService {

	public List<Admin> selectByExample(AdminExample example);

	public List<Args> selectByExmple(ArgsExample example);
	
	public int updateByPrimaryKey(Args args);

}