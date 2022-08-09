package com.example.demo.shared.infrastructure.EventBus;

import com.example.demo.shared.domain.events.Event;

public interface EventBus {
  public void publish(Event event);
}
