package com.devsuperior.springprofessional.desafio.desafio03.domain.services;


import com.devsuperior.springprofessional.desafio.desafio03.api.dto.ClientDTOEntrada;
import com.devsuperior.springprofessional.desafio.desafio03.api.dto.ClientDTOEntradaTransformer;
import com.devsuperior.springprofessional.desafio.desafio03.api.dto.ClientDTOSaida;
import com.devsuperior.springprofessional.desafio.desafio03.api.dto.ClientDTOSaidaTransformer;
import com.devsuperior.springprofessional.desafio.desafio03.domain.entities.Client;
import com.devsuperior.springprofessional.desafio.desafio03.domain.repositories.ClientRepository;
import com.devsuperior.springprofessional.desafio.desafio03.domain.services.exception.DatabaseException;
import com.devsuperior.springprofessional.desafio.desafio03.domain.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientDTOEntradaTransformer clientDTOEntradaTransformer;

    @Autowired
    private ClientDTOSaidaTransformer clientDTOSaidaTransformer;

    @Transactional(readOnly = true)
    public ClientDTOSaida findById (Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não cadastrado"));
        return clientDTOSaidaTransformer.domainToDTOSaida(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTOSaida> findAll(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map( c -> clientDTOSaidaTransformer.domainToDTOSaida(c));
    }

    @Transactional
    public ClientDTOSaida insert (ClientDTOEntrada clientDTOEntrada) {
        Client client = clientDTOEntradaTransformer.toDomainObject(clientDTOEntrada);
        client = clientRepository.save(client);
        return clientDTOSaidaTransformer.domainToDTOSaida(client);
    }

    @Transactional
    public ClientDTOSaida update (Long clientId, ClientDTOEntrada clientDTOEntrada) {

        try {
            Client client = clientRepository.getReferenceById(clientId);
            clientDTOEntradaTransformer.copyToDomainObject(clientDTOEntrada, client);
            client = clientRepository.save(client);
            return clientDTOSaidaTransformer.domainToDTOSaida(client);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete (Long clientId) {
        if (!clientRepository.existsById(clientId)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        try {
            clientRepository.deleteById(clientId);
            clientRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial!");
        }
    }
}
