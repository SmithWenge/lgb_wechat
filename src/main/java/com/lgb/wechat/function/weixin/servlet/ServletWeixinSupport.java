package com.lgb.wechat.function.weixin.servlet;

import com.github.sd4324530.fastweixin.message.*;
import com.github.sd4324530.fastweixin.message.req.MenuEvent;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.github.sd4324530.fastweixin.servlet.WeixinSupport;
import com.lgb.wechat.arc.util.api.http.KCHttpRequest;
import com.lgb.wechat.arc.util.api.http.TQHttpRequest;
import com.lgb.wechat.arc.util.api.json.kc.RestNowStudentCourseInfo;
import com.lgb.wechat.arc.util.api.json.tq.TQSummary;
import com.lgb.wechat.arc.util.constants.ConstantsCollection;
import com.lgb.wechat.function.weixin.article.service.WeixinArticleService;
import com.lgb.wechat.function.weixin.article.service.impl.WeixinArticleServiceImpl;
import com.lgb.wechat.function.weixin.bind.service.BindService;
import com.lgb.wechat.function.weixin.bind.service.impl.BindServiceImpl;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ServletWeixinSupport extends WeixinSupport {
    private static final Logger LOG = LoggerFactory.getLogger(ServletWeixinSupport.class);

    private WeixinArticleService weixinArticleService;
    private BindService bindService;

    public ServletWeixinSupport() {
        weixinArticleService = new WeixinArticleServiceImpl();
        bindService = new BindServiceImpl();
    }

    @Override
    protected String getToken() {
        return ConstantsCollection.TOKEN;
    }


    @Override
    protected BaseMsg handleTextMsg(TextReqMsg msg) {
        String content = msg.getContent().trim().toUpperCase();

        String[] requests = {};
        if (content.contains(":")) {
            requests = content.split(":");
        } else {
            requests[0] = content;
        }


        if (requests[0].equals(ConstantsCollection.CJ_REQUEDT)) {
            LOG.info("#########################################" + msg.getFromUserName());
        } else if (requests[0].equals(ConstantsCollection.KC_REQUEST)) {
            String userWeixinId = msg.getFromUserName();
            String userCardNum = bindService.isBind(userWeixinId);

            if (null == userCardNum || userCardNum.isEmpty()) {
                return new TextMsg("请先绑定学号,发送信息(BD:学号卡号)");
            } else {
                List<RestNowStudentCourseInfo> infos = KCHttpRequest.getBaiduTQ(userCardNum);
                TextMsg textMsg = new TextMsg();

                for (RestNowStudentCourseInfo info : infos) {
                    textMsg.add(info.toString());
                }

                return textMsg;
            }
        } else if (requests[0].equals(ConstantsCollection.TQ_REQUEST)) {
            TQSummary TQSummary = TQHttpRequest.getBaiduTQ(requests[1]);
            return new TextMsg(TQSummary.toString());
        } else if (requests[0].equals(ConstantsCollection.BD_REQUEST)) {
            if (null == requests[1] || requests[1].length() <= 0) {
                return new TextMsg("请在绑定的时候输入正确的学员卡号");
            }

            String userWeixinId = msg.getFromUserName();
            String userCardNum = requests[1];

            if (bindService.bind(userCardNum, userWeixinId)) {
                if (LOG.isInfoEnabled())
                    LOG.info("[OK] {} 绑定卡号成功");
                return new TextMsg("绑定卡号成功" + userCardNum);
            }

            return new TextMsg("请重新绑定,格式为DB:学员卡号");
        }

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
        } else if (eventKey.equals(ConstantsCollection.MENU_JRKC_KEY)) {
            return new TextMsg("请输入KC查询今日的个人课程");
        } else if (eventKey.equals(ConstantsCollection.MENU_CJCX_KEY)) {
            return new TextMsg("请输入CJ查询个人相关的成绩");
        } else if (eventKey.equals(ConstantsCollection.MENU_CXBZ_KEY)) {
            return new TextMsg("1. 登陆平台的时候请先绑定 回复BD:0123456789(卡号);\n 2. 回复TQ:地点(默认为:大连)查看当前天气;\n");
        } else if (eventKey.equals(ConstantsCollection.MENU_RQCX_KEY)) {
            return new TextMsg("日期查询");
        }

        return new TextMsg("请选择正确的菜单");
    }

    private BaseMsg getArticleMsg(String msgType) {
        List<Document> documents = weixinArticleService.firstThreeArticles(msgType);
        List<Article> articles = new ArrayList<>();

        for (Document document : documents) {
            Article article = new Article(document.getString("articleTitle"), document.getString("articleTitle"), document.getString("pictureUrl"), document.getString("articleUrl"));
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
