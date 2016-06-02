package com.lgb.wechat.function.login.service;

import com.lgb.wechat.function.login.AdminUser;

public interface LoginServiceI {
    boolean isLogin(AdminUser adminUser);
    boolean resetPassword(AdminUser adminUser);
}
