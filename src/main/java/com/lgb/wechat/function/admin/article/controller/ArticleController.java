package com.lgb.wechat.function.admin.article.controller;

import com.lgb.wechat.arc.util.constants.ConstantsCollection;
import com.lgb.wechat.function.admin.article.Article;
import com.lgb.wechat.function.admin.article.service.ArticleService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/article")
public class ArticleController {
    private static final String REQUEST_SUFFIX_ACTION = ".action";
    private static final String ADMIN_ARTICLE_ROUTE_EDIT = "redirect:/admin/article/route/edit/";
    private static final String DEFAULT_ARTICLE_LIST_REQUEST_ACTION = "redirect:/admin/article/route/edit/" + ConstantsCollection.DEFAULT_ARTICLE_COLLECTION_NAME + REQUEST_SUFFIX_ACTION;
    private static final String REDIRECT_ADMIN_ARTICLE_LIST = "redirect:/admin/article/list/";

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/route/add")
    public String route2Add() {
        return "admin/article/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addArticle(Article article) {
        articleService.add(article);

        return DEFAULT_ARTICLE_LIST_REQUEST_ACTION;
    }

    @RequestMapping("/list/{articleType}")
    public ModelAndView listArticle(@PathVariable("articleType") String articleType) {
        return listArticles(articleType);
    }

    private ModelAndView listArticles(String articleType) {
        String type = articleType;
        if (null == type || type.length() == 0) {
            type = ConstantsCollection.DEFAULT_ARTICLE_COLLECTION_NAME;
        }

        List<Document> documents = articleService.list(type);

        ModelAndView mav = new ModelAndView("admin/article/list");
        mav.addObject("documents", documents);

        return mav;
    }

    @RequestMapping("/list")
    public ModelAndView listArticleByType(@RequestParam(required = false) String articleType) {
        return listArticles(articleType);
    }

    @RequestMapping("/view/{articleType}/{id}")
    public ModelAndView viewArticle(@PathVariable("articleType") String artilceType,
                                    @PathVariable("id") String id) {
        Document document = articleService.view(artilceType, id);

        ModelAndView mav = new ModelAndView("admin/article/view");
        mav.addObject("document", document);

        return mav;
    }

    @RequestMapping("/route/edit/{articleType}/{id}")
    public ModelAndView routeEdit(@PathVariable("articleType") String artilceType,
                                  @PathVariable("id") String id) {
        Document document = articleService.view(artilceType, id);

        ModelAndView mav = new ModelAndView("admin/article/edit");
        mav.addObject("document", document);

        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editArticle(Article article) {
        boolean updated = articleService.edit(article);

        if (updated) {
            return REDIRECT_ADMIN_ARTICLE_LIST + ConstantsCollection.DEFAULT_ARTICLE_COLLECTION_NAME + ".action";
        } else {
            return ADMIN_ARTICLE_ROUTE_EDIT + article.getArticleType() + "/" + article.getId() + REQUEST_SUFFIX_ACTION;
        }
    }

    @RequestMapping("/delete/{articleType}/{id}")
    public String deleteArticle(@PathVariable("articleType") String articleType,
                                @PathVariable("id") String id) {
        boolean deleted = articleService.delete(articleType, id);

        if (deleted) {
            return REDIRECT_ADMIN_ARTICLE_LIST + articleType + REQUEST_SUFFIX_ACTION;
        } else {
            return REDIRECT_ADMIN_ARTICLE_LIST + articleType + REQUEST_SUFFIX_ACTION;
        }
    }
}
