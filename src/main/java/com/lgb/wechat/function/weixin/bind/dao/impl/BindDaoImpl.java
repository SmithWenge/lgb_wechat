package com.lgb.wechat.function.weixin.bind.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.lgb.wechat.function.weixin.bind.dao.BindDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BindDaoImpl implements BindDao {
    private final static Properties properties = new Properties();

    static {
        InputStream propertiesIn = BindDaoImpl.class.getResourceAsStream("/db/db.properties");

        try {
            properties.load(propertiesIn);

            propertiesIn.close();
            propertiesIn = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private JdbcTemplate jdbcTemplate = null;

    public BindDaoImpl() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.configFromPropety(properties);

        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public boolean selectExist(String userCardNum, String userWeixinId) {
        String sql = "SELECT COUNT(bindId) AS NUM FROM wechat_bind WHERE userWeixinId = ? AND userCardNum = ? AND deleteFlag = 0";
        Object[] args = {
                userWeixinId,
                userCardNum
        };

        try {
            return jdbcTemplate.queryForObject(sql, args, Integer.class) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insert(String userCardNum, String userWeixinId) {
        String sql = "INSERT INTO wechat_bind (userWeixinId, userCardNum) VALUES (?, ?)";
        Object[] args = {
                userWeixinId,
                userCardNum
        };

        try {
            return jdbcTemplate.update(sql, args) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String selectIsBind(String userWeixinId) {
        String sql = "SELECT userCardNum FROM wechat_bind WHERE userWeixinId = ? AND deleteFlag = 0";
        Object[] args = {
                userWeixinId
        };

        try {
            return jdbcTemplate.queryForObject(sql, args, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
