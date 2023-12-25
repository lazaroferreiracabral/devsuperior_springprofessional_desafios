package com.devsuperior.springprofessional.desafio.desafio03.api.controllers.handlers;

import com.devsuperior.springprofessional.desafio.desafio03.api.dto.CustomError;
import com.devsuperior.springprofessional.desafio.desafio03.api.dto.ValidationError;
import com.devsuperior.springprofessional.desafio.desafio03.domain.services.exception.DatabaseException;
import com.devsuperior.springprofessional.desafio.desafio03.domain.services.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound (ResourceNotFoundException e ,
                                                         HttpServletRequest httpServletRequest) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        CustomError customError = new CustomError(Instant.now(), httpStatus.value(), e.getMessage(),
                httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(customError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> databaseException (DatabaseException e,
                                                          HttpServletRequest httpServletRequest) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        CustomError customError = new CustomError(Instant.now(), httpStatus.value(), e.getMessage(),
                httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(customError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidValidation (MethodArgumentNotValidException e,
                                                                         HttpServletRequest httpServletRequest) {

        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError validationError = new ValidationError(Instant.now(), httpStatus.value(),
                "Dados inválidos", httpServletRequest.getRequestURI());

        for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
            String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
            String name = objectError.getObjectName();

            if (objectError instanceof FieldError) {
                name = ((FieldError) objectError).getField();
            }
            validationError.addError(name, message);
        }

        return ResponseEntity.status(httpStatus).body(validationError);
    }
}
