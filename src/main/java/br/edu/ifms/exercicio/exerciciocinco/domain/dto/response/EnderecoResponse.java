package br.edu.ifms.exercicio.exerciciocinco.domain.dto.response;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoResponse {
    private Integer id;
    private String rua;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
}
