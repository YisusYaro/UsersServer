package com.example.demo.users.infrastructure.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.shared.infrastructure.repositories.MongoRepository;
import com.example.demo.users.domain.User;
import com.example.demo.users.domain.UserFactory;
import com.example.demo.users.domain.UserRepository;
import com.example.demo.users.domain.values.UserAge;
import com.example.demo.users.domain.values.UserCreatedAt;
import com.example.demo.users.domain.values.UserEmail;
import com.example.demo.users.domain.values.UserEta;
import com.example.demo.users.domain.values.UserGeb;
import com.example.demo.users.domain.values.UserHeight;
import com.example.demo.users.domain.values.UserId;
import com.example.demo.users.domain.values.UserIdentifier;
import com.example.demo.users.domain.values.UserImc;
import com.example.demo.users.domain.values.UserLastName;
import com.example.demo.users.domain.values.UserName;
import com.example.demo.users.domain.values.UserPassword;
import com.example.demo.users.domain.values.UserUpdatedAt;
import com.example.demo.users.domain.values.UserWeight;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.Updates;

@Component
public class UserRepositoryImpl extends MongoRepository implements UserRepository {
  @Autowired
  UserFactory userFactory;

  public UserRepositoryImpl() {
    super("users");
    this.getCollection().createIndex(Indexes.ascending("identifier", "email"));
  }

  @Override
  public void save(User user) {
    this.persist(
        Filters.eq("_id", user.getId()),
        Updates.combine(
            Updates.set("_id", user.getId()),
            Updates.set("identifier", user.getIdentifier()),
            Updates.set("email", user.getEmail()),
            Updates.set("password", user.getPassword()),
            Updates.set("name", user.getName()),
            Updates.set("lastName", user.getLastName()),
            Updates.set("age", user.getAge()),
            Updates.set("height", user.getHeight()),
            Updates.set("weight", user.getWeight()),
            Updates.set("imc", user.getImc()),
            Updates.set("geb", user.getGeb()),
            Updates.set("eta", user.getEta()),
            Updates.set("createdAt", user.getCreatedAt()),
            Updates.set("updatedAt", user.getUpdatedAt())));
  }

  public Optional<User> findById(String id) {
    Document document = this.getCollection().find(Filters.eq("_id", id)).first();
    if (document == null)
      return Optional.empty();
    return Optional.of(this.documentToUser(document));
  }

  public Optional<User> findByIdentifier(String identifier) {
    Document document = this.getCollection().find(Filters.eq("identifier", identifier)).first();
    if (document == null)
      return Optional.empty();
    return Optional.of(this.documentToUser(document));
  }

  public Optional<User> findByEmail(String email) {
    Document document = this.getCollection().find(Filters.eq("email", email)).first();
    if (document == null)
      return Optional.empty();
    return Optional.of(this.documentToUser(document));
  }

  public List<User> list() {
    List<User> users = new ArrayList<User>();
    for (Document document : this.getCollection().find()) {
      users.add(this.documentToUser(document));
    }
    return users;
  }

  private User documentToUser(Document document) {
    return this.userFactory.reconstitute(
        new UserId(document.get("_id").toString()),
        new UserIdentifier(document.get("identifier").toString()),
        new UserPassword(document.get("password").toString()),
        new UserName(document.get("name").toString()),
        new UserLastName(document.get("lastName").toString()),
        new UserEmail(document.get("email").toString()),
        new UserAge((int) document.get("age")),
        new UserHeight((double) document.get("height")),
        new UserWeight((double) document.get("weight")),
        new UserImc((double) document.get("imc")),
        new UserGeb((double) document.get("geb")),
        new UserEta((double) document.get("eta")),
        new UserCreatedAt(document.get("createdAt").toString()),
        new UserUpdatedAt(document.get("updatedAt").toString()));
  }
}
