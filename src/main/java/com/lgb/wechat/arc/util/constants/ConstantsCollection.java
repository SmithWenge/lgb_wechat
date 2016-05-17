package com.lgb.wechat.arc.util.constants;

import com.github.sd4324530.fastweixin.api.config.ApiConfig;

public class ConstantsCollection {
    public final static String DEFAULT_ARTICLE_COLLECTION_NAME = "zxjy";
    public final static int DEFAULT_RECORD_NOT_DELETE = 0;

    // 微信菜单
    public final static String MENU_XNFU_KEY = "xnfw"; //校内服务
    public final static String MENU_JRKC_KEY = "jrkc"; //校内服务
    public final static String MENU_JWGG_KEY = "jwgg"; //校内服务
    public final static String MENU_ZXJY_KEY = "zxjy"; //校内服务
    public final static String MENU_CJCX_KEY = "cjcx"; //校内服务

    // 平台配置常量
    public final static String APPID = "wx7ce01a4ebcc29e75";
    public final static String APPSECRET = "d4624c36b6795d1d99dcf0547af5443d";

    public final static ApiConfig APPCONFIG = new ApiConfig(APPID, APPSECRET);

    // 默认显示文章数
    public final static int DEFAULT_WEIXIN_RETURN_ARTICLE_NUM = 3;
}
