package br.edu.ifms.exercicio.exerciciocinco.domain.repository;

import br.edu.ifms.exercicio.exerciciocinco.domain.model.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocatarioRepository extends JpaRepository<Locatario, Integer> {
}
