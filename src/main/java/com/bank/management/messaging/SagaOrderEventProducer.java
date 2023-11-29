package com.bank.management.messaging;

import com.bank.management.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SagaOrderEventProducer {
    @Autowired
    private KafkaTemplate<String, Event> kafkaTemplate;

    public void createSuccessEvent(Event txn) {

        kafkaTemplate.send("orderTopic", txn);
    }
}
