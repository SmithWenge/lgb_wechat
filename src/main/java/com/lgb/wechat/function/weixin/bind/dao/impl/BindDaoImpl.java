package com.lgb.wechat.function.weixin.bind.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.DruidDataSourceUtils;
import com.lgb.wechat.function.weixin.bind.dao.BindDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
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

        try {
            dataSource.setDriverClassName(properties.getProperty("jdbc.driverClassName"));
            dataSource.setUrl(properties.getProperty("jdbc.url"));
            dataSource.setUsername(properties.getProperty("jdbc.username"));
            dataSource.setPassword(properties.getProperty("jdbc.password"));
            dataSource.setFilters(properties.getProperty("jdbc.filters"));
            dataSource.setInitialSize(Integer.parseInt(properties.getProperty("jdbc.initialSize")));
            dataSource.setMaxActive(Integer.parseInt(properties.getProperty("jdbc.maxActive")));
            dataSource.setMaxWait(Long.parseLong(properties.getProperty("jdbc.maxWait")));
            dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(properties.getProperty("jdbc.timeBetweenEvictionRunsMillis")));
            dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(properties.getProperty("jdbc.minEvictableIdleTimeMillis")));
            dataSource.setValidationQuery(properties.getProperty("jdbc.validationQuery"));
            dataSource.setTestWhileIdle(Boolean.parseBoolean(properties.getProperty("jdbc.testWhileIdle")));
            dataSource.setTestOnBorrow(Boolean.parseBoolean(properties.getProperty("jdbc.testOnBorrow")));
            dataSource.setTestOnReturn(Boolean.parseBoolean(properties.getProperty("jdbc.testOnReturn")));
            dataSource.setPoolPreparedStatements(Boolean.parseBoolean(properties.getProperty("jdbc.poolPreparedStatements")));
            dataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(properties.getProperty("jdbc.maxPoolPreparedStatementPerConnectionSize")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

    @Override
    public boolean selectWeixinId(String userWeixinId) {
        String sql = "SELECT COUNT(bindId) AS NUM FROM wechat_bind WHERE userWeixinId = ? AND deleteFlag = 0";
        Object[] args = {
                userWeixinId
        };

        try {
            return jdbcTemplate.queryForObject(sql, args, Integer.class) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean selectCardNum(String userCardNum) {
        String sql = "SELECT COUNT(bindId) AS NUM FROM wechat_bind WHERE userCardNum = ? AND deleteFlag = 0";
        Object[] args = {
                userCardNum
        };

        try {
            return jdbcTemplate.queryForObject(sql, args, Integer.class) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
