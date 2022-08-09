package com.example.demo.shared.infrastructure.EventBus;

import com.example.demo.shared.domain.events.Event;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventBusImpl implements EventBus {
  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void publish(Event event) {
    Map<String, Object> transmission = new HashMap<>();
    Map<String, Object> data = new HashMap<>();
    data.put("type", event.getName());
    data.put("occuredOn", event.getOccurredOn());
    data.put("id", event.getEventId());
    data.put("aggregateId", event.getAggregateId());
    data.put("attributes", event.toProperties());
    transmission.put("data", data);
    kafkaTemplate.send(event.getName(), new JSONObject(transmission).toString());
  }

}
