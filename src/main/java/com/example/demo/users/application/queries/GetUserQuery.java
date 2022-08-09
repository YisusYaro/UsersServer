package com.example.demo.users.application.queries;

import com.example.demo.shared.application.Query;
import com.example.demo.shared.domain.exceptions.BadRequestException;
import com.example.demo.shared.port.Parser;

public class GetUserQuery extends Query {
  public String id;

  public GetUserQuery(Object id) throws Exception {
    this.validate(id);
    this.id = Parser.parseString(id);
  }

  public void validate(Object id) throws Exception {
    if (id == null)
      throw new BadRequestException("Bad request");
  }
}
