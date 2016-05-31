package com.lgb.wechat.function.weixin.bind.dao;

public interface BindDao {
    boolean selectExist(String userCardNum, String userWeixinId);
    boolean insert(String userCardNum, String userWeixinId);
    String selectIsBind(String userWeixinId);
    boolean selectWeixinId(String userWeixinId);
    boolean selectCardNum(String userCardNum);
}
