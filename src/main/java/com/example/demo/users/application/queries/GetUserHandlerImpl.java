package com.example.demo.users.application.queries;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.users.domain.UserRepository;
import com.example.demo.shared.domain.exceptions.NotFoundException;
import com.example.demo.users.domain.User;

@Component
public class GetUserHandlerImpl implements GetUserHandler {

  @Autowired
  UserRepository userRepository;

  public GetUserResult handle(GetUserQuery query) throws Exception {

    Optional<User> userById = this.userRepository.findById(query.id);

    if (!userById.isPresent())
      throw new NotFoundException("User not found");

    User user = userById.get();

    return new GetUserResult(
        user.getId(),
        user.getIdentifier(),
        user.getPassword(),
        user.getName(),
        user.getLastName(),
        user.getEmail(),
        user.getAge(),
        user.getHeight(),
        user.getWeight(),
        user.getImc(),
        user.getGeb(),
        user.getEta());
  }
}
