package com.example.demo.shared.infrastructure.IdGenerator;

import org.springframework.stereotype.Component;

import com.example.demo.shared.domain.values.IdGenerator;
import com.github.f4b6a3.ulid.UlidCreator;

@Component
public class IdGeneratorImpl implements IdGenerator {
  public String get() {
    return UlidCreator.getUlid().toString();
  }
}
