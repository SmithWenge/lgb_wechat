# Project Information

### MySQL Config
```
CREATE SCHEMA `lgb_wechat` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'lgbwechat'@'localhost' IDENTIFIED BY 'lgbwechat';
GRANT ALL PRIVILEGES ON lgb_wechat.* TO 'lgbwechat'@'localhost' WITH GRANT OPTION;
```

### maven build project
- run porject
```
mvn clean tomcat7:run
```
- clean project
```
mvn clean
```

### 微信接口账号
```
samuelbean@163/xiao5622498B
```