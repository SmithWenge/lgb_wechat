package com.lgb.wechat.function.weixin.bind.service.impl;

import com.lgb.wechat.function.weixin.bind.dao.BindDao;
import com.lgb.wechat.function.weixin.bind.dao.impl.BindDaoImpl;
import com.lgb.wechat.function.weixin.bind.service.BindService;

public class BindServiceImpl implements BindService {
    private BindDao bindDao = null;

    public BindServiceImpl() {
        bindDao = new BindDaoImpl();
    }

    @Override
    public boolean bind(String userCardNum, String userWeixinId) {
        if (bindDao.selectExist(userCardNum, userWeixinId)) {
            return false;
        } else {
            return bindDao.insert(userCardNum, userWeixinId);
        }
    }

    @Override
    public String isBind(String userWeixinId) {
        return bindDao.selectIsBind(userWeixinId);
    }
}
