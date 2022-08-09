package com.example.demo.users.application.commands;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.users.domain.UserFactory;
import com.example.demo.users.domain.UserRepository;
import com.example.demo.shared.domain.exceptions.BadRequestException;
import com.example.demo.shared.domain.values.IdGenerator;
import com.example.demo.shared.infrastructure.EventBus.EventBus;
import com.example.demo.users.domain.User;
import com.example.demo.users.domain.values.*;

@Component
public class RegisterUserHandlerImpl implements RegisterUserHandler {

  @Autowired
  UserFactory userFactory;

  @Autowired
  UserRepository userRepository;

  @Autowired
  IdGenerator idGenerator;

  @Autowired
  EventBus eventBus;

  public void handle(RegisterUserCommand command) throws Exception {

    Optional<User> userByIdentifier = this.userRepository.findByIdentifier(command.identifier);

    Optional<User> userByEmail = this.userRepository.findByEmail(command.email);

    if (userByIdentifier.isPresent() || userByEmail.isPresent())
      throw new BadRequestException("User already registered");

    User user = userFactory.create(
        new UserId(this.idGenerator.get()),
        new UserIdentifier(command.identifier),
        new UserPassword(command.password),
        new UserName(command.name),
        new UserLastName(command.lastName),
        new UserEmail(command.email));

    user.handleCreation();

    user.commit(this.eventBus);
    // this.userRepository.save(user);
  }
}
