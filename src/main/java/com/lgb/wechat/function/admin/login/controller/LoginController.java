package com.lgb.wechat.function.admin.login.controller;


import com.google.common.base.Optional;
import com.lgb.wechat.arc.util.constants.Constants;
import com.lgb.wechat.function.admin.login.AdminUser;
import com.lgb.wechat.function.admin.login.service.LoginServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 *  管理员登录路由器
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private LoginServiceI loginService;

    /**
     * 路由到登录后管理员首页
     *
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String routeHome() {
        return "index";
    }

    /**
     * 路由到登录页面
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/route/login", method = RequestMethod.GET)
    public String routeLogin(HttpSession session) {
        if (null != session.getAttribute(Constants.SESSION_ADMIN_KEY)) {
            return "redirect:/admin/home.action";
        }

        return "admin/login/adminLogin";
    }

    /**
     * 管理员登录系统
     *
     * @param adminUser
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(AdminUser adminUser, HttpSession session) {
        AdminUser user = (AdminUser) session.getAttribute(Constants.SESSION_ADMIN_KEY);
        Optional<AdminUser> optionalUser = Optional.fromNullable(user);

        if (optionalUser.isPresent()) {
            return new ModelAndView("redirect:/admin/home.action");
        }
        ModelAndView mav = new ModelAndView();
        if(loginService.isLogin(adminUser)) {
            mav.setViewName("redirect:/admin/home.action");

            session.setAttribute(Constants.SESSION_ADMIN_KEY, adminUser);
        }else {
            mav.setViewName("redirect:/admin/route/login.action");
        }

        return mav;
    }

    @RequestMapping(value = "/route/pass", method = RequestMethod.GET)
    public String routePass() {
        return "admin/login/resetPass";
    }

    @RequestMapping(value = "/reset/pass", method = RequestMethod.POST)
    public ModelAndView resetPass(AdminUser adminUser,HttpSession session) {
        ModelAndView mav = new ModelAndView("redirect:/admin/route/login.action");

        if (loginService.resetPassword(adminUser)) {
            session.removeAttribute(Constants.SESSION_ADMIN_KEY);
            return mav;
        }

        return new ModelAndView("redirect:/admin/route/pass.action");
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(Constants.SESSION_ADMIN_KEY);

        return "redirect:/admin/route/login.action";
    }
}