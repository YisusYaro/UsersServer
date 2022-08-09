package com.example.demo.shared.port;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.shared.domain.exceptions.BadRequestException;
import com.example.demo.shared.domain.exceptions.ForbiddenException;
import com.example.demo.shared.domain.exceptions.NotFoundException;
import com.example.demo.shared.domain.exceptions.UnauthorizedException;

@Component
public class ResponserImpl implements Responser {
  public ResponseEntity<Object> handleCommand(CommandExecuter executer) {
    try {
      executer.execute();
      Map<String, Object> map = new HashMap<>();
      map.put("Cve_Mensaje", "Succesfull");
      return new ResponseEntity<>(map, HttpStatus.OK);
    } catch (Exception exception) {
      Map<String, Object> map = new HashMap<>();
      map.put("Cve_Error", exception.getMessage());

      if (exception instanceof BadRequestException) {
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
      } else if (exception instanceof UnauthorizedException) {
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
      } else if (exception instanceof ForbiddenException) {
        return new ResponseEntity<>(map, HttpStatus.FORBIDDEN);
      } else if (exception instanceof NotFoundException) {
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public ResponseEntity<Object> handleQuery(QueryExecuter executer) {
    try {
      Object result = executer.execute();
      Map<String, Object> map = new HashMap<>();
      map.put("Cve_Mensaje", "Succesfull");
      map.put("result", result);
      return new ResponseEntity<>(map, HttpStatus.OK);
    } catch (Exception exception) {
      Map<String, Object> map = new HashMap<>();
      map.put("Cve_Error", exception.getMessage());

      if (exception instanceof BadRequestException) {
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
      } else if (exception instanceof UnauthorizedException) {
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
      } else if (exception instanceof ForbiddenException) {
        return new ResponseEntity<>(map, HttpStatus.FORBIDDEN);
      } else if (exception instanceof NotFoundException) {
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}