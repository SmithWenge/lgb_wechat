package com.lgb.wechat.function.admin.article.repository;

import com.lgb.wechat.function.admin.article.Article;
import org.bson.Document;

import java.util.List;

public interface ArticleRepository {
    void insert(Article article);
    List<Document> select(String articleType);
    Document select(String artilceType, String id);
    boolean update(Article article);
    boolean update(String articleType, String id);
    Document selectImage(String articleType, String id);
    boolean updateImage(Article article);
}
