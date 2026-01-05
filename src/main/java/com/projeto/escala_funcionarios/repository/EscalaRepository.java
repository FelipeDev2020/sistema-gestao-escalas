package com.projeto.escala_funcionarios.repository;

import com.projeto.escala_funcionarios.entity.Escala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EscalaRepository extends JpaRepository<Escala, Long> {
    List<Escala> findByDiaBetween(LocalDate dataInicio, LocalDate dataFim);

    // Método extra útil: Verificar se já existe escala para esse funcionário nesse dia
    boolean existsByFuncionarioIdAndDia(Long funcionarioId, LocalDate dia);
}
