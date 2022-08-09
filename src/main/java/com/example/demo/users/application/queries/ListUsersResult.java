package com.example.demo.users.application.queries;

import com.example.demo.shared.application.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListUsersResult implements Result {
  private Map<String, Object> map = new HashMap<>();

  public ListUsersResult(List<GetUserResult> userResults) {
    map.put("users", userResults.stream().map((result) -> {
      return result.get();
    }).collect(Collectors.toList()));
  }

  public Map<String, Object> get() {
    return this.map;
  }
}
