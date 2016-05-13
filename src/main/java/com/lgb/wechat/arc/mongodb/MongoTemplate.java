package com.lgb.wechat.arc.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoTemplate {
    private MongoClient client = null;
    private MongoDatabase db = null;

    public MongoTemplate() {
        client = MongodbFactory.getClientInstance();
        db = client.getDatabase(MongodbFactory.getDb());
    }

    public void insertOne(String collection,Document document) {
        db.getCollection(collection).insertOne(document);
        destroy();
    }

    private void destroy() {
        client.close();
    }
}
