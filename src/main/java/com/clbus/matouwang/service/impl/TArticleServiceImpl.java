package com.clbus.matouwang.service.impl;

import com.clbus.matouwang.dao.base.TArticleMapper;
import com.clbus.matouwang.pojo.base.Criteria;
import com.clbus.matouwang.pojo.base.TArticle;
import com.clbus.matouwang.service.TArticleService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TArticleServiceImpl implements TArticleService {
    @Autowired
    private TArticleMapper tArticleMapper;

    private static final Logger logger = LoggerFactory.getLogger(TArticleServiceImpl.class);

    public int countByExample(Criteria example) {
        int count = this.tArticleMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public TArticle selectByPrimaryKey(String id) {
        return this.tArticleMapper.selectByPrimaryKey(id);
    }

    public List<TArticle> selectByExample(Criteria example) {
        return this.tArticleMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(String id) {
        return this.tArticleMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(TArticle record) {
        return this.tArticleMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TArticle record) {
        return this.tArticleMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(Criteria example) {
        return this.tArticleMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(TArticle record, Criteria example) {
        return this.tArticleMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(TArticle record, Criteria example) {
        return this.tArticleMapper.updateByExample(record, example);
    }

    public int insert(TArticle record) {
        return this.tArticleMapper.insert(record);
    }

    public int insertSelective(TArticle record) {
        return this.tArticleMapper.insertSelective(record);
    }
}