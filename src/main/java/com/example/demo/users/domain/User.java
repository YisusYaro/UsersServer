package com.example.demo.users.domain;

import com.example.demo.shared.infrastructure.EventBus.EventBus;
import com.example.demo.users.domain.values.UserAge;
import com.example.demo.users.domain.values.UserGeb;
import com.example.demo.users.domain.values.UserHeight;
import com.example.demo.users.domain.values.UserWeight;

public interface User {
  public String getId();

  public String getIdentifier();

  public String getPassword();

  public String getName();

  public String getLastName();

  public String getEmail();

  public int getAge();

  public double getHeight();

  public double getWeight();

  public double getImc();

  public double getGeb();

  public double getEta();

  public String getCreatedAt();

  public String getUpdatedAt();

  public void commit(EventBus eventBus);

  public void handleCreation();

  public void updateHealthData(
      UserAge age,
      UserHeight height,
      UserWeight weight,
      UserGeb geb);
}
