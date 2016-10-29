package com.lgb.wechat.function.admin.article.push.service;

import com.lgb.wechat.function.admin.article.Article;
import com.lgb.wechat.function.admin.article.push.repository.AdminArticlePushRepositoryI;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminArticlePushService implements AdminArticlePushServiceI {
    @Autowired
    private AdminArticlePushRepositoryI adminArticlePushRepository;

    @Override
    public List<Document> list() {
        return adminArticlePushRepository.select4List();
    }

    @Override
    public void add(Article article) {
        adminArticlePushRepository.insert(article);
    }

    @Override
    public Document view(String pushArticleType, String id) {
        return adminArticlePushRepository.select(pushArticleType, id);
    }

    @Override
    public boolean edit(Article article) {
        return adminArticlePushRepository.update(article);
    }

    @Override
    public boolean updateBePushed(String id) {
        return adminArticlePushRepository.update4Pushed(id);
    }
}
