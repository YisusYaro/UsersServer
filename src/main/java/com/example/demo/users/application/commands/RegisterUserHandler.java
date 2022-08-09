package com.example.demo.users.application.commands;

import com.example.demo.shared.application.commands.CommandHandler;

public interface RegisterUserHandler extends CommandHandler<RegisterUserCommand> {
  public void handle(RegisterUserCommand command) throws Exception;
}
