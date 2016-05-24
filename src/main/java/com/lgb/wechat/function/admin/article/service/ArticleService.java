package com.lgb.wechat.function.admin.article.service;

import com.lgb.wechat.function.admin.article.Article;
import org.bson.Document;

import java.util.List;

public interface ArticleService {
    void add(Article article);
    List<Document> list(String articleType);
    Document view(String artilceType, String id);
    boolean edit(Article article);
    boolean delete(String articleType, String id);
    Document getArticleImage(String articleType, String id);
    boolean updateImage(Article article);
}
