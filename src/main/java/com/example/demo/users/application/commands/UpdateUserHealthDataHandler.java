package com.example.demo.users.application.commands;

import com.example.demo.shared.application.commands.CommandHandler;

public interface UpdateUserHealthDataHandler extends CommandHandler<UpdateUserHealthDataCommand> {
  public void handle(UpdateUserHealthDataCommand command) throws Exception;
}
