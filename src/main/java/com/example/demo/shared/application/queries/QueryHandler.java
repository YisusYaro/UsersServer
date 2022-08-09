package com.example.demo.shared.application.queries;

import com.example.demo.shared.application.Query;
import com.example.demo.shared.application.Result;

public interface QueryHandler<Q extends Query, R extends Result> {
  R handle(Q query) throws Exception;
}
