package com.clbus.matouwang.service;

import com.clbus.matouwang.pojo.base.Criteria;
import com.clbus.matouwang.pojo.base.TArticle;
import java.util.List;

public interface TArticleService {
    int countByExample(Criteria example);

    TArticle selectByPrimaryKey(String id);

    List<TArticle> selectByExample(Criteria example);

    int deleteByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TArticle record);

    int updateByPrimaryKey(TArticle record);

    int deleteByExample(Criteria example);

    int updateByExampleSelective(TArticle record, Criteria example);

    int updateByExample(TArticle record, Criteria example);

    int insert(TArticle record);

    int insertSelective(TArticle record);
}