package com.lgb.wechat.function.user.bind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserBindingController {
    @RequestMapping("/route/bind")
    public String routeBind() {
        return "user/binding";
    }
}
