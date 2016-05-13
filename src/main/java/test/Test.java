package test;

import com.lgb.wechat.arc.mongodb.MongoTemplate;
import com.lgb.wechat.arc.mongodb.MongodbFactory;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static java.util.Arrays.asList;

public class Test {
    public static void main(String[] args) throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        mongoTemplate.insertOne("news2",
                new Document("address",
                        new Document()
                                .append("street", "2 Avenue")
                                .append("zipcode", "10075")
                                .append("building", "1480")
                                .append("coord", asList(-73.9557413, 40.7720266)))
                        .append("borough", "Manhattan")
                        .append("cuisine", "Italian")
                        .append("grades", asList(
                                new Document()
                                        .append("date", format.parse("2014-10-01T00:00:00Z"))
                                        .append("grade", "A")
                                        .append("score", 11),
                                new Document()
                                        .append("date", format.parse("2014-01-16T00:00:00Z"))
                                        .append("grade", "B")
                                        .append("score", 17)))
                        .append("name", "Vella")
                        .append("restaurant_id", "41704620"));
    }
}
