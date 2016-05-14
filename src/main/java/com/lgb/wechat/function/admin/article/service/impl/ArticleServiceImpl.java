package com.lgb.wechat.function.admin.article.service.impl;

import com.lgb.wechat.function.admin.article.Article;
import com.lgb.wechat.function.admin.article.repository.ArticleRepository;
import com.lgb.wechat.function.admin.article.service.ArticleService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void add(Article article) {
        articleRepository.insert(article);
    }

    @Override
    public List<Document> list(String articleType) {
        return articleRepository.select(articleType);
    }

    @Override
    public Document view(String artilceType, String id) {
        return articleRepository.select(artilceType, id);
    }

    @Override
    public boolean edit(Article article) {
        return articleRepository.update(article);
    }

    @Override
    public boolean delete(String articleType, String id) {
        return articleRepository.update(articleType, id);
    }
}
