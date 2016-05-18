package com.lgb.wechat.function.weixin.servlet;

import com.github.sd4324530.fastweixin.message.*;
import com.github.sd4324530.fastweixin.message.req.MenuEvent;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.github.sd4324530.fastweixin.servlet.WeixinSupport;
import com.lgb.wechat.arc.util.constants.ConstantsCollection;
import com.lgb.wechat.function.weixin.article.service.WeixinArticleService;
import com.lgb.wechat.function.weixin.article.service.impl.WeixinArticleServiceImpl;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ServletWeixinSupport extends WeixinSupport {
    private static final Logger LOG = LoggerFactory.getLogger(ServletWeixinSupport.class);

    private WeixinArticleService weixinArticleService;

    public ServletWeixinSupport() {
        weixinArticleService = new WeixinArticleServiceImpl();
    }

    @Override
    protected String getToken() {
        return ConstantsCollection.TOKEN;
    }


    @Override
    protected BaseMsg handleTextMsg(TextReqMsg msg) {
        String content = msg.getContent();

        if (LOG.isDebugEnabled())
            LOG.debug("用户发送到服务器的内容:{}", content);

        return new TextMsg("服务器回复用户消息!");
    }

    @Override
    protected BaseMsg handleMenuClickEvent(MenuEvent event) {
        String eventKey = event.getEventKey();

        if (eventKey.equals(ConstantsCollection.MENU_ZXJY_KEY)) {
            return getArticleMsg(ConstantsCollection.MENU_ZXJY_KEY);
        } else if (eventKey.equals(ConstantsCollection.MENU_JWGG_KEY)) {
            return getArticleMsg(ConstantsCollection.MENU_JWGG_KEY);
        } else if (eventKey.equals(ConstantsCollection.MENU_WYJ_KEY)) {
            return getArticleMsg(ConstantsCollection.MENU_WYJ_KEY);
        } else if (eventKey.equals(ConstantsCollection.MENU_JQHD_KEY)) {
            return getArticleMsg(ConstantsCollection.MENU_JQHD_KEY);
        } else if (eventKey.equals(ConstantsCollection.MENU_LSZK_KEY)) {
            return getArticleMsg(ConstantsCollection.MENU_LSZK_KEY);
        } else if (eventKey.equals(ConstantsCollection.MENU_CJCX_KEY)) {
            return new TextMsg("成绩查询");
        } else if (eventKey.equals(ConstantsCollection.MENU_CXBZ_KEY)) {
            return new TextMsg("查询帮助");
        } else if (eventKey.equals(ConstantsCollection.MENU_RQCX_KEY)) {
            return new TextMsg("日期查询");
        }

        return new TextMsg("请选择正确的菜单");
    }

    private BaseMsg getArticleMsg(String msgType) {
        List<Document> documents = weixinArticleService.firstThreeArticles(msgType);
        List<Article> articles = new ArrayList<>();

        for (Document document : documents) {
            Article article = new Article(document.getString("articleTitle"), document.getString("articleTitle"), "http://www.56team.com/photo/index/welcome001.jpg", "http://localhost:8080/wechat/weixin/article/view/" + ConstantsCollection.MENU_ZXJY_KEY + "/" + document.getString("_id"));
            articles.add(article);
        }
        return new NewsMsg(articles);
    }

//    private void sendCJCXMessage() {
//        MediaAPI mediaAPI = new MediaAPI(ConstantsCollection.APPCONFIG);
//        UploadMediaResponse response = mediaAPI.uploadMedia(MediaType.IMAGE, new File("/Users/liunaidi/Documents/tmp.png"));
//        String media_id = response.getMediaId();
//        Article article = new Article(media_id, "测试用户", "群发测试", "http://www.baidu.com", "群发测试", "群发测试", Article.ShowConverPic.NO);
//        UploadMediaResponse uploadMediaResponse = mediaAPI.uploadNews(Arrays.asList(article));
//        MpNewsMsg mpNewsMsg = new MpNewsMsg();
//        mpNewsMsg.setMediaId(uploadMediaResponse.getMediaId());
//        MessageAPI messageAPI = new MessageAPI(ConstantsCollection.APPCONFIG);
//        GetSendMessageResponse messageResponse = messageAPI.sendMessageToUser(mpNewsMsg, true, "0", null);
//        LOG.info("Send Message Id is " + messageResponse.getMsgId());
//    }
}
