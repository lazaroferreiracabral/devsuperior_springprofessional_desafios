package com.devsuperior.springprofessional.desafio.desafio03.api.dto;

import com.devsuperior.springprofessional.desafio.desafio03.domain.entities.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientDTOEntradaTransformer {

    @Autowired
    private ModelMapper modelMapper;

    public Client toDomainObject (ClientDTOEntrada clientDTOEntrada) {
        return modelMapper.map(clientDTOEntrada, Client.class);
    }

    public void copyToDomainObject (ClientDTOEntrada clientDTOEntrada, Client client) {
        modelMapper.map(clientDTOEntrada, client);
    }
}
