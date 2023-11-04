package br.edu.ifms.exercicio.exerciciocinco.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImovelRequest {
    private String registro;
    private Integer numero;
    private Integer enderecoId;
}
