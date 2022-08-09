package com.example.demo.shared.infrastructure.repositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoClientFactory {
  static public MongoClient createAndConnect() {
    String uri = "mongodb://admin:password@mongo-container:27017/?maxPoolSize=20&w=majority";
    return MongoClients.create(uri);
  }
}