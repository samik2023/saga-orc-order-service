package com.bank.management.controller;

import com.bank.management.entity.SagaOrder;
import com.bank.management.service.SagaOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/api/orders")
public class SagaOrderController {

    @Autowired
    SagaOrderService service;

    @PostMapping(value = "/createOrder",
            produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addOrder(@RequestBody SagaOrder order) {
        ResponseEntity<String> response = service.createOrder(order);
        return response;
    }

    @PostMapping(value = "/updateOrder/{orderId}/{status}",
            produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<SagaOrder> updateOrder(@PathVariable Long orderId,
                                                 @PathVariable String status) {
        return service.updateOrder(orderId, status);
    }

    /*@PostMapping(value = "/cancelOrder/{orderId}/{status}",
            produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<SagaOrder> cancelOrder(@PathVariable Long orderId,
                                                 @PathVariable String status) {
        return service.updateOrder(orderId, status);
    }*/
}
