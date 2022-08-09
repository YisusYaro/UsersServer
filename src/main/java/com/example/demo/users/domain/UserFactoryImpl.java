package com.example.demo.users.domain;

import org.springframework.stereotype.Component;

import com.example.demo.users.domain.values.*;

@Component
public class UserFactoryImpl implements UserFactory {

  public UserImplementation create(
      UserId id,
      UserIdentifier identifier,
      UserPassword password,
      UserName name,
      UserLastName lastName,
      UserEmail email) {
    return new UserImplementation(
        id,
        identifier,
        password,
        name,
        lastName,
        email);
  }

  public UserImplementation reconstitute(
      UserId id,
      UserIdentifier identifier,
      UserPassword password,
      UserName name,
      UserLastName lastName,
      UserEmail email,
      UserAge age,
      UserHeight height,
      UserWeight weight,
      UserImc imc,
      UserGeb geb,
      UserEta eta,
      UserCreatedAt createdAt,
      UserUpdatedAt updatedAt) {
    UserImplementation user = this.create(
        id,
        identifier,
        password,
        name,
        lastName,
        email);
    user.setAge(age);
    user.setHeight(height);
    user.setWeight(weight);
    user.setImc(imc);
    user.setGeb(geb);
    user.setEta(eta);
    user.setCreatedAt(createdAt);
    user.setUpdatedAt(updatedAt);
    return user;
  }

}
