package com.devsuperior.springprofessional.desafio.desafio03.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ClientDTOEntrada {

    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    private BigDecimal income;

    @PastOrPresent
    @NotNull
    private LocalDate birthDate;

    private Integer children;
}
