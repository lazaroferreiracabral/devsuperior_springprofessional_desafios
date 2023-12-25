package com.devsuperior.springprofessional.desafio.desafio03.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.internal.bytebuddy.asm.Advice;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ClientDTOSaida {

    private Long id;
    private String name;
    private String cpf;
    private BigDecimal income;
    private LocalDate birthDate;
    private Integer children;
}
