package com.lgb.wechat.function.login.service;

import com.lgb.wechat.function.login.AdminUser;
import com.lgb.wechat.function.login.repository.LoginRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginServiceI{

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
