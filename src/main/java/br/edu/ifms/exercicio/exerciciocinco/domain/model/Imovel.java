package br.edu.ifms.exercicio.exerciciocinco.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "imovel")
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String registro;
    private Integer numero;
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

}
