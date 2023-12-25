package com.devsuperior.springprofessional.desafio.desafio03.domain.repositories;

import com.devsuperior.springprofessional.desafio.desafio03.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
