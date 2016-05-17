package com.lgb.wechat.function.weixin.article.service.impl;

import com.lgb.wechat.function.weixin.article.repository.WeixinArticleRepository;
import com.lgb.wechat.function.weixin.article.service.WeixinArticleService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeixinArticleServiceImpl implements WeixinArticleService {
    @Autowired
    private WeixinArticleRepository weixinArticleRepository;

    @Override
    public List<Document> firstThreeArticles(String collectionName) {
        return weixinArticleRepository.selectRecentThree(collectionName);
    }
}
