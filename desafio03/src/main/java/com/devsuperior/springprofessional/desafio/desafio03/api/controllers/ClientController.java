package com.devsuperior.springprofessional.desafio.desafio03.api.controllers;


import com.devsuperior.springprofessional.desafio.desafio03.api.dto.ClientDTOEntrada;
import com.devsuperior.springprofessional.desafio.desafio03.api.dto.ClientDTOSaida;
import com.devsuperior.springprofessional.desafio.desafio03.domain.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTOSaida> buscar (@PathVariable Long clientId) {
        ClientDTOSaida clientDTOSaida = clientService.findById(clientId);
        return ResponseEntity.ok(clientDTOSaida);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTOSaida>> findAll (Pageable pageable) {
        return ResponseEntity.ok(clientService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<ClientDTOSaida> insert (@RequestBody @Valid ClientDTOEntrada clientDTOEntrada) {
        ClientDTOSaida clientDTOSaida = clientService.insert(clientDTOEntrada);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clientDTOSaida.getId()).toUri();

        return ResponseEntity.created(uri).body(clientDTOSaida);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDTOSaida> update (@PathVariable Long clientId,
                                                  @RequestBody @Valid ClientDTOEntrada clientDTOEntrada) {
        ClientDTOSaida clientDTOSaida = clientService.update(clientId, clientDTOEntrada);
        return ResponseEntity.ok(clientDTOSaida);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete (@PathVariable Long clientId) {
        clientService.delete(clientId);
        return ResponseEntity.noContent().build();
    }

}
