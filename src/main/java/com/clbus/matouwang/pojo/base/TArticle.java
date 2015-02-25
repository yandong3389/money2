package com.clbus.matouwang.pojo.base;

import java.io.Serializable;
import java.util.Date;

public class TArticle implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String articleTitle;

    private String articleTag;

    private String articleUrl;

    private Date dateAdd;

    private String articleYinyong;

    private String sortId;

    private String articleProfile;

    private String articleContent;

    private String articleAddUserName;

    private String articlePic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleTag() {
        return articleTag;
    }

    public void setArticleTag(String articleTag) {
        this.articleTag = articleTag;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getArticleYinyong() {
        return articleYinyong;
    }

    public void setArticleYinyong(String articleYinyong) {
        this.articleYinyong = articleYinyong;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getArticleProfile() {
        return articleProfile;
    }

    public void setArticleProfile(String articleProfile) {
        this.articleProfile = articleProfile;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleAddUserName() {
        return articleAddUserName;
    }

    public void setArticleAddUserName(String articleAddUserName) {
        this.articleAddUserName = articleAddUserName;
    }

    public String getArticlePic() {
        return articlePic;
    }

    public void setArticlePic(String articlePic) {
        this.articlePic = articlePic;
    }
}