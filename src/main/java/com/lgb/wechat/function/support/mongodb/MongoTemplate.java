package com.lgb.wechat.function.support.mongodb;

import com.google.common.base.Optional;
import com.lgb.wechat.arc.util.constants.Constants;
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

    public MongoTemplate() {
        // TODO read from properties file
        init();
    }

    public MongoTemplate(String mongodbHost, String port, String mongodbDb) {
        client = new MongoClient(mongodbHost, Integer.parseInt(port));
        db = client.getDatabase(mongodbDb);
    }

    public void insertOne(String collection,Document document) {
        init();

        db.getCollection(collection).insertOne(document);

        client.close();
        client = null;
    }

    private void init() {
        if (!Optional.fromNullable(client).isPresent()) {
            client = new MongoClient(mongodbHost, Integer.parseInt(port));
            db = client.getDatabase(mongodbDb);
        }
    }

    public List<Document> find(String collectionName) {
        init();

        final List<Document> documents = new ArrayList<>();

        FindIterable<Document> iterable = db.getCollection(collectionName).find(new Document("articleDelete", Constants.DEFAULT_RECORD_NOT_DELETE));
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
        init();

        final List<Document> documents = new ArrayList<>();

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

    public List<Document> findSort(String collectionName, Document condition, Document sortDocument) {
        init();
        final List<Document> documents = new ArrayList<>();

        FindIterable<Document> iterable = db.getCollection(collectionName)
                .find(condition)
                .sort(sortDocument)
                .limit(Constants.DEFAULT_WEIXIN_RETURN_ARTICLE_NUM);

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
        init();

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
