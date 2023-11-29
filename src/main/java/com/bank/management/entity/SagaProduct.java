package com.bank.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="SAGA_PRODUCTS_JPA")
public class SagaProduct {
    public SagaProduct(Long productId, String productName, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    @Id
    private Long productId;

    private String productName;
    private int quantity;
}

