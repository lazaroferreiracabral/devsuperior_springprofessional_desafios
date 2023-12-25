package com.devsuperior.springprofessional.desafio.desafio03.domain.services.exception;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String message) {
        super(message);
    }
}
