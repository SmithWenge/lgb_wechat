package test;

//import com.github.sd4324530.fastweixin.util.JSONUtil;
import com.github.sd4324530.fastweixin.message.req.MenuEvent;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.lgb.wechat.arc.util.api.http.RQHttpRequest;
import com.lgb.wechat.arc.util.api.json.kc.RestNowStudentCourseInfo;
import com.lgb.wechat.arc.util.api.json.tq.TQSummary;
import com.lgb.wechat.arc.util.date.DateUtils;
import com.lgb.wechat.function.weixin.servlet.ServletWeixinSupport;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
        import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.joda.time.DateTime;

import java.io.BufferedReader;
        import java.io.InputStreamReader;
import java.util.List;

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

//        ServletWeixinSupport servletWeixinSupport = new ServletWeixinSupport();
//        MenuEvent event = new MenuEvent("zxjy");
//        servletWeixinSupport.getArticleMsg(event.getEventKey());

//        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
//        HttpGet get = new HttpGet("http://api.map.baidu.com/telematics/v3/weather?location=大连&output=json&ak=A2477172a606cd1d90253aa4d7f3285f");
//        get.setHeader("content-type", "application/json");
//        get.setHeader("Accept", "application/json");
//
//        CloseableHttpResponse response = closeableHttpClient.execute(get);
//        Gson gson = new GsonBuilder().create();
//        TQSummary TQSummary = gson.fromJson(new JsonReader(new BufferedReader(new InputStreamReader(response.getEntity().getContent()))), TQSummary.class);
//        System.out.println(TQSummary.toString());
//        closeableHttpClient.close();

//        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
//        HttpGet get = new HttpGet("http://api.map.baidu.com/telematics/v3/weather?location=大连&output=json&ak=A2477172a606cd1d90253aa4d7f3285f");
//        get.setHeader("content-type", "application/json");
//        get.setHeader("Accept", "application/json");
//
//        CloseableHttpResponse response = closeableHttpClient.execute(get);
//        Gson gson = new GsonBuilder().create();
//        TQSummary TQSummary = gson.fromJson(new JsonReader(new BufferedReader(new InputStreamReader(response.getEntity().getContent()))), TQSummary.class);
//        System.out.println(TQSummary.toString());
//        closeableHttpClient.close();

        /* 课程查询 */
//        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
//        HttpGet get = new HttpGet("http://139.129.6.189:8080/manage/api/course/200104.action");
//        get.setHeader("content-type", "application/json");
//        get.setHeader("Accept", "application/json");
//
//        get.setHeader("content-type", "application/json");
//        get.setHeader("Accept", "application/json");
//
//        CloseableHttpResponse response = closeableHttpClient.execute(get);
//        Gson gson = new GsonBuilder().create();
//        List<RestNowStudentCourseInfo> info = gson.fromJson(
//                new JsonReader(
//                        new BufferedReader(
//                                new InputStreamReader(
//                                        response.getEntity().getContent()))), new TypeToken<List<RestNowStudentCourseInfo>>(){}.getType());
//        closeableHttpClient.close();

//        System.out.println(DateTime.now().toString("YYYY-MM-dd"));
        ServletWeixinSupport weixinSupport = new ServletWeixinSupport();
        weixinSupport.handleTextMsg(new TextReqMsg("4:1980849329"));

//        String testDate = "20160503";
//        String date = testDate.substring(0, 4) + "-" + testDate.substring(4, 6) + "-" + testDate.substring(6, 8);
//        System.out.println(date);
//        System.out.println(RQHttpRequest.getDateInfo(DateUtils.dateFormat4Y2M2D(testDate)).toString());

    }
}
