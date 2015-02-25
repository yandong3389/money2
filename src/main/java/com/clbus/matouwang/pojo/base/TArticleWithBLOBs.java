package com.clbus.matouwang.pojo.base;

import java.io.Serializable;

public class TArticleWithBLOBs extends TArticle implements Serializable {
    private static final long serialVersionUID = 1L;

    private String articleProfile;

    private String articleContent;

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
}