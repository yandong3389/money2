package d.money.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import d.money.mapper.base.AdminMapper;
import d.money.pojo.base.Admin;
import d.money.pojo.base.AdminExample;
import d.money.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(AdminServiceImpl.class);

	@Override
	public List<Admin> selectByExample(AdminExample example) {
		logger.debug("selectByExample....start");
		return adminMapper.selectByExample(example);
	}
}