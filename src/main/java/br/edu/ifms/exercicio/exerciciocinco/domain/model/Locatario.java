package br.edu.ifms.exercicio.exerciciocinco.domain.model;

import br.edu.ifms.exercicio.exerciciocinco.domain.enums.Sexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "locatario")
public class Locatario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;
}
