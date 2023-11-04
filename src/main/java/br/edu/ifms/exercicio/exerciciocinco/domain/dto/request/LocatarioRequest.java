package br.edu.ifms.exercicio.exerciciocinco.domain.dto.request;

import br.edu.ifms.exercicio.exerciciocinco.domain.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocatarioRequest {
    private String cpf;
    private String nome;
    private Sexo sexo;
    private Integer imovelId;
}
