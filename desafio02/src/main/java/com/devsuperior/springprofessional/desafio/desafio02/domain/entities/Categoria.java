package com.devsuperior.springprofessional.desafio.desafio02.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Table(name="tb_categoria")
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private Set<Atividade> atividades = new HashSet<>();
}
