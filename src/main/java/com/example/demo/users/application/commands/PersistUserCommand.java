package com.example.demo.users.application.commands;

import com.example.demo.shared.application.Command;
import com.example.demo.shared.domain.exceptions.BadRequestException;
import com.example.demo.shared.port.Parser;

public class PersistUserCommand extends Command {
  public String id;
  public String identifier;
  public String password;
  public String name;
  public String lastName;
  public String email;
  public int age;
  public double height;
  public double weight;
  public double imc;
  public double geb;
  public double eta;
  public String createdAt;
  public String updatedAt;

  public PersistUserCommand(
      Object id,
      Object identifier,
      Object password,
      Object name,
      Object lastName,
      Object email,
      Object age,
      Object height,
      Object weight,
      Object imc,
      Object geb,
      Object eta,
      Object createdAt,
      Object updatedAt) throws Exception {
    this.validate(
        id,
        identifier,
        password,
        name,
        lastName,
        email,
        age,
        height,
        weight,
        imc,
        geb,
        eta,
        createdAt,
        updatedAt);
    this.id = Parser.parseString(id);
    this.identifier = Parser.parseString(identifier);
    this.password = Parser.parseString(password);
    this.name = Parser.parseString(name);
    this.lastName = Parser.parseString(lastName);
    this.email = Parser.parseString(email);
    this.age = Parser.parseInteger(age);
    this.height = Parser.parseDecimal(height);
    this.weight = Parser.parseDecimal(weight);
    this.imc = Parser.parseDecimal(imc);
    this.geb = Parser.parseDecimal(geb);
    this.eta = Parser.parseDecimal(eta);
    this.eta = Parser.parseDecimal(eta);
    this.createdAt = Parser.parseString(createdAt);
    this.updatedAt = Parser.parseString(updatedAt);
  }

  public void validate(
      Object id,
      Object identifier,
      Object password,
      Object name,
      Object lastName,
      Object email,
      Object age,
      Object height,
      Object weight,
      Object imc,
      Object geb,
      Object eta,
      Object createdAt,
      Object updatedAt

  ) throws Exception {
    if (id == null
        || identifier == null
        || password == null
        || name == null
        || lastName == null
        || email == null
        || age == null
        || height == null
        || weight == null
        || imc == null
        || geb == null
        || eta == null
        || createdAt == null
        || updatedAt == null)
      throw new BadRequestException("Bad request");
  }
}
