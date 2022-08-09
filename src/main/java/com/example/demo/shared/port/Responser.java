package com.example.demo.shared.port;


import org.springframework.http.ResponseEntity;

public interface Responser {
  public ResponseEntity<Object> handleCommand(CommandExecuter executer) throws Exception;
  public ResponseEntity<Object> handleQuery(QueryExecuter executer) throws Exception;
}