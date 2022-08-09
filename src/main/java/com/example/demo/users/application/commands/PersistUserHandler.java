package com.example.demo.users.application.commands;

import com.example.demo.shared.application.commands.CommandHandler;

public interface PersistUserHandler extends CommandHandler<PersistUserCommand> {
  public void handle(PersistUserCommand command) throws Exception;
}
