package com.lgb.wechat.function.admin.article.repository.impl;

import com.lgb.wechat.arc.util.constants.ConstantsCollection;
import com.lgb.wechat.arc.util.date.DateUtils;
import com.lgb.wechat.function.admin.article.Article;
import com.lgb.wechat.function.admin.article.repository.ArticleRepository;
import com.lgb.wechat.function.support.mongodb.MongoTemplate;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
    @Autowired
    private MongoTemplate mongodbTemplate;

    @Override
    public void insert(Article article) {
        Document document = new Document("articleTitle", article.getArticleTitle())
                .append("articleAuthor", article.getArticleAuthor())
                .append("articleContent", article.getArticleContent())
                .append("articleTime", DateUtils.nowYMD())
                .append("articleType", article.getArticleType())
                .append("articleDelete", ConstantsCollection.DEFAULT_RECORD_NOT_DELETE)
                .append("_id", new ObjectId(article.getId()))
                .append("pictureUrl", article.getPictureUrl())
                .append("articleUrl", article.getArticleUrl());

        mongodbTemplate.insertOne(article.getArticleType(), document);
    }

    @Override
    public List<Document> select(String articleType) {

        return mongodbTemplate.find(articleType);
    }

    @Override
    public Document select(String artilceType, String id) {
        Document document = new Document("_id", new ObjectId(id))
                .append("articleDelete", ConstantsCollection.DEFAULT_RECORD_NOT_DELETE);

        List<Document> documents = mongodbTemplate.find(artilceType, document);

        if (documents.size() == 1) {
            return documents.get(0);
        }

        return null;
    }

    @Override
    public boolean update(Article article) {
        String collectionName = article.getArticleType();
        Document condition = new Document("_id", new ObjectId(article.getId()));
        Document document = new Document("$set", new Document("articleTitle", article.getArticleTitle())
                .append("articleAuthor", article.getArticleAuthor())
                .append("articleContent", article.getArticleContent())
                .append("articleTime", DateUtils.nowYMD())
                .append("articleType", article.getArticleType()));

        return mongodbTemplate.updateOne(collectionName, condition, document) == 1;
    }

    @Override
    public boolean update(String articleType, String id) {
        Document condition = new Document("_id", new ObjectId(id));
        Document document = new Document("$set", new Document("articleDelete", 1));

        return mongodbTemplate.updateOne(articleType, condition, document) == 1;
    }
}
