package com.example.demo.users.domain;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.example.demo.shared.domain.AggregateRoot;
import com.example.demo.shared.domain.events.Event;
import com.example.demo.users.domain.events.UserHealthDataUpdatedEvent;
import com.example.demo.users.domain.events.UserRegisteredEvent;
import com.example.demo.users.domain.values.*;

public class UserImplementation extends AggregateRoot implements User {
  private UserId id;
  private UserIdentifier identifier;
  private UserPassword password;
  private UserName name;
  private UserLastName lastName;
  private UserEmail email;
  private UserAge age = new UserAge(0);
  private UserHeight height = new UserHeight(0.0);
  private UserWeight weight = new UserWeight(0.0);
  private UserImc imc = new UserImc(0.0);
  private UserGeb geb = new UserGeb(0.0);
  private UserEta eta = new UserEta(0.0);
  private UserCreatedAt createdAt = new UserCreatedAt(
      ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT));
  private UserUpdatedAt updatedAt = new UserUpdatedAt(
      ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT));

  public UserImplementation(
      UserId id,
      UserIdentifier identifier,
      UserPassword password,
      UserName name,
      UserLastName lastName,
      UserEmail email) {
    this.id = id;
    this.identifier = identifier;
    this.password = password;
    this.name = name;
    this.lastName = lastName;
    this.email = email;
  }

  public void setAge(UserAge age) {
    this.age = age;
  }

  public void setHeight(UserHeight height) {
    this.height = height;
  }

  public void setWeight(UserWeight weight) {
    this.weight = weight;
  }

  public void setImc(UserImc imc) {
    this.imc = imc;
  }

  public void setGeb(UserGeb geb) {
    this.geb = geb;
  }

  public void setEta(UserEta eta) {
    this.eta = eta;
  }

  public void setCreatedAt(UserCreatedAt createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(UserUpdatedAt updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return this.id.getValue();
  }

  public String getIdentifier() {
    return this.identifier.getValue();
  }

  public String getPassword() {
    return this.password.getValue();
  }

  public String getName() {
    return this.name.getValue();
  }

  public String getLastName() {
    return this.lastName.getValue();
  }

  public String getEmail() {
    return this.email.getValue();
  }

  public int getAge() {
    return this.age.getValue();
  }

  public double getHeight() {
    return this.height.getValue();
  }

  public double getWeight() {
    return this.weight.getValue();
  }

  public double getImc() {
    return this.imc.getValue();
  }

  public double getGeb() {
    return this.geb.getValue();
  }

  public double getEta() {
    return this.eta.getValue();
  }

  public String getCreatedAt() {
    return this.createdAt.getValue();
  }

  public String getUpdatedAt() {
    return this.updatedAt.getValue();
  }

  public void handleCreation() {
    Event event = new UserRegisteredEvent(
        this.id.getValue(),
        this.identifier.getValue(),
        this.password.getValue(),
        this.name.getValue(),
        this.lastName.getValue(),
        this.email.getValue(),
        this.age.getValue(),
        this.height.getValue(),
        this.weight.getValue(),
        this.imc.getValue(),
        this.geb.getValue(),
        this.eta.getValue(),
        this.createdAt.getValue(),
        this.updatedAt.getValue());

    this.record(event);
  }

  public void updateHealthData(
      UserAge age,
      UserHeight height,
      UserWeight weight,
      UserGeb geb) {

    this.age = age;
    this.height = height;
    this.weight = weight;
    this.geb = geb;
    Event event = new UserHealthDataUpdatedEvent(
        this.id.getValue(),
        this.identifier.getValue(),
        this.password.getValue(),
        this.name.getValue(),
        this.lastName.getValue(),
        this.email.getValue(),
        this.age.getValue(),
        this.height.getValue(),
        this.weight.getValue(),
        this.imc.getValue(),
        this.geb.getValue(),
        this.eta.getValue(),
        this.createdAt.getValue(),
        this.updatedAt.getValue());
    this.record(event);
  }
}
