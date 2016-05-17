package com.lgb.wechat.function.weixin.article.repository;

import com.github.sd4324530.fastweixin.message.Article;
import org.bson.Document;

import java.util.List;

public interface WeixinArticleRepository {
    List<Document> selectRecentThree(String collectionName);
}
