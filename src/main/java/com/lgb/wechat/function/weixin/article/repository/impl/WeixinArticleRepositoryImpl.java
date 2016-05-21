package com.lgb.wechat.function.weixin.article.repository.impl;

import com.lgb.wechat.function.support.mongodb.MongoTemplate;
import com.lgb.wechat.function.weixin.article.repository.WeixinArticleRepository;
import org.bson.Document;

import java.util.List;

public class WeixinArticleRepositoryImpl implements WeixinArticleRepository {
    private MongoTemplate mongodbTemplate;

    public WeixinArticleRepositoryImpl() {
        mongodbTemplate = new MongoTemplate();
    }

    @Override
    public List<Document> selectRecentThree(String collectionName) {
        Document sortDocument = new Document("articleTime", -1);
        List<Document> documents = mongodbTemplate.findSort(collectionName, new Document(), sortDocument);

        return documents;
    }
}
