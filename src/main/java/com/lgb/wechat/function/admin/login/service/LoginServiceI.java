package com.lgb.wechat.function.admin.login.service;

import com.lgb.wechat.function.admin.login.AdminUser;

public interface LoginServiceI {
    boolean isLogin(AdminUser adminUser);
    boolean resetPassword(AdminUser adminUser);
}
