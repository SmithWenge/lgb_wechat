package com.lgb.wechat.function.weixin.test;

import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.req.BaseReqMsg;

public class MyMessageHandle implements MessageHandle {
    @Override
    public BaseMsg handle(BaseReqMsg message) {
        return null;
    }

    @Override
    public boolean beforeHandle(BaseReqMsg message) {
        return false;
    }
}
