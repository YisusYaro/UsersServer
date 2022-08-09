package com.example.demo.users.application.queries;

import com.example.demo.shared.application.queries.QueryHandler;

public interface GetUserHandler extends QueryHandler<GetUserQuery, GetUserResult> {
  public GetUserResult handle(GetUserQuery command) throws Exception;
}
