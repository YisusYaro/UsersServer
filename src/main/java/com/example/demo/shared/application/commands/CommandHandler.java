package com.example.demo.shared.application.commands;

import com.example.demo.shared.application.Command;

public interface CommandHandler<C extends Command> {
  void handle(C command) throws Exception;
}
