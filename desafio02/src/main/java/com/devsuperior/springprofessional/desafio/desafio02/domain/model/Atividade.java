package com.devsuperior.springprofessional.desafio.desafio02.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Table(name="tb_atividade")
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atividade {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "atividade")
    private Set<Bloco>  blocos = new HashSet<>();

    @ManyToMany
    @JoinTable(name= "tb_atividade_participante",
            joinColumns = @JoinColumn(name="atividade_id"),
            inverseJoinColumns = @JoinColumn(name="participante_id"))
    private Set<Participante> participantes = new HashSet<>();

}
