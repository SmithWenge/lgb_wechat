package com.lgb.wechat.function.admin.article.push.repository;

import com.lgb.wechat.function.admin.article.Article;
import org.bson.Document;

import java.util.List;

public interface AdminArticlePushRepositoryI {
    List<Document> select4List();
    void insert(Article article);
    Document select(String pushArticleType, String id);
    boolean update(Article article);
}
