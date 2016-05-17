package com.lgb.wechat.function.weixin.article.controller;

import com.lgb.wechat.function.admin.article.service.ArticleService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/weixin/article")
public class WeixinArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/view/{colName}/{id}")
    public ModelAndView weixinViewArticle(@PathVariable("colName") String collectionName,
                                    @PathVariable("id") String id) {
        Document document = articleService.view(collectionName, id);

        ModelAndView mav = new ModelAndView("view/article");
        mav.addObject("document", document);

        return mav;
    }
}
