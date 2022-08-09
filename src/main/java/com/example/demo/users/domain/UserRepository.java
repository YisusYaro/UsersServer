package com.example.demo.users.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
  void save(User user);
  Optional<User> findById(String id);
  Optional<User> findByIdentifier(String identifier);
  Optional<User> findByEmail(String email);
  List<User> list();
}
