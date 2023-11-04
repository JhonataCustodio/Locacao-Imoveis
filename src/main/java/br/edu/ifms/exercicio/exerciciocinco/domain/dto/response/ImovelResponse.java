package br.edu.ifms.exercicio.exerciciocinco.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImovelResponse {
    private Integer id;
    private String registro;
    private Integer numero;
    private Integer enderecoId;
}
