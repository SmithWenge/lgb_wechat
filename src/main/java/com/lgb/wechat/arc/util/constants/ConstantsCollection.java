package com.lgb.wechat.arc.util.constants;

import com.github.sd4324530.fastweixin.api.config.ApiConfig;

public class ConstantsCollection {
    public final static String DEFAULT_ARTICLE_COLLECTION_NAME = "zxjy";
    public final static int DEFAULT_RECORD_NOT_DELETE = 0;

    // 微信菜单
    public final static String MENU_XNFU_KEY = "xnfw"; //校内服务
    public final static String MENU_JRKC_KEY = "jrkc"; //今日课表
    public final static String MENU_JWGG_KEY = "jwgg"; //教务公告
    public final static String MENU_ZXJY_KEY = "zxjy"; //在线教育
    public final static String MENU_CJCX_KEY = "cjcx"; //成绩查询
    public final static String MENU_SHZS_KEY = "shzs"; //生活助手
    public final static String MENU_WYJ_KEY = "wyj"; //外语角
    public final static String MENU_CXBZ_KEY = "cxbz"; //查询帮助
    public final static String MENU_RQCX_KEY = "rqcx"; //日期查询
    public final static String MENU_DCXY_KEY = "dcxy"; //多彩校园
    public final static String MENU_JQHD_KEY = "jqhd"; //近期活动
    public final static String MENU_LSZK_KEY = "lszk"; //历史周刊
    public final static String MENU_XXJJ_KEY = "xxjj"; //学校简介
    public final static String MENU_DXWZ_KEY = "dxwz"; //大学网站

    // 平台配置常量
    public final static String APPID = "wx8be799b6065e36ff";
    public final static String APPSECRET = "4c1b045565ce2fc76c750574dfa1dee0";
    public final static String TOKEN = "lgbwechat";

    public final static ApiConfig APPCONFIG = new ApiConfig(APPID, APPSECRET);

    // 默认显示文章数
    public final static int DEFAULT_WEIXIN_RETURN_ARTICLE_NUM = 3;
}
