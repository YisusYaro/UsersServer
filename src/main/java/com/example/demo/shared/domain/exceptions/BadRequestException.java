package com.example.demo.shared.domain.exceptions;

public class BadRequestException extends Exception { 
  public BadRequestException(String errorMessage) {
      super(errorMessage);
  }
}