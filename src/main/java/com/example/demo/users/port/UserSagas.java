package com.example.demo.users.port;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.users.application.commands.PersistUserCommand;
import com.example.demo.users.application.commands.PersistUserHandler;

@Component
class UsersSagas {
  @Autowired
  PersistUserHandler persistUserHandler;

  @KafkaListener(topics = {"userRegistered", "userHealthDataUpdated"}, groupId = "group_id")
  public void consume(ConsumerRecord<String, String> payload) throws Exception {
    JSONObject transmission = new JSONObject(payload.value());
    JSONObject data = transmission.getJSONObject("data");
    JSONObject attributes = data.getJSONObject("attributes");
    JSONObject user = attributes.getJSONObject("user");
    PersistUserCommand command = new PersistUserCommand(
        user.get("id"),
        user.get("identifier"),
        user.get("password"),
        user.get("name"),
        user.get("lastName"),
        user.get("email"),
        user.get("age"),
        user.get("height"),
        user.get("weight"),
        user.get("imc"),
        user.get("geb"),
        user.get("eta"),
        user.get("createdAt"),
        user.get("updatedAt"));
    this.persistUserHandler.handle(command);
  }
}