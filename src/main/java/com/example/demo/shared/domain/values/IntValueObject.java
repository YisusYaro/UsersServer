package com.example.demo.shared.domain.values;

public abstract class IntValueObject {
  private int value;

  public IntValueObject(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
