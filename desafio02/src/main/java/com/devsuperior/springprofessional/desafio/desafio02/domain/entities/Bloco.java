package com.devsuperior.springprofessional.desafio.desafio02.domain.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(name="tb_bloco")
public class Bloco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private Instant inicio;

    private Instant fim;

    @ManyToOne
    @JoinColumn(name="atividade_id")
    private Atividade atividade;
}
