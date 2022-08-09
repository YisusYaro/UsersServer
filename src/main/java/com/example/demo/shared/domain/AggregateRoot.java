package com.example.demo.shared.domain;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.shared.domain.events.Event;
import com.example.demo.shared.infrastructure.EventBus.EventBus;

public abstract class AggregateRoot {
  protected List<Event> events;

  public AggregateRoot() {
    this.events = new ArrayList<Event>();
  }

  public void record(Event event) {
    this.events.add(event);
  }

  public void commit(EventBus eventBus) {
    this.events.forEach((event) -> {
      eventBus.publish(event);
    });

    this.events.clear();
  }
}
