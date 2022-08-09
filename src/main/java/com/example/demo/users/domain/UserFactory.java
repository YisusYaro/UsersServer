package com.example.demo.users.domain;

import com.example.demo.users.domain.values.*;

public interface UserFactory {
  public User create(
      UserId id,
      UserIdentifier identifier,
      UserPassword password,
      UserName name,
      UserLastName lastName,
      UserEmail email);

  public User reconstitute(
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
      UserUpdatedAt updatedAt
      );
}
