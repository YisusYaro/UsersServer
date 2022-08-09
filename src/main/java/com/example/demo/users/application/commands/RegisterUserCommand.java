package com.example.demo.users.application.commands;

import com.example.demo.shared.application.Command;
import com.example.demo.shared.domain.exceptions.BadRequestException;
import com.example.demo.shared.port.Parser;

public class RegisterUserCommand extends Command {
  public String identifier;
  public String password;
  public String name;
  public String lastName;
  public String email;

  public RegisterUserCommand(
      Object identifier,
      Object password,
      Object name,
      Object lastName,
      Object email) throws Exception {
    this.validate(
        identifier,
        password,
        name,
        lastName,
        email);
    this.identifier = Parser.parseString(identifier);
    this.password = Parser.parseString(password);
    this.name = Parser.parseString(name);
    this.lastName = Parser.parseString(lastName);
    this.email = Parser.parseString(email);
  }

  public void validate(
      Object identifier,
      Object password,
      Object name,
      Object lastName,
      Object email) throws Exception {
    if (identifier == null
        || password == null
        || name == null
        || lastName == null
        || email == null)
      throw new BadRequestException("Bad request");
  }
}
