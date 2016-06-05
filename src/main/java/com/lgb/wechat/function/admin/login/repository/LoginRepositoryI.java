package com.lgb.wechat.function.admin.login.repository;

import com.lgb.wechat.function.admin.login.AdminUser;

public interface LoginRepositoryI {
    boolean selectAdminUser(AdminUser adminUser);
    boolean resetPassword(AdminUser adminUser);
}
