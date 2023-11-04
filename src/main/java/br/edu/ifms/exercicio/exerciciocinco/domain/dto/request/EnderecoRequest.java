package br.edu.ifms.exercicio.exerciciocinco.domain.dto.request;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequest {
    private String rua;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
}
