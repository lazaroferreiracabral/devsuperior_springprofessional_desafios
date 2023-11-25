package com.devsuperior.springprofessional.desafios.desafio01.domain.service;

import com.devsuperior.springprofessional.desafios.desafio01.domain.entities.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ShippingService {

    public BigDecimal shipment (Order order) {
        if (order.getBasic().compareTo(new BigDecimal(100))  < 0) {
            return new BigDecimal(20);
        } else if (order.getBasic().compareTo(new BigDecimal(200)) > 0) {
            return BigDecimal.ZERO;
        } else {
            return new BigDecimal(12);
        }
    }

}
