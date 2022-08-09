package com.example.demo.shared.domain.values;

public abstract class StringValueObject {
  private String value;

  public StringValueObject(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
