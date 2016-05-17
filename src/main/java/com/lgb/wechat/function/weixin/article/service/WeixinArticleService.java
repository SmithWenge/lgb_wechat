package com.lgb.wechat.function.weixin.article.service;

import org.bson.Document;

import java.util.List;

public interface WeixinArticleService {
    List<Document> firstThreeArticles(String collectionName);
}
