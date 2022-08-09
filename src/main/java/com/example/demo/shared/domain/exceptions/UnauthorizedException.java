package com.example.demo.shared.domain.exceptions;

public class UnauthorizedException extends Exception { 
  public UnauthorizedException(String errorMessage) {
      super(errorMessage);
  }
}