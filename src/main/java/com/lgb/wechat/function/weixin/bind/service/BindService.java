package com.lgb.wechat.function.weixin.bind.service;

public interface BindService {
    boolean bind(String userCardNum, String userWeixinId);
    String isBind(String userWeixinId);
}
