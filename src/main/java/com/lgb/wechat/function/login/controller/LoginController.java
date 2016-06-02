package com.lgb.wechat.function.login.controller;

import com.google.common.base.Optional;
import com.lgb.wechat.arc.util.constants.ConstantsCollection;
import com.lgb.wechat.function.login.AdminUser;
import com.lgb.wechat.function.login.service.LoginServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/weixin/admin")
public class LoginController {

    @Autowired
    private LoginServiceI loginService;

    @RequestMapping(value = "/routeHome", method = RequestMethod.GET)
    public String routeHome() {
        return "index";
    }

    @RequestMapping(value = "/routeLogin", method = RequestMethod.GET)
    public String routeLogin() {
        return "admin/login/adminLogin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(AdminUser adminUser, HttpSession session) {
        AdminUser user = (AdminUser) session.getAttribute(ConstantsCollection.SESSION_ADMIN_KEY);

        Optional<AdminUser> optionalUser = Optional.fromNullable(user);

        if (optionalUser.isPresent()) {
            return new ModelAndView("redirect:/weixin/admin/routeHome.action");
        }

        ModelAndView mav = new ModelAndView();
        if(loginService.isLogin(adminUser)) {
            mav.setViewName("redirect:/weixin/admin/routeHome.action");
            session.setAttribute(ConstantsCollection.SESSION_ADMIN_KEY, adminUser);
        }else {
            mav.setViewName("redirect:/weixin/admin/routeLogin.action");
        }
        return mav;
    }

    @RequestMapping(value = "/routePass", method = RequestMethod.GET)
    public String routePass() {
        return "admin/login/resetPass";
    }

    @RequestMapping(value = "/resetPass", method = RequestMethod.POST)
    public ModelAndView resetPass(AdminUser adminUser,HttpSession session) {
        ModelAndView mav = new ModelAndView("redirect:/admin/routeLogin.action");

        if (loginService.resetPassword(adminUser)) {
            session.removeAttribute(ConstantsCollection.SESSION_ADMIN_KEY);
            return mav;
        }

        return new ModelAndView("redirect:/weixin/admin/routePass.action");
    }

}