package com.lgb.wechat.function.weixin.servlet;

import com.github.sd4324530.fastweixin.message.*;
import com.github.sd4324530.fastweixin.message.req.MenuEvent;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.github.sd4324530.fastweixin.servlet.WeixinSupport;
import com.lgb.wechat.arc.util.api.http.CJHttpRequest;
import com.lgb.wechat.arc.util.api.http.KCHttpRequest;
import com.lgb.wechat.arc.util.api.http.RQHttpRequest;
import com.lgb.wechat.arc.util.api.http.TQHttpRequest;
import com.lgb.wechat.arc.util.api.json.cj.RestStudentScoreInfo;
import com.lgb.wechat.arc.util.api.json.kc.RestNowStudentCourseInfo;
import com.lgb.wechat.arc.util.api.json.rq.RQSummary;
import com.lgb.wechat.arc.util.api.json.tq.TQSummary;
import com.lgb.wechat.arc.util.constants.ConstantsCollection;
import com.lgb.wechat.arc.util.date.DateUtils;
import com.lgb.wechat.function.weixin.article.service.WeixinArticleService;
import com.lgb.wechat.function.weixin.article.service.impl.WeixinArticleServiceImpl;
import com.lgb.wechat.function.weixin.bind.service.BindService;
import com.lgb.wechat.function.weixin.bind.service.impl.BindServiceImpl;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
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
    public BaseMsg handleTextMsg(TextReqMsg msg) {
        String content = msg.getContent().trim().toUpperCase();

        List<String> list = null;
        if (content.contains(":")) {
            list = Arrays.asList(content.split(":"));
        } else {
            list = Arrays.asList(content);
        }

        if (list.get(0).equals(ConstantsCollection.CJ_REQUEDT)) {
            String userWeixinId = msg.getFromUserName();
            String userCardNum = bindService.isBind(userWeixinId);

            if (null == userCardNum || userCardNum.isEmpty()) {
                return new TextMsg("请先绑定学员卡号,发送信息(3:学号卡号)");
            } else {
                List<RestStudentScoreInfo> infos = CJHttpRequest.getManageCJ(userCardNum);

                if (infos.size() < 1) {
                    return new TextMsg("成绩暂时还没有公布");
                }

                TextMsg textMsg = new TextMsg();

                for (RestStudentScoreInfo info : infos) {
                    textMsg.add(info.toString());
                }

                return textMsg;
            }
        } else if (list.get(0).equals(ConstantsCollection.KC_REQUEST)) {
            String userWeixinId = msg.getFromUserName();
            String userCardNum = bindService.isBind(userWeixinId);

            if (null == userCardNum || userCardNum.isEmpty()) {
                return new TextMsg("请先绑定学员卡号,发送信息(3:学号卡号)");
            } else {
                List<RestNowStudentCourseInfo> infos = KCHttpRequest.getManageKC(userCardNum);

                if (infos.size() < 1) {
                    return new TextMsg("您今日没有课程.");
                }

                TextMsg textMsg = new TextMsg();

                for (RestNowStudentCourseInfo info : infos) {
                    textMsg.add(info.toString());
                }

                return textMsg;
            }
        } else if (list.get(0).equals(ConstantsCollection.TQ_REQUEST)) {
            if (list.size() <= 1) {
                list = Arrays.asList(content, ConstantsCollection.DEFAULT_TQ_QUERY_LOCATION);
            }

            TQSummary tqSummary = TQHttpRequest.getBaiduTQ(list.get(1));

            if (tqSummary.getError() > 0) {
                return new TextMsg("请填写正确的查询格式,4:地点(默认为:大连)");
            }

            return new TextMsg(tqSummary.toString());
        } else if (list.get(0).equals(ConstantsCollection.BD_REQUEST)) {
            if (list.size() <= 1) {
                return new TextMsg("请注意绑定的格式为 3:学生卡号 \n" +
                        "数字3与学生卡号用英文格式的冒号隔开 ");
            }

            String userWeixinId = msg.getFromUserName();
            String userCardNum = list.get(1);

            if (bindService.bind(userCardNum, userWeixinId)) {
                if (LOG.isInfoEnabled())
                    LOG.info("[OK] {} 绑定卡号成功", userCardNum);
                return new TextMsg("绑定卡号成功" + userCardNum);
            } else {
                return new TextMsg("您已经绑定了,微信号与卡号一一对应,如绑定信息错误请联系管理员.");
            }
        } else if (list.get(0).equals(ConstantsCollection.RQ_REQUEST)) {
            String queryDate = DateUtils.now4Y2M2D();

            if (list.size() > 1) {
                queryDate = DateUtils.dateFormat4Y2M2D(list.get(1));
            }

            RQSummary summary = RQHttpRequest.getDateInfo(queryDate);

            if (!summary.getError_code().equals("0") || summary.getError_code().length() > 1) {
                return new TextMsg("请输入正确是查询格式,如 5:20150503");
            } else {
                return new TextMsg(summary.toString());
            }
        }

            if (LOG.isDebugEnabled())
            LOG.debug("用户发送到服务器的内容:{}", content);

        return new TextMsg("请输入正确的信息！");
    }

    @Override
    protected BaseMsg handleMenuClickEvent(MenuEvent event) {
        String eventKey = event.getEventKey();


        if (eventKey.equals(ConstantsCollection.MENU_WYJ_KEY)) {
            return getArticleMsg(ConstantsCollection.MENU_WYJ_KEY);
        } else if (eventKey.equals(ConstantsCollection.MENU_JWGG_KEY)) {
            return getArticleMsg(ConstantsCollection.MENU_JWGG_KEY);
        } else if (eventKey.equals(ConstantsCollection.MENU_ZXJY_KEY)) {
            return getArticleMsg(ConstantsCollection.MENU_ZXJY_KEY);
        } else if (eventKey.equals(ConstantsCollection.MENU_JQHD_KEY)) {
            return getArticleMsg(ConstantsCollection.MENU_JQHD_KEY);
        } else if (eventKey.equals(ConstantsCollection.MENU_LSZK_KEY)) {
            return getArticleMsg(ConstantsCollection.MENU_LSZK_KEY);
        } else if (eventKey.equals(ConstantsCollection.MENU_XNFU_KEY)) {
            return new TextMsg("输入对应数字进行相关操作:\n" +
                    "1. 回复1查询个人相关的成绩;\n" +
                    "2. 回复2查询今日的个人课程;\n" +
                    "3. 回复3绑定卡号\n" +
                    "例如3:0123456789(学生卡号);");
//        } else if (eventKey.equals(ConstantsCollection.MENU_JRKC_KEY)) {
//            return new TextMsg("1. 登陆平台的时候请先绑定 回复4:0123456789(卡号);\n 2. 回复2查询今日的个人课程");
//        } else if (eventKey.equals(ConstantsCollection.MENU_CJCX_KEY)) {
//            return new TextMsg("1. 登陆平台的时候请先绑定 回复4:0123456789(卡号);\n 2. 回复1查询个人相关的成绩");
        } else if (eventKey.equals(ConstantsCollection.MENU_TQCX_KEY)) {
            return new TextMsg("回复4:地点(默认为:大连)查看当前天气;");
        } else if (eventKey.equals(ConstantsCollection.MENU_RQCX_KEY)) {
            return new TextMsg("请输入5查询今天的日期信息,或者输入5:20150523(要查询的日期)查询对应的日期信息");
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
