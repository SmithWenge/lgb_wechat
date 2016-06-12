package com.lgb.wechat.function.weixin.menu;

import com.github.sd4324530.fastweixin.api.MenuAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.Menu;
import com.github.sd4324530.fastweixin.api.entity.MenuButton;
import com.github.sd4324530.fastweixin.api.enums.MenuType;
import com.github.sd4324530.fastweixin.api.enums.ResultType;
import com.lgb.wechat.arc.util.constants.ConstantsCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateMenu {
    public static void main(String[] args) {
        createMenu(ConstantsCollection.APPCONFIG);
    }

    private static void createMenu(ApiConfig config) {
        MenuAPI menuAPI = new MenuAPI(config);

        // 删除原来的Menu
        menuAPI.deleteMenu();

        Menu menu = new Menu();
        // 添加一级菜单
        MenuButton xnfw = new MenuButton();
        xnfw.setType(MenuType.CLICK);
        xnfw.setName("校内服务");
        xnfw.setKey(ConstantsCollection.MENU_XNFU_KEY);

        //添加子菜单
//        MenuButton jrkc = new MenuButton();
//        jrkc.setKey(ConstantsCollection.MENU_JRKC_KEY);
//        jrkc.setName("今日课程");
//        jrkc.setType(MenuType.CLICK);

//        MenuButton cjcx = new MenuButton();
//        cjcx.setKey(ConstantsCollection.MENU_CJCX_KEY);
//        cjcx.setName("成绩查询");
//        cjcx.setType(MenuType.CLICK);
////        cjcx.setUrl("http://www.56team.com");

//        List<MenuButton> xnfwSub = new ArrayList<MenuButton>();
//        xnfwSub.add(jrkc);
//        xnfwSub.add(cjcx);

//        xnfw.setSubButton(xnfwSub);

        MenuButton shzs = new MenuButton();
        shzs.setType(MenuType.CLICK);
        shzs.setName("生活助手");
        shzs.setKey(ConstantsCollection.MENU_SHZS_KEY);

        MenuButton wyj = new MenuButton();
        wyj.setKey(ConstantsCollection.MENU_WYJ_KEY);
        wyj.setType(MenuType.CLICK);
        wyj.setName("外语角");

        MenuButton cxbz = new MenuButton();
        cxbz.setType(MenuType.CLICK);
        cxbz.setName("天气查询");
        cxbz.setKey(ConstantsCollection.MENU_TQCX_KEY);
//        cxbz.setUrl("http://www.56team.com");

        MenuButton rqcx = new MenuButton();
        rqcx.setKey(ConstantsCollection.MENU_RQCX_KEY);
        rqcx.setName("日期查询");
        rqcx.setType(MenuType.CLICK);
//        rqcx.setUrl("http://www.56team.com");

        List<MenuButton> shzsSub = new ArrayList<MenuButton>();
        shzsSub.add(wyj);
        shzsSub.add(cxbz);
        shzsSub.add(rqcx);

        shzs.setSubButton(shzsSub);

        MenuButton dcxy = new MenuButton();
        dcxy.setKey(ConstantsCollection.MENU_DCXY_KEY);
        dcxy.setType(MenuType.CLICK);
        dcxy.setName("多彩校园");

        MenuButton zxjy = new MenuButton();
        zxjy.setKey(ConstantsCollection.MENU_ZXJY_KEY);
        zxjy.setName("在线教育");
        zxjy.setType(MenuType.CLICK);

        MenuButton jwgg = new MenuButton();
        jwgg.setKey(ConstantsCollection.MENU_JWGG_KEY);
        jwgg.setName("教务公告");
        jwgg.setType(MenuType.CLICK);

        MenuButton jqhd = new MenuButton();
        jqhd.setKey(ConstantsCollection.MENU_JQHD_KEY);
        jqhd.setType(MenuType.CLICK);
        jqhd.setName("近期活动");

        MenuButton lszk = new MenuButton();
        lszk.setKey(ConstantsCollection.MENU_LSZK_KEY);
        lszk.setType(MenuType.CLICK);
        lszk.setName("历史周刊");

        MenuButton xxjj = new MenuButton();
        xxjj.setKey(ConstantsCollection.MENU_XXJJ_KEY);
        xxjj.setType(MenuType.VIEW);
        xxjj.setName("学校简介");
        xxjj.setUrl("http://www.56team.com:82/web/school/introduction.php");

        MenuButton dxwz = new MenuButton();
        dxwz.setKey(ConstantsCollection.MENU_DXWZ_KEY);
        dxwz.setType(MenuType.VIEW);
        dxwz.setName("大学网站");
        dxwz.setUrl("http://www.56team.com:82/web/");

        List<MenuButton> dcxySub = new ArrayList<MenuButton>();
        dcxySub.add(jqhd);
        dcxySub.add(lszk);
        dcxySub.add(xxjj);
        dcxySub.add(dxwz);
        dcxySub.add(zxjy);
        dcxySub.add(jwgg);

        dcxy.setSubButton(dcxySub);

        List<MenuButton> mainList = new ArrayList<MenuButton>();
        mainList.add(xnfw);
        mainList.add(shzs);
        mainList.add(dcxy);

        menu.setButton(mainList);
        System.out.println(menu.toJsonString());
        ResultType resultType = menuAPI.createMenu(menu);
        System.out.println(resultType.toString());
    }
}
