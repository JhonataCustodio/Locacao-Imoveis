package br.edu.ifms.exercicio.exerciciocinco.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageExceptionHandler {
    private Date timestamp;
    private Integer status;
    private String message;
}
