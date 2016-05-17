package com.lgb.wechat.function.weixin.article.repository.impl;

import com.lgb.wechat.function.support.mongodb.MongoTemplate;
import com.lgb.wechat.function.weixin.article.repository.WeixinArticleRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WeixinArticleRepositoryImpl implements WeixinArticleRepository {
    @Autowired
    private MongoTemplate mongodbTemplate;

    @Override
    public List<Document> selectRecentThree(String collectionName) {
        Document sortDocument = new Document("articleTime", 1);
        List<Document> documents = mongodbTemplate.findSort(collectionName, new Document(), sortDocument);

        return documents;
    }
}
