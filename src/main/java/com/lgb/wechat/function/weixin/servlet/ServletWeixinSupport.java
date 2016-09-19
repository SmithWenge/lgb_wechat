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
        return Constants.TOKEN;
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

        if (list.get(0).equals(Constants.CJ_REQUEDT)) {
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
        } else if (list.get(0).equals(Constants.KC_REQUEST)) {
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
        } else if (list.get(0).equals(Constants.TQ_REQUEST)) {
            if (list.size() <= 1) {
                list = Arrays.asList(content, Constants.DEFAULT_TQ_QUERY_LOCATION);
            }

            TQSummary tqSummary = TQHttpRequest.getBaiduTQ(list.get(1));

            if (tqSummary.getError() > 0) {
                return new TextMsg("请填写正确的查询格式,4:地点(默认为:大连)");
            }

            return new TextMsg(tqSummary.toString());
        } else if (list.get(0).equals(Constants.BD_REQUEST)) {
            if (list.size() <= 1) {
                return new TextMsg("请注意绑定的格式为:\n " +
                        "3:0123456789(学生卡号)\n" +
                        "数字3与卡号用英文冒号隔开");
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
        } else if (list.get(0).equals(Constants.RQ_REQUEST)) {
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
