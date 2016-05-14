package com.lgb.wechat.function.support.mongodb;

import com.lgb.wechat.arc.util.constants.ConstantsCollection;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoTemplate {
    private String mongodbHost = "127.0.0.1";
    private String port = "27017";
    private String mongodbDb = "test";

    private MongoClient client = null;
    private MongoDatabase db = null;

    public MongoTemplate(String mongodbHost, String port, String mongodbDb) {
        client = new MongoClient(mongodbHost, Integer.valueOf(port));
        db = client.getDatabase(mongodbDb);
    }

    public void insertOne(String collection,Document document) {
        client = new MongoClient(mongodbHost, Integer.valueOf(port));
        db = client.getDatabase(mongodbDb);

        db.getCollection(collection).insertOne(document);

        client.close();
        client = null;
    }

    public List<Document> find(String collectionName) {
        final List<Document> documents = new ArrayList<>();

        client = new MongoClient(mongodbHost, Integer.valueOf(port));
        db = client.getDatabase(mongodbDb);

        FindIterable<Document> iterable = db.getCollection(collectionName).find(new Document("articleDelete", ConstantsCollection.DEFAULT_RECORD_NOT_DELETE));
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                documents.add(document);
            }
        });

        client.close();
        client = null;
        return documents;
    }

    public List<Document> find(String collectionName, Document document) {
        final List<Document> documents = new ArrayList<>();

        client = new MongoClient(mongodbHost, Integer.valueOf(port));
        db = client.getDatabase(mongodbDb);

        FindIterable<Document> iterable = db.getCollection(collectionName).find(document);
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                documents.add(document);
            }
        });

        client.close();
        client = null;
        return documents;
    }

    public long updateOne(String collectionName, Document condition, Document document) {
        client = new MongoClient(mongodbHost, Integer.valueOf(port));
        db = client.getDatabase(mongodbDb);

        UpdateResult result = db.getCollection(collectionName).updateOne(condition, document);

        client.close();
        client = null;
        return result.getModifiedCount();
    }

    public void setMongodbHost(String mongodbHost) {
        this.mongodbHost = mongodbHost;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setMongodbDb(String mongodbDb) {
        this.mongodbDb = mongodbDb;
    }

    public String getMongodbHost() {

        return mongodbHost;
    }

    public String getPort() {
        return port;
    }

    public String getMongodbDb() {
        return mongodbDb;
    }
}
