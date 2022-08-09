package com.example.demo.users.application.queries;

import com.example.demo.shared.application.queries.QueryHandler;

public interface ListUsersHandler extends QueryHandler<ListUsersQuery, ListUsersResult> {
  public ListUsersResult handle(ListUsersQuery command) throws Exception;
}
