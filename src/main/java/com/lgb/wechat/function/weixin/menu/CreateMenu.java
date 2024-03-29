package com.lgb.wechat.function.weixin.menu;

import com.github.sd4324530.fastweixin.api.MenuAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.Menu;
import com.github.sd4324530.fastweixin.api.entity.MenuButton;
import com.github.sd4324530.fastweixin.api.enums.MenuType;
import com.github.sd4324530.fastweixin.api.enums.ResultType;
import com.lgb.wechat.arc.util.constants.Constants;

import java.util.ArrayList;
import java.util.List;

public class CreateMenu {
    public static void main(String[] args) {
        createMenu(Constants.APPCONFIG);
    }

    private static void createMenu(ApiConfig config) {
        MenuAPI menuAPI = new MenuAPI(config);

        // 删除原来的Menu
        menuAPI.deleteMenu();

        Menu menu = new Menu();
        // 添加一级菜单
        MenuButton xinwen = new MenuButton();
        xinwen.setType(MenuType.CLICK);
        xinwen.setName("新闻");
        xinwen.setKey(Constants.MENU_XINWEN_KEY);

        MenuButton zxjy = new MenuButton();
        zxjy.setKey(Constants.MENU_ZXJY_KEY);
        zxjy.setName("在线教育");
        zxjy.setType(MenuType.CLICK);

        MenuButton jwgg = new MenuButton();
        jwgg.setKey(Constants.MENU_JWGG_KEY);
        jwgg.setName("教务公告");
        jwgg.setType(MenuType.CLICK);

        MenuButton jqhd = new MenuButton();
        jqhd.setKey(Constants.MENU_JQHD_KEY);
        jqhd.setType(MenuType.CLICK);
        jqhd.setName("近期活动");

        MenuButton lszk = new MenuButton();
        lszk.setKey(Constants.MENU_LSZK_KEY);
        lszk.setType(MenuType.CLICK);
        lszk.setName("周刊");

        List<MenuButton> xinwenSub = new ArrayList<MenuButton>();
        xinwenSub.add(jqhd);
        xinwenSub.add(lszk);
        xinwenSub.add(zxjy);
        xinwenSub.add(jwgg);

        xinwen.setSubButton(xinwenSub);

        MenuButton shzs = new MenuButton();
        shzs.setType(MenuType.CLICK);
        shzs.setName("生活");
        shzs.setKey(Constants.MENU_SHZS_KEY);

        MenuButton cj = new MenuButton();
        cj.setKey(Constants.MENU_CJCX_KEY);
        cj.setName("成绩");
        cj.setType(MenuType.CLICK);

        MenuButton jrkc = new MenuButton();
        jrkc.setKey(Constants.MENU_JRKC_KEY);
        jrkc.setType(MenuType.CLICK);
        jrkc.setName("今日课程");

        MenuButton tqcx = new MenuButton();
        tqcx.setType(MenuType.CLICK);
        tqcx.setName("今日天气");
        tqcx.setKey(Constants.MENU_TQCX_KEY);

        MenuButton rqcx = new MenuButton();
        rqcx.setKey(Constants.MENU_RQCX_KEY);
        rqcx.setName("今日黄历");
        rqcx.setType(MenuType.CLICK);

        MenuButton wyj = new MenuButton();
        wyj.setKey(Constants.MENU_WYJ_KEY);
        wyj.setType(MenuType.CLICK);
        wyj.setName("外语角");

        List<MenuButton> shSub = new ArrayList<MenuButton>();
        shSub.add(cj);
        shSub.add(jrkc);
        shSub.add(tqcx);
        shSub.add(rqcx);
        shSub.add(wyj);

        shzs.setSubButton(shSub);

        MenuButton kwxx = new MenuButton();
        kwxx.setName("帮助");
        kwxx.setType(MenuType.CLICK);
        kwxx.setKey(Constants.MENU_KWXX_KEY);

        MenuButton bd = new MenuButton();
        bd.setKey(Constants.MENU_BD_KEY);
        bd.setType(MenuType.VIEW);
        bd.setName("账号绑定");
        bd.setUrl("http://wechat.dllgbdx.com/user/route/bind.action");

        MenuButton fzcx = new MenuButton();
        fzcx.setKey(Constants.MENU_FZCX_KEY);
        fzcx.setType(MenuType.CLICK);
        fzcx.setName("其它查询");

        List<MenuButton> kwxxSub = new ArrayList<MenuButton>();
        kwxxSub.add(bd);
        kwxxSub.add(fzcx);

        kwxx.setSubButton(kwxxSub);

        List<MenuButton> mainList = new ArrayList<MenuButton>();
        mainList.add(xinwen);
        mainList.add(shzs);
        mainList.add(kwxx);

        menu.setButton(mainList);
        System.out.println(menu.toJsonString());
        ResultType resultType = menuAPI.createMenu(menu);
        System.out.println(resultType.toString());
    }
}
