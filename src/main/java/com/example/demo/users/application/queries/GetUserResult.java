package com.example.demo.users.application.queries;

import com.example.demo.shared.application.Result;

import java.util.HashMap;
import java.util.Map;

public class GetUserResult implements Result {
  private Map<String, Map<String, Object>> map = new HashMap<>();

  public GetUserResult(
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
      double eta) {
    Map<String, Object> user = new HashMap<>();
    user.put("id", id);
    user.put("identifier", identifier);
    user.put("password", password);
    user.put("name", name);
    user.put("lastName", lastName);
    user.put("email", email);
    user.put("age", age);
    user.put("height", height);
    user.put("weight", weight);
    user.put("imc", imc);
    user.put("geb", geb);
    user.put("eta", eta);
    this.map.put("user", user);
  }

  public Map<String, Map<String, Object>> get() {
    return this.map;
  }
}
