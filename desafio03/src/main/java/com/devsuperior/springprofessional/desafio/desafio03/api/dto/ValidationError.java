package com.devsuperior.springprofessional.desafio.desafio03.api.dto;

import com.devsuperior.springprofessional.desafio.desafio03.api.controllers.handlers.FieldMessage;
import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends CustomError{

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public void addError (String fieldName, String message) {
        erros.add(new FieldMessage(fieldName, message));
    }
}
