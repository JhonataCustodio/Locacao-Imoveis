package br.edu.ifms.exercicio.exerciciocinco.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sexo {
   MASC("masc"),
    FEM("fem");
   private final String sexo;
}
