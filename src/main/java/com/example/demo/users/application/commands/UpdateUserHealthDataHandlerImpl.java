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
public class UpdateUserHealthDataHandlerImpl implements UpdateUserHealthDataHandler {

  @Autowired
  UserFactory userFactory;

  @Autowired
  UserRepository userRepository;

  @Autowired
  IdGenerator idGenerator;

  @Autowired
  EventBus eventBus;

  public void handle(UpdateUserHealthDataCommand command) throws Exception {

    Optional<User> userById = this.userRepository.findById(command.id);

    if (!userById.isPresent())
      throw new BadRequestException("User not found");

    User user = userById.get();

    user.updateHealthData(
        new UserAge(command.age),
        new UserHeight(command.height),
        new UserWeight(command.weight),
        new UserGeb(command.geb));

    user.commit(this.eventBus);
  }
}
