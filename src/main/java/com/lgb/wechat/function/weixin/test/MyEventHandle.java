package com.lgb.wechat.function.weixin.test;

import com.github.sd4324530.fastweixin.handle.EventHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.req.BaseEvent;

public class MyEventHandle implements EventHandle {
    @Override
    public BaseMsg handle(BaseEvent event) {
        return null;
    }

    @Override
    public boolean beforeHandle(BaseEvent event) {
        return false;
    }
}
