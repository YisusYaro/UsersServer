package com.example.demo.shared.infrastructure.repositories;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;

@Component
public abstract class MongoRepository {
  MongoClient client;
  String database;
  String collection;

  public MongoRepository(String collection) {
    this.client = MongoClientFactory.createAndConnect();
    this.database = System.getenv("DATABASE");
    this.collection = collection;
  }

  public MongoCollection<Document> getCollection() {
    return this.client.getDatabase(this.database).getCollection(this.collection);
  }

  public void persist(Bson id, Bson properties) {
    UpdateOptions options = new UpdateOptions().upsert(true);
    this.getCollection().updateOne(id, properties, options);
  }
}
