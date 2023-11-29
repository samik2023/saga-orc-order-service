package com.bank.management.repository;

import com.bank.management.entity.SagaOrder;
import com.bank.management.entity.SagaProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SagaProductRepository extends JpaRepository<SagaProduct, Long> {


}
