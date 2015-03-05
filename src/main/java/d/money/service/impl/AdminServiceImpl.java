package d.money.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import d.money.mapper.base.AdminMapper;
import d.money.mapper.base.ArgsMapper;
import d.money.pojo.base.Admin;
import d.money.pojo.base.AdminExample;
import d.money.pojo.base.Args;
import d.money.pojo.base.ArgsExample;
import d.money.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private ArgsMapper argsMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(AdminServiceImpl.class);

	@Override
	public List<Admin> selectByExample(AdminExample example) {
		logger.debug("selectByExample....start...login");
		return adminMapper.selectByExample(example);
	}

	@Override
	public List<Args> selectByExmple(ArgsExample example) {
		logger.debug("selectByExample....start...args");
		return argsMapper.selectByExample(example);
	}

	@Override
	public int updateByPrimaryKey(Args args) {
		logger.debug("updateByPrimaryKey....start...args");
		return argsMapper.updateByPrimaryKey(args);
	}
}