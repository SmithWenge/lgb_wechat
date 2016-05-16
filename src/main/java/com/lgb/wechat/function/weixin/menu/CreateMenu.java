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
        MenuButton jrkc = new MenuButton();
        jrkc.setKey(ConstantsCollection.MENU_JRKC_KEY);
        jrkc.setName("今日课程");
        jrkc.setType(MenuType.CLICK);

        MenuButton jwgg = new MenuButton();
        jwgg.setKey(ConstantsCollection.MENU_JWGG_KEY);
        jwgg.setName("教务公告");
        jwgg.setType(MenuType.CLICK);

        MenuButton cjcx = new MenuButton();
        cjcx.setKey(ConstantsCollection.MENU_CJCX_KEY);
        cjcx.setName("成绩查询");
        cjcx.setType(MenuType.CLICK);

        List<MenuButton> xnfwSub = new ArrayList<MenuButton>();
        xnfwSub.add(jrkc);
        xnfwSub.add(jwgg);
        xnfwSub.add(cjcx);

        xnfw.setSubButton(xnfwSub);

        List<MenuButton> mainList = new ArrayList<MenuButton>();
        mainList.add(xnfw);

        menu.setButton(mainList);
        System.out.println(menu.toJsonString());
        ResultType resultType = menuAPI.createMenu(menu);
        System.out.println(resultType.toString());
    }
}
