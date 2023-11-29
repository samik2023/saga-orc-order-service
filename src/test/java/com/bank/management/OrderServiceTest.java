package com.bank.management;

import com.bank.management.entity.SagaOrder;
import com.bank.management.repository.SagaOrderRepository;
import com.bank.management.service.SagaOrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderServiceTest {

    @Mock
    private SagaOrderRepository orderRepository;

    @InjectMocks
    private SagaOrderService orderService = new SagaOrderService();

    @BeforeEach
    void setMockData() {
        List<SagaOrder> mockOrders = new ArrayList<>();
        mockOrders.add(new SagaOrder());
        when(orderRepository.findAll()).thenReturn(mockOrders);
    }

    @DisplayName("Test orderService and repository")
    @Test
    void testGetAllOrders() {
        assertEquals(1, orderService.getAllOrders().size());
    }
}
