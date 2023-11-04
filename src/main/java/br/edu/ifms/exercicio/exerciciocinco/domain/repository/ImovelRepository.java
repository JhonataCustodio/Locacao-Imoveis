package br.edu.ifms.exercicio.exerciciocinco.domain.repository;

import br.edu.ifms.exercicio.exerciciocinco.domain.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<Imovel, Integer> {
}
