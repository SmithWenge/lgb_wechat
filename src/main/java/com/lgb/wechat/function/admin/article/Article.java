package com.lgb.wechat.function.admin.article;

public class Article {
    private String id;
    private String articleContent;
    private String articleType;
    private String articleAuthor;
    private String articleTitle;
    private String pictureUrl;
    private String articleUrl;

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleContent() {

        return articleContent;
    }

    public String getArticleType() {
        return articleType;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getId() {
        return id;
    }
}
