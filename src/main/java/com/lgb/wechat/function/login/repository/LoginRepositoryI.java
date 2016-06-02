package com.lgb.wechat.function.login.repository;

import com.lgb.wechat.function.login.AdminUser;

public interface LoginRepositoryI {
    boolean selectAdminUser(AdminUser adminUser);
    boolean resetPassword(AdminUser adminUser);
}
