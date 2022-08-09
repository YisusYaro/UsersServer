package com.example.demo.users.application.queries;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.users.domain.UserRepository;
import com.example.demo.users.domain.User;

@Component
public class ListUsersHandlerImpl implements ListUsersHandler {

  @Autowired
  UserRepository userRepository;

  public ListUsersResult handle(ListUsersQuery query) throws Exception {
    List<User> users = this.userRepository.list();

    return new ListUsersResult(users.stream().map((user) -> {
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
    }).collect(Collectors.toList()));
  }
}
