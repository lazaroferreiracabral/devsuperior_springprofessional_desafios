package com.devsuperior.springprofessional.desafios.desafio01.domain.service;

import com.devsuperior.springprofessional.desafios.desafio01.domain.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public BigDecimal total (Order order) {

        BigDecimal valorFrete = shippingService.shipment(order);
        BigDecimal valorDesconto = order.getBasic().multiply(order.getDiscount().divide(new BigDecimal(100)))
                                    .setScale(2, RoundingMode.HALF_UP);
        BigDecimal valorPedido = order.getBasic().subtract(valorDesconto);
        BigDecimal valorTotal = valorPedido.add(valorFrete);
        return valorTotal;
    }
}
