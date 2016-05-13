package com.lgb.wechat.function.admin.article.controller;

import com.lgb.wechat.function.admin.article.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/article")
public class ArticleController {
    @RequestMapping("/route/add")
    public String route2Add() {
        return "admin/article/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addArticle(Article article) {
        System.out.println(article.getContent());

        return "admin/article/add";
    }
}
