package com.bank.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="SAGA_ORDERS_JPA")
public class SagaOrder {


    public SagaOrder(Long orderId, Long productId, String userId, String status) {
        this.orderId = orderId;
        this.productId = productId;
        this.userId = userId;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long productId;
    private String userId;
    private String status;
}

