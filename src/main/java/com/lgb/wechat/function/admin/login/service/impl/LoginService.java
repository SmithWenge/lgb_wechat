package com.lgb.wechat.function.admin.login.service.impl;

import com.lgb.wechat.function.admin.login.AdminUser;
import com.lgb.wechat.function.admin.login.repository.LoginRepositoryI;
import com.lgb.wechat.function.admin.login.service.LoginServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginServiceI {

    @Autowired
    private LoginRepositoryI loginRepository;

    @Override
    public boolean isLogin(AdminUser adminUser) {
        return loginRepository.selectAdminUser(adminUser);
    }

    @Override
    public boolean resetPassword(AdminUser adminUser) {
        return loginRepository.resetPassword(adminUser);
    }
}
