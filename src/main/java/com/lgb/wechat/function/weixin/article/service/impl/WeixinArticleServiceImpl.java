package com.lgb.wechat.function.weixin.article.service.impl;

import com.lgb.wechat.function.weixin.article.repository.WeixinArticleRepository;
import com.lgb.wechat.function.weixin.article.repository.impl.WeixinArticleRepositoryImpl;
import com.lgb.wechat.function.weixin.article.service.WeixinArticleService;
import org.bson.Document;

import java.util.List;

public class WeixinArticleServiceImpl implements WeixinArticleService {
    private WeixinArticleRepository weixinArticleRepository;

    public WeixinArticleServiceImpl() {
        weixinArticleRepository = new WeixinArticleRepositoryImpl();
    }

    @Override
    public List<Document> firstThreeArticles(String collectionName) {
        return weixinArticleRepository.selectRecentThree(collectionName);
    }
}
