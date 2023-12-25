package com.devsuperior.springprofessional.desafio.desafio03.api.dto;

import com.devsuperior.springprofessional.desafio.desafio03.domain.entities.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientDTOSaidaTransformer {

    @Autowired
    private ModelMapper modelMapper;

    public ClientDTOSaida domainToDTOSaida (Client client) {
        return modelMapper.map(client, ClientDTOSaida.class);
    }

    public List<ClientDTOSaida> toCollectionDomainToDTOSaida (List<Client> clients) {
        return clients.stream()
                .map(c -> domainToDTOSaida(c))
                .collect(Collectors.toList());
    }
}
