package br.edu.ifms.exercicio.exerciciocinco.domain.dto.response;

import br.edu.ifms.exercicio.exerciciocinco.domain.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocatarioResponse {
    private Integer id;
    private String cpf;
    private String nome;
    private Sexo sexo;
    private Integer imovelId;
}
