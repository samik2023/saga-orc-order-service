package com.bank.management;

import com.bank.management.entity.SagaOrder;
import com.bank.management.entity.SagaProduct;
import com.bank.management.repository.SagaOrderRepository;
import com.bank.management.repository.SagaProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;


@Slf4j
@SpringBootApplication
@EnableFeignClients
public class SagaOrderServiceApplication {

	@Autowired
	private SagaProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SagaOrderServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner run() throws Exception {

		return args -> {
			repository.deleteAll();
			SagaProduct a1 = new SagaProduct(1000l,"Television",5);
			SagaProduct a2 = new SagaProduct(2000l,"Mobile",5);
			SagaProduct a3 = new SagaProduct(3000l,"Shoe",5);
			SagaProduct a4 = new SagaProduct(4000l,"Watch",1);

			List<SagaProduct> products = Arrays.asList(a1,a2,a3,a4);
			repository.saveAll(products);
			log.info("Data initialization completed for saga products");
		};
	}
}
