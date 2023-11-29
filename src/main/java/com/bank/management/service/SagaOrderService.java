package com.bank.management.service;

import com.bank.management.entity.Event;
import com.bank.management.entity.SagaOrder;
import com.bank.management.entity.SagaProduct;
import com.bank.management.messaging.SagaOrderEventProducer;
import com.bank.management.repository.SagaOrderRepository;
import com.bank.management.repository.SagaProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class SagaOrderService {

    @Autowired
    private SagaOrderRepository repository;
    @Autowired
    private SagaProductRepository productRepository;
    @Autowired
    private SagaOrderEventProducer eventProducer;

    public ResponseEntity<String> createOrder(SagaOrder o) {

        Optional<SagaProduct> product = productRepository.findById(o.getProductId());
        if (product.isPresent() && product.get().getQuantity() > 1) {
            product.get().setQuantity(product.get().getQuantity() - 1);
            productRepository.save(product.get());
            o.setStatus("PLACED");
            repository.save(o);
            Event event = new Event();
            event.setOrderId(o.getOrderId());
            event.setPhase("Order");
            event.setEventStatus("SUCCESS");
            initiateOrchestration(event);
        } else if (product.isPresent() && product.get().getQuantity() == 1) {
            product.get().setQuantity(product.get().getQuantity() - 1);
            productRepository.save(product.get());
            o.setStatus("PLACED");
            repository.save(o);
            Event event = new Event();
            event.setOrderId(o.getOrderId());
            event.setPhase("Order");
            event.setEventStatus("SUCCESS");
            initiateOrchestration(event);
        } else {
            o.setStatus("FAILED");
        }
        return new ResponseEntity<>("Order creation status : " + o.getStatus(), HttpStatus.OK);
    }

    public void initiateOrchestration(Event event) {
        eventProducer.createSuccessEvent(event);
    }

    public ResponseEntity<SagaOrder> updateOrder(Long orderId, String status) {
        Optional<SagaOrder> order = repository.findById(orderId);
        order.get().setStatus(status);
        repository.save(order.get());
        return new ResponseEntity<SagaOrder>(repository.save(order.get()), HttpStatus.OK);
    }
}