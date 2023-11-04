package br.edu.ifms.exercicio.exerciciocinco.domain.repository;

import br.edu.ifms.exercicio.exerciciocinco.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
