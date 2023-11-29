package com.bank.management.repository;

import com.bank.management.entity.SagaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SagaOrderRepository extends JpaRepository<SagaOrder, Long> {

}
