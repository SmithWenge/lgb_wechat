package com.lgb.wechat.function.login.repository;

import com.lgb.wechat.function.login.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository implements LoginRepositoryI{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean selectAdminUser(AdminUser adminUser) {
        String sql = "SELECT COUNT(userName) AS NUM FROM wechat_user WHERE userName = ? AND userPass = ?";
        Object[] args = {
                adminUser.getUserName(),
                adminUser.getUserPass()
        };

        try {
            return jdbcTemplate.queryForObject(sql, args, Integer.class) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean resetPassword(AdminUser adminUser) {
        String sql = "UPDATE lgb_adminUser SET userPass = ? WHERE userName = ? AND uesrPass = ? ";
        Object[] args = {
                adminUser.getUesrPassNew(),
                adminUser.getUserName(),
                adminUser.getUserPass()

        };

        return jdbcTemplate.update(sql, args) == 1 ? true : false;
    }
}
