package com.example.demo.users.domain.events;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.shared.domain.events.Event;

public class UserRegisteredEvent extends Event {
  private static String EVENT_NAME = "userRegistered";
  private String id;
  private String identifier;
  private String password;
  private String name;
  private String lastName;
  private String email;
  private int age;
  private double height;
  private double weight;
  private double imc;
  private double geb;
  private double eta;
  private String createdAt;
  private String updatedAt;

  public UserRegisteredEvent(
      String id,
      String identifier,
      String password,
      String name,
      String lastName,
      String email,
      int age,
      double height,
      double weight,
      double imc,
      double geb,
      double eta,
      String createdAt,
      String updatedAt) {
    super(id, UserRegisteredEvent.EVENT_NAME);
    this.id = id;
    this.identifier = identifier;
    this.password = password;
    this.name = name;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
    this.height = height;
    this.weight = weight;
    this.imc = imc;
    this.geb = geb;
    this.eta = eta;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  @Override
  public Map<String, Object> toProperties() {
    Map<String, Object> map = new HashMap<>();
    Map<String, Object> user = new HashMap<>();
    user.put("id", this.id);
    user.put("identifier", this.identifier);
    user.put("password", this.password);
    user.put("name", this.name);
    user.put("lastName", this.lastName);
    user.put("email", this.email);
    user.put("age", this.age);
    user.put("height", this.height);
    user.put("weight", this.weight);
    user.put("imc", this.imc);
    user.put("geb", this.geb);
    user.put("eta", this.eta);
    user.put("createdAt", this.createdAt);
    user.put("updatedAt", this.updatedAt);
    map.put("user", user);
    return map;
  }

}
