package com.lgb.wechat.arc.util.constants;

import com.github.sd4324530.fastweixin.api.config.ApiConfig;

public class Constants {
    public static final String SESSION_ADMIN_KEY = "adminLogin";
    public static final String DEFAULT_ARTICLE_COLLECTION_NAME = "zxjy";
    public static final int DEFAULT_RECORD_NOT_DELETE = 0;

    // 微信菜单
    public static final String MENU_XINWEN_KEY = "xinwen"; //一级导航栏新闻
    public static final String MENU_JWGG_KEY = "jwgg"; //教务公告
    public static final String MENU_ZXJY_KEY = "zxjy"; //在线教育
    public static final String MENU_SHZS_KEY = "shzs"; //生活助手
    public static final String MENU_WYJ_KEY = "wyj"; //外语角
    public static final String MENU_CJCX_KEY = "cjcx"; //成绩
    public static final String MENU_JRKC_KEY = "jrkc"; //今日课程
    public static final String MENU_TQCX_KEY = "tqcx"; //天气查询
    public static final String MENU_RQCX_KEY = "rqcx"; //日期查询
    public static final String MENU_JQHD_KEY = "jqhd"; //近期活动
    public static final String MENU_LSZK_KEY = "lszk"; //历史周刊
    public static final String MENU_KWXX_KEY = "kwxx"; //课外学习
    public static final String MENU_BD_KEY = "bd"; //账号绑定
    public static final String MENU_FZCX_KEY = "fzcx"; //辅助查询

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

    // 帮助图片media ID
    public static final String WECHAT_HELP_IMAGE_MEDIA_ID = "ebr8ldhXDLF_5m9kfKqgKNBCv1QIY26iqGEBSNNSby2FT54UOwLA5Oec98Du8BkL";
    // 推送文章存放的collection名
    public static final String PUSH_ARTICLE_COLLECTION_NAME = "push";
    // 推送文章的类型
    public static final String PUSH_ARTICLE_TYPE = "push";
    // 设定为默认非推送状态
    public static final int DEFAULT_PUSH_ARTICLE_NOT_PUSHED = 0;
    // 天气查询
    public static final String WEIXIN_MSG_TIANQI_PREFIX = "TQ";
    // 日期查询
    public static final String WEINXIN_MSG_RIQI_PREFIX = "RQ";
    // 成绩查询
    public static final String WEIXIN_MSG_CHENGJI_PREFIX = "CJ";
    // 课程查询
    public static final String WEIXIN_MSG_KECHENG_PREFIX = "KC";
}
