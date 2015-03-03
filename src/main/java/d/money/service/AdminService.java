package d.money.service;

import java.util.List;

import d.money.pojo.base.Admin;
import d.money.pojo.base.AdminExample;


public interface AdminService {
    
    public List<Admin> selectByExample(AdminExample example);
    
}