package com.example.demo.users.port;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.shared.port.Responser;
import com.example.demo.users.application.commands.RegisterUserCommand;
import com.example.demo.users.application.commands.RegisterUserHandler;
import com.example.demo.users.application.commands.UpdateUserHealthDataCommand;
import com.example.demo.users.application.commands.UpdateUserHealthDataHandler;
import com.example.demo.users.application.queries.GetUserHandler;
import com.example.demo.users.application.queries.GetUserQuery;
import com.example.demo.users.application.queries.ListUsersQuery;
import com.example.demo.users.application.queries.ListUsersHandler;

import java.util.Map;

@ConditionalOnExpression("#{!(systemProperties['producer.enable']?:'false').equals('true')}")
@RestController
class UsersController {

  @Autowired
  RegisterUserHandler registerUserHandler;

  @Autowired
  GetUserHandler getUserHandler;

  @Autowired
  ListUsersHandler listUsersHandler;

  @Autowired
  UpdateUserHealthDataHandler updateUserHealthDataHandler;

  @Autowired
  Responser responser;

  @PostMapping("/users")
  public ResponseEntity<Object> registerUser(@RequestBody Map<String, Object> payload) throws Exception {
    return responser.handleCommand(() -> {
      RegisterUserCommand command = new RegisterUserCommand(
          payload.get("identifier"),
          payload.get("password"),
          payload.get("name"),
          payload.get("lastName"),
          payload.get("email"));
      this.registerUserHandler.handle(command);
    });
  }

  @GetMapping("/users")
  public ResponseEntity<Object> listUsers() throws Exception {
    System.out.println(System.getenv("producer.enable"));
    return responser.handleQuery(() -> {
      ListUsersQuery query = new ListUsersQuery();
      return this.listUsersHandler.handle(query).get();
    });
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<Object> getUser(@PathVariable String id) throws Exception {
    return responser.handleQuery(() -> {
      GetUserQuery query = new GetUserQuery(id);
      return this.getUserHandler.handle(query).get();
    });
  }

  @PutMapping("/users/{id}/healthData")
  public ResponseEntity<Object> updateHealthData(@PathVariable String id, @RequestBody Map<String, Object> payload)
      throws Exception {
    return responser.handleCommand(() -> {
      UpdateUserHealthDataCommand command = new UpdateUserHealthDataCommand(
          id,
          payload.get("age"),
          payload.get("height"),
          payload.get("weight"),
          payload.get("geb"));
      this.updateUserHealthDataHandler.handle(command);
    });
  }
}