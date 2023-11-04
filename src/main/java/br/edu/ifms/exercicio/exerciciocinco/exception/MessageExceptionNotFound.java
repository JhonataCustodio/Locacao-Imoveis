package br.edu.ifms.exercicio.exerciciocinco.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MessageExceptionNotFound extends RuntimeException{
    public MessageExceptionNotFound(String message) {
        super(message);
    }
}

