package com.clbus.matouwang.dao.base;

import com.clbus.matouwang.pojo.base.Criteria;
import com.clbus.matouwang.pojo.base.TArticle;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TArticleMapper {
    /**
     * 根据条件查询记录总数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(TArticle record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(TArticle record);

    /**
     * 根据条件查询记录集
     */
    List<TArticle> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    TArticle selectByPrimaryKey(String id);

    /**
     * 根据条件更新属性不为空的记录
     */
    int updateByExampleSelective(@Param("record") TArticle record, @Param("example") Criteria example);

    /**
     * 根据条件更新记录
     */
    int updateByExample(@Param("record") TArticle record, @Param("example") Criteria example);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(TArticle record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(TArticle record);
}