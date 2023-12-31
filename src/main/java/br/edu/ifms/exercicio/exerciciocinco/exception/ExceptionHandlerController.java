package br.edu.ifms.exercicio.exerciciocinco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(MessageExceptionNotFound.class)
    public ResponseEntity<MessageExceptionHandler> orderNotFound(MessageExceptionNotFound ex) {
        MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<MessageExceptionHandler> argumentsNotValid(MethodArgumentTypeMismatchException ex) {
        String message = "Error with parameter or id";
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.BAD_REQUEST.value(), message
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
