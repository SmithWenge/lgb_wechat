package com.lgb.wechat.arc.util.constants;

import com.github.sd4324530.fastweixin.api.config.ApiConfig;

public class Constants {
    public static final String SESSION_ADMIN_KEY = "adminLogin";
    public static final String DEFAULT_ARTICLE_COLLECTION_NAME = "zxjy";
    public static final int DEFAULT_RECORD_NOT_DELETE = 0;

    // 微信菜单
    public static final String MENU_XNFU_KEY = "xnfw"; //校内服务
//    public final static String MENU_JRKC_KEY = "jrkc"; //今日课表
    public static final String MENU_JWGG_KEY = "jwgg"; //教务公告
    public static final String MENU_ZXJY_KEY = "zxjy"; //在线教育
//    public final static String MENU_CJCX_KEY = "cjcx"; //成绩查询
    public static final String MENU_SHZS_KEY = "shzs"; //生活助手
    public static final String MENU_WYJ_KEY = "wyj"; //外语角
    public static final String MENU_TQCX_KEY = "cxbz"; //天气查询
    public static final String MENU_RQCX_KEY = "rqcx"; //日期查询
    public static final String MENU_DCXY_KEY = "dcxy"; //多彩校园
    public static final String MENU_JQHD_KEY = "jqhd"; //近期活动
    public static final String MENU_LSZK_KEY = "lszk"; //历史周刊
    public static final String MENU_XXJJ_KEY = "xxjj"; //学校简介
    public static final String MENU_DXWZ_KEY = "dxwz"; //大学网站
    public static final String MENU_XNCX_KEY = "xncx"; //校内查询

    // 平台配置常量
    public static final String APPID = "wx02c623958c0e1e3a";
    public static final String APPSECRET = "65e76155f77b2c6034de8de88c88a4dc";
    public static final String TOKEN = "lgbwechat";

    public static final ApiConfig APPCONFIG = new ApiConfig(APPID, APPSECRET);

    // 默认显示文章数
    public static final int DEFAULT_WEIXIN_RETURN_ARTICLE_NUM = 5;

    // 查询使用关键字
    public static final String CJ_REQUEDT = "1"; //成绩查询
    public static final String KC_REQUEST = "2"; //课程查询
    public static final String TQ_REQUEST = "4"; //天气查询
    public static final String BD_REQUEST = "3"; //学员绑定
    public static final String RQ_REQUEST = "5"; //日期查询
//    public final static String JW_REQUEST = "6"; //教务公告
//    public final static String ZX_REQUEST = "7"; //在线教育

    // 默认天气地点
    public static final String DEFAULT_TQ_QUERY_LOCATION = "大连";
}
