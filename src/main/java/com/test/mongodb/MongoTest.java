package com.test.mongodb;

import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/9/18 16:49
 */
public class MongoTest {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://192.168.232.128:27017")).
                        build());
        MongoDatabase test = mongoClient.getDatabase("mydb");
//        test.createCollection("member");
        MongoCollection<Document> collection = test.getCollection("member");
        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));
//        collection.insertOne(doc);
        FindIterable<Document> documents = collection.find(Filters.eq("name", "MongoDB"));
        documents.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        });
//        ListCollectionsIterable<Document> documents = test.listCollections();
//        MongoCursor<Document> iterator = documents.iterator();
//        while (iterator.hasNext()) {
//            System.out.println("值:" + iterator.next());
//        }
    }
}
