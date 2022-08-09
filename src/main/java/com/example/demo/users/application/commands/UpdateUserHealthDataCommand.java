package com.example.demo.users.application.commands;

import com.example.demo.shared.application.Command;
import com.example.demo.shared.domain.exceptions.BadRequestException;
import com.example.demo.shared.port.Parser;

public class UpdateUserHealthDataCommand extends Command {
  public String id;
  public int age;
  public double height;
  public double weight;
  public double geb;

  public UpdateUserHealthDataCommand(
      Object id,
      Object age,
      Object height,
      Object weight,
      Object geb) throws Exception {
    this.validate(
        id,
        age,
        height,
        weight,
        geb);
    this.id = Parser.parseString(id);
    this.age = Parser.parseInteger(age);
    this.height = Parser.parseDecimal(height);
    this.weight = Parser.parseDecimal(weight);
    this.geb = Parser.parseDecimal(geb);
  }

  public void validate(
      Object id,
      Object age,
      Object height,
      Object weight,
      Object geb) throws Exception {
    if (id == null
        || age == null
        || height == null
        || weight == null
        || geb == null)
      throw new BadRequestException("Bad request");
  }
}
