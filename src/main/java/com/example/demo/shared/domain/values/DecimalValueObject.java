package com.example.demo.shared.domain.values;

public abstract class DecimalValueObject {
  private double value;

  public DecimalValueObject(double value) {
    this.value = value;
  }

  public double getValue() {
    return value;
  }
}
