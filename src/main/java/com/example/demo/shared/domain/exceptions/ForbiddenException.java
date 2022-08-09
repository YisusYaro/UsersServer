package com.example.demo.shared.domain.exceptions;

public class ForbiddenException extends Exception { 
  public ForbiddenException(String errorMessage) {
      super(errorMessage);
  }
}