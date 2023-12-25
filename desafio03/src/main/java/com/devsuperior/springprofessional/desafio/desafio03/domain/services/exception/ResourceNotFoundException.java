package com.devsuperior.springprofessional.desafio.desafio03.domain.services.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
