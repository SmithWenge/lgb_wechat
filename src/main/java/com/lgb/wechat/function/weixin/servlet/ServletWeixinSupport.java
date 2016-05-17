package com.lgb.wechat.function.weixin.servlet;

import com.github.sd4324530.fastweixin.api.MediaAPI;
import com.github.sd4324530.fastweixin.api.MessageAPI;
import com.github.sd4324530.fastweixin.api.enums.MediaType;
import com.github.sd4324530.fastweixin.api.response.GetSendMessageResponse;
import com.github.sd4324530.fastweixin.api.response.UploadMediaResponse;
import com.github.sd4324530.fastweixin.message.*;
import com.github.sd4324530.fastweixin.message.req.MenuEvent;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.github.sd4324530.fastweixin.servlet.WeixinSupport;
import com.lgb.wechat.arc.util.constants.ConstantsCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;

public class ServletWeixinSupport extends WeixinSupport {
    private static final Logger LOG = LoggerFactory.getLogger(ServletWeixinSupport.class);

    @Override
    protected String getToken() {
        return "myToken";
    }


    @Override
    protected BaseMsg handleTextMsg(TextReqMsg msg) {
        String content = msg.getContent();

        if (LOG.isDebugEnabled())
            LOG.debug("用户发送到服务器的内容:{}", content);

        return new TextMsg("服务器回复用户消息!");
    }

    @Override
    protected BaseMsg handleMenuClickEvent(MenuEvent event) {
        String eventKey = event.getEventKey();

        if (eventKey.equals(ConstantsCollection.MENU_CJCX_KEY)) {
            Article article1 = new Article("文章消息测试标题1", "这是一个测试文章的描述1", "http://www.56team.com/photo/index/welcome001.jpg", "http://www.56team.com");
            Article article2 = new Article("文章消息测试标题2", "这是一个测试文章的描述2", "http://www.56team.com/photo/index/welcome001.jpg", "http://www.56team.com");
            return new NewsMsg(Arrays.asList(article1, article2));
        }

        return new TextMsg("你好");
    }

    private void sendCJCXMessage() {
//        MediaAPI mediaAPI = new MediaAPI(ConstantsCollection.APPCONFIG);
//        UploadMediaResponse response = mediaAPI.uploadMedia(MediaType.IMAGE, new File("/Users/liunaidi/Documents/tmp.png"));
//        String media_id = response.getMediaId();
//        Article article = new Article(media_id, "测试用户", "群发测试", "http://www.baidu.com", "群发测试", "群发测试", Article.ShowConverPic.NO);
//        UploadMediaResponse uploadMediaResponse = mediaAPI.uploadNews(Arrays.asList(article));
//        MpNewsMsg mpNewsMsg = new MpNewsMsg();
//        mpNewsMsg.setMediaId(uploadMediaResponse.getMediaId());
//        MessageAPI messageAPI = new MessageAPI(ConstantsCollection.APPCONFIG);
//        GetSendMessageResponse messageResponse = messageAPI.sendMessageToUser(mpNewsMsg, true, "0", null);
//        LOG.info("Send Message Id is " + messageResponse.getMsgId());
    }
}
