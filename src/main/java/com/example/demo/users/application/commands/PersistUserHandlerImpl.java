package com.example.demo.users.application.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.users.domain.UserFactory;
import com.example.demo.users.domain.UserRepository;
import com.example.demo.shared.infrastructure.EventBus.EventBus;
import com.example.demo.users.domain.User;
import com.example.demo.users.domain.values.*;

@Component
public class PersistUserHandlerImpl implements PersistUserHandler {

  @Autowired
  UserFactory userFactory;

  @Autowired
  UserRepository userRepository;

  @Autowired
  EventBus eventBus;

  public void handle(PersistUserCommand command) throws Exception {
    User user = userFactory.reconstitute(
        new UserId(command.id),
        new UserIdentifier(command.identifier),
        new UserPassword(command.password),
        new UserName(command.name),
        new UserLastName(command.lastName),
        new UserEmail(command.email),
        new UserAge(command.age),
        new UserHeight(command.height),
        new UserWeight(command.weight),
        new UserImc(command.imc),
        new UserGeb(command.geb),
        new UserEta(command.eta),
        new UserCreatedAt(command.createdAt),
        new UserUpdatedAt(command.updatedAt) 
        );

    user.commit(this.eventBus);
    this.userRepository.save(user);
  }
}
