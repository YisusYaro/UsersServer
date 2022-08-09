package com.example.demo.shared.domain.exceptions;

public class NotFoundException extends Exception { 
  public NotFoundException(String errorMessage) {
      super(errorMessage);
  }
}