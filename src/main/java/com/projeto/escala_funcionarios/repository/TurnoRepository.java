package com.projeto.escala_funcionarios.repository;

import com.projeto.escala_funcionarios.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    boolean existsByNome(String nome);
}
