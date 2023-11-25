package com.devsuperior.springprofessional.desafios.desafio01.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Order {

    private Integer code;

    private BigDecimal basic  = BigDecimal.ZERO;

    private BigDecimal discount = BigDecimal.ZERO;
}
