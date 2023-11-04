package br.edu.ifms.exercicio.exerciciocinco.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rua;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;

    @OneToMany(mappedBy = "endereco")
    private List<Imovel> imoveis = new ArrayList<>();
}
