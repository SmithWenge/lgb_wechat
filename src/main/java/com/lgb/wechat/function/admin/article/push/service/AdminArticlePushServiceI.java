package com.lgb.wechat.function.admin.article.push.service;

import com.lgb.wechat.function.admin.article.Article;
import org.bson.Document;

import java.util.List;

public interface AdminArticlePushServiceI {
    List<Document> list();
    void add(Article article);
    Document view(String pushArticleType, String id);
    boolean edit(Article article);
}
