package com.lgb.wechat.function.admin.article.controller;

import com.lgb.wechat.arc.util.constants.ConstantsCollection;
import com.lgb.wechat.function.admin.article.Article;
import com.lgb.wechat.function.admin.article.service.ArticleService;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger LOG = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/route/add")
    public String route2Add() {
        return "admin/article/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addArticle(Article article) {
        articleService.add(article);

        return "redirect:/admin/article/route/edit/" + ConstantsCollection.DEFAULT_ARTICLE_COLLECTION_NAME + ".action";
    }

    @RequestMapping("/list/{articleType}")
    public ModelAndView listArticle(@PathVariable("articleType") String articleType) {
        if (null == articleType || articleType.length() == 0) {
            articleType = ConstantsCollection.DEFAULT_ARTICLE_COLLECTION_NAME;
        }

        List<Document> documents = articleService.list(articleType);

        ModelAndView mav = new ModelAndView("admin/article/list");
        mav.addObject("documents", documents);

        return mav;
    }

    @RequestMapping("/list")
    public ModelAndView listArticleByType(@RequestParam(required = false) String articleType) {
        if (null == articleType || articleType.length() == 0) {
            articleType = ConstantsCollection.DEFAULT_ARTICLE_COLLECTION_NAME;
        }

        List<Document> documents = articleService.list(articleType);

        ModelAndView mav = new ModelAndView("admin/article/list");
        mav.addObject("documents", documents);

        return mav;
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
            return "redirect:/admin/article/list/" + ConstantsCollection.DEFAULT_ARTICLE_COLLECTION_NAME + ".action";
        } else {
            return "redirect:/admin/article/route/edit/" + article.getArticleType() + "/" + article.getId() + ".action";
        }
    }

    @RequestMapping("/delete/{articleType}/{id}")
    public String deleteArticle(@PathVariable("articleType") String articleType,
                                @PathVariable("id") String id) {
        boolean deleted = articleService.delete(articleType, id);

        if (deleted) {
            return "redirect:/admin/article/route/edit/" + articleType + ".action";
        } else {
            return "redirect:/admin/article/route/edit/" + articleType + ".action";
        }
    }
}
