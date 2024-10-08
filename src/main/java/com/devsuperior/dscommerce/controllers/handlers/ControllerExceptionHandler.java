package com.devsuperior.dscommerce.controllers.handlers;

import com.devsuperior.dscommerce.DTO.CustomError;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundExeception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExeception.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundExeception e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}