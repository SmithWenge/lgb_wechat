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
import com.lgb.wechat.arc.util.constants.Constants;
import com.lgb.wechat.arc.util.date.DateUtils;
import com.lgb.wechat.function.weixin.article.service.WeixinArticleService;
import com.lgb.wechat.function.weixin.article.service.impl.WeixinArticleServiceImpl;
import com.lgb.wechat.function.weixin.bind.service.BindService;
import com.lgb.wechat.function.weixin.bind.service.impl.BindServiceImpl;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ServletWeixinSupport extends WeixinSupport {
//    private static final Logger LOG = LoggerFactory.getLogger(ServletWeixinSupport.class);

    private WeixinArticleService weixinArticleService;
    private BindService bindService;

    public ServletWeixinSupport() {
        weixinArticleService = new WeixinArticleServiceImpl();
        bindService = new BindServiceImpl();
    }

    @Override
    protected String getToken() {
        return Constants.TOKEN;
    }

    @Override
    public BaseMsg handleTextMsg(TextReqMsg msg) {
        String message = msg.getContent().trim().toUpperCase();
        String commandPrefix = message.substring(0, 2);

        if (commandPrefix.equals(Constants.WEIXIN_MSG_TIANQI_PREFIX)) {
            String location = message.substring(2);
            TQSummary tqSummary = TQHttpRequest.getBaiduTQ(location);

            return new TextMsg(tqSummary.toString());
        } else if (commandPrefix.equals(Constants.WEINXIN_MSG_RIQI_PREFIX)) {
            String dateStr = message.substring(2);
            RQSummary rqSummary = RQHttpRequest.getDateInfo(dateStr);

            return new TextMsg(rqSummary.toString());
        } else if (commandPrefix.equals(Constants.WEIXIN_MSG_CHENGJI_PREFIX)) {
            String scoreDate = message.substring(2);
            String userWeixinId = msg.getFromUserName();
            String userCardNum = bindService.isBind(userWeixinId);

            if (null == userCardNum || userCardNum.isEmpty()) {
                return new TextMsg("请您先绑定用户信息.");
            } else {
                List<RestStudentScoreInfo> infos = CJHttpRequest.getManageCJ(userCardNum);

                if (infos.size() < 1) {
                    return new TextMsg("您暂时没有成绩录入到系统中.");
                }

                TextMsg textMsg = new TextMsg();

                for (RestStudentScoreInfo info : infos) {
                    textMsg.add(info.toString());
                }

                return textMsg;
            }
        } else if (commandPrefix.equals(Constants.WEIXIN_MSG_KECHENG_PREFIX)) {
            String kcStr = message.substring(2); // 某天日期

            String userWeixinId = msg.getFromUserName();
            String userCardNum = bindService.isBind(userWeixinId);

            if (null == userCardNum || userCardNum.isEmpty()) {
                return new TextMsg("请您先绑定用户信息.");
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
        }

        return new TextMsg("请您按着帮助文档输入正确的数据格式");
    }

    @Override
    protected BaseMsg handleMenuClickEvent(MenuEvent event) {
        String eventKey = event.getEventKey();


        if (eventKey.equals(Constants.MENU_WYJ_KEY)) {
            return getArticleMsg(Constants.MENU_WYJ_KEY);
        } else if (eventKey.equals(Constants.MENU_JWGG_KEY)) {
            return getArticleMsg(Constants.MENU_JWGG_KEY);
        } else if (eventKey.equals(Constants.MENU_ZXJY_KEY)) {
            return getArticleMsg(Constants.MENU_ZXJY_KEY);
        } else if (eventKey.equals(Constants.MENU_JQHD_KEY)) {
            return getArticleMsg(Constants.MENU_JQHD_KEY);
        } else if (eventKey.equals(Constants.MENU_LSZK_KEY)) {
            return getArticleMsg(Constants.MENU_LSZK_KEY);
        } else if (eventKey.equals(Constants.MENU_TQCX_KEY)) {
            TQSummary tqSummary = TQHttpRequest.getBaiduTQ(Constants.DEFAULT_TQ_QUERY_LOCATION);

            return new TextMsg(tqSummary.toString());
        } else if (eventKey.equals(Constants.MENU_RQCX_KEY)) {
            String queryDate = DateUtils.now4Y2M2D();
            RQSummary summary = RQHttpRequest.getDateInfo(queryDate);

            return new TextMsg(summary.toString());
        } else if (eventKey.equals(Constants.MENU_FZCX_KEY)) {
            return new ImageMsg(Constants.WECHAT_HELP_IMAGE_MEDIA_ID);
        } else if (eventKey.equals(Constants.MENU_CJCX_KEY)) {
            String userWeixinId = event.getFromUserName();
            String userCardNum = bindService.isBind(userWeixinId);

            if (null == userCardNum || userCardNum.isEmpty()) {
                return new TextMsg("请您先绑定用户信息.");
            } else {
                List<RestStudentScoreInfo> infos = CJHttpRequest.getManageCJ(userCardNum);

                if (infos.size() < 1) {
                    return new TextMsg("您暂时没有成绩录入到系统中.");
                }

                TextMsg textMsg = new TextMsg();

                for (RestStudentScoreInfo info : infos) {
                    textMsg.add(info.toString());
                }

                return textMsg;
            }
        } else if (eventKey.equals(Constants.MENU_JRKC_KEY)) {
            String userWeixinId = event.getFromUserName();
            String userCardNum = bindService.isBind(userWeixinId);

            if (null == userCardNum || userCardNum.isEmpty()) {
                return new TextMsg("请您先绑定用户信息.");
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
        }

        return new TextMsg("请选择正确的菜单");
    }

    private BaseMsg getArticleMsg(String msgType) {
        List<Document> documents = weixinArticleService.first5Articles(msgType);
        List<Article> articles = new ArrayList<>();

        for (Document document : documents) {
            Article article = new Article(document.getString("articleTitle"), document.getString("articleTitle"), document.getString("pictureUrl"), document.getString("articleUrl"));
            articles.add(article);
        }
        return new NewsMsg(articles);
    }
}
