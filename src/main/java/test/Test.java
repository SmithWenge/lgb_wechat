package test;

import com.alibaba.fastjson.JSON;
import com.github.sd4324530.fastweixin.api.MediaAPI;
import com.github.sd4324530.fastweixin.api.MessageAPI;
import com.github.sd4324530.fastweixin.api.entity.Article;
import com.github.sd4324530.fastweixin.api.enums.MediaType;
import com.github.sd4324530.fastweixin.api.response.BaseResponse;
import com.github.sd4324530.fastweixin.api.response.GetSendMessageResponse;
import com.github.sd4324530.fastweixin.api.response.UploadMediaResponse;
import com.github.sd4324530.fastweixin.message.MpNewsMsg;
//import com.github.sd4324530.fastweixin.util.JSONUtil;
import com.github.sd4324530.fastweixin.message.req.MenuEvent;
import com.github.sd4324530.fastweixin.util.JSONUtil;
import com.lgb.wechat.arc.util.constants.ConstantsCollection;
import com.lgb.wechat.arc.util.date.DateUtils;
import com.lgb.wechat.function.support.mongodb.MongoTemplate;
import com.lgb.wechat.function.weixin.article.repository.WeixinArticleRepository;
import com.lgb.wechat.function.weixin.article.repository.impl.WeixinArticleRepositoryImpl;
import com.lgb.wechat.function.weixin.servlet.ServletWeixinSupport;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.github.sd4324530.fastweixin.util.JSONUtil.DEFAULT_FORMAT;
import static java.util.Arrays.asList;

public class Test {
    public static void main(String[] args) throws Exception {
//        MongoTemplate mongoTemplate = new MongoTemplate();
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
//        mongoTemplate.insertOne("news2",
//                new Document("address",
//                        new Document()
//                                .append("street", "2 Avenue")
//                                .append("zipcode", "10075")
//                                .append("building", "1480")
//                                .append("coord", asList(-73.9557413, 40.7720266)))
//                        .append("borough", "Manhattan")
//                        .append("cuisine", "Italian")
//                        .append("grades", asList(
//                                new Document()
//                                        .append("date", format.parse("2014-10-01T00:00:00Z"))
//                                        .append("grade", "A")
//                                        .append("score", 11),
//                                new Document()
//                                        .append("date", format.parse("2014-01-16T00:00:00Z"))
//                                        .append("grade", "B")
//                                        .append("score", 17)))
//                        .append("name", "Vella")
//                        .append("restaurant_id", "41704620"));

//        MongoClient client = new MongoClient("localhost", 27017);
//        MongoDatabase db = client.getDatabase("test");
//        FindIterable<Document> iterable = db.getCollection("zsjz").find();
//        iterable.forEach(new Block<Document>() {
//            @Override
//            public void apply(Document document) {
//                System.out.println(document.get("articleTitle"));
//            }
//        });
//        client.close();

//        System.out.println(DateUtils.nowYMD());

//        MediaAPI mediaAPI = new MediaAPI(ConstantsCollection.APPCONFIG);
//        UploadMediaResponse response = mediaAPI.uploadMedia(MediaType.IMAGE, new File("/Users/liunaidi/Documents/1.png"));
//        String media_id = response.getMediaId();
//        Article article = new Article(media_id, "测试用户", "群发测试", "http://www.baidu.com", "群发测试", "群发测试", Article.ShowConverPic.NO);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("articles", Arrays.asList(article));
//        System.out.println(JSONUtil.toJson(map));
//
//        UploadMediaResponse uploadMediaResponse = mediaAPI.uploadNews(Arrays.asList(article));
//        MpNewsMsg mpNewsMsg = new MpNewsMsg();
//        mpNewsMsg.setMediaId(uploadMediaResponse.getMediaId());
//        MessageAPI messageAPI = new MessageAPI(ConstantsCollection.APPCONFIG);
//        GetSendMessageResponse messageResponse = messageAPI.sendMessageToUser(mpNewsMsg, true, "0", null);
//        System.out.println("Send Message Id is " + messageResponse.getMsgId());

        ServletWeixinSupport servletWeixinSupport = new ServletWeixinSupport();
        MenuEvent event = new MenuEvent("zxjy");
//        servletWeixinSupport.getArticleMsg(event.getEventKey());

    }
}
