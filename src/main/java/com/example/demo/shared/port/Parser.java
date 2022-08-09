package com.example.demo.shared.port;

import org.springframework.stereotype.Component;

import com.example.demo.shared.domain.exceptions.BadRequestException;

@Component
public class Parser {
  public static String parseString(Object value) throws Exception {
    try {
      return (String) value;
    } catch (Exception e) {
      throw new BadRequestException(String.format("%s is not string", value));
    }
  }

  public static int parseInteger(Object value) throws Exception {
    try {
      return (int) value;
    } catch (Exception e) {
      throw new BadRequestException(String.format("%s is not integer", value));
    }
  }

  public static double parseDecimal(Object value) throws Exception {
    try {
      return new Double(value.toString());
    } catch (Exception e) {
      throw new BadRequestException(String.format("%s is not decimal", value));
    }
  }
}
