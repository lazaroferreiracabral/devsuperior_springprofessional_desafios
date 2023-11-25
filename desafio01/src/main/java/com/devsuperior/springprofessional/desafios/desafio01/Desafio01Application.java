package com.devsuperior.springprofessional.desafios.desafio01;

import com.devsuperior.springprofessional.desafios.desafio01.domain.entities.Order;
import com.devsuperior.springprofessional.desafios.desafio01.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Locale;

@SpringBootApplication
public class Desafio01Application implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {

		SpringApplication.run(Desafio01Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
        Locale.setDefault(Locale.US);
		Order order1 = new Order(1034, new BigDecimal(150), new BigDecimal(20));
        System.out.println("Exemplo 1");
		System.out.printf("Pedido código: %d%n", order1.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order1));
		System.out.println();

		Order order2 = new Order(2282, new BigDecimal(800), new BigDecimal(10));
        System.out.println("Exemplo 2");
        System.out.printf("Pedido código: %d%n", order2.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order2));
		System.out.println();

		Order order3 = new Order(1309, new BigDecimal(95.9), BigDecimal.ZERO);
        System.out.println("Exemplo 3");
		System.out.printf("Pedido código: %d%n", order3.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order3));
		System.out.println();
	}
}
