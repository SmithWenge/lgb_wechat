package com.lgb.wechat.function.admin.article.push.repository;

import com.lgb.wechat.arc.util.constants.Constants;
import com.lgb.wechat.arc.util.date.DateUtils;
import com.lgb.wechat.function.admin.article.Article;
import com.lgb.wechat.function.support.mongodb.MongoTemplate;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminArticlePushRepository implements AdminArticlePushRepositoryI {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Document> select4List() {
        return mongoTemplate.selectPushArticles();
    }

    /**
     * 添加推送文章
     *
     * @param article
     */
    @Override
    public void insert(Article article) {
        Document document = new Document("articleTitle", article.getArticleTitle())
                .append("articleAuthor", article.getArticleAuthor())
                .append("articleContent", article.getArticleContent())
                .append("articleTime", DateUtils.nowYMD())
                .append("articleDelete", Constants.DEFAULT_RECORD_NOT_DELETE)
                .append("articleType", Constants.PUSH_ARTICLE_TYPE)
                .append("_id", new ObjectId(article.getId()))
                .append("pictureUrl", article.getPictureUrl())
                .append("articleUrl", article.getArticleUrl())
                .append("articleDescription", article.getArticleDescription())
                .append("articleLocalPath", article.getArticleLocalPath());

        mongoTemplate.insertOne(Constants.PUSH_ARTICLE_TYPE, document);
    }

    /**
     * 查看某个推送文章
     *
     * @param pushArticleType
     * @param id
     * @return
     */
    @Override
    public Document select(String pushArticleType, String id) {
        Document document = new Document("_id", new ObjectId(id))
                .append("articleDelete", Constants.DEFAULT_RECORD_NOT_DELETE);

        List<Document> documents = mongoTemplate.find(pushArticleType, document);

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
                .append("articleType", Constants.PUSH_ARTICLE_TYPE)
                .append("articleDescription", article.getArticleDescription()));

        return mongoTemplate.updateOne(collectionName, condition, document) == 1;
    }
}
