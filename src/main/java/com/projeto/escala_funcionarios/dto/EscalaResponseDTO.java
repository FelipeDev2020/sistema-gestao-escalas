package com.projeto.escala_funcionarios.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record EscalaResponseDTO(
        Long id,
        String nomeFuncionario,
        String nomeTurno,
        LocalDate data,
        LocalTime horaInicio,
        LocalTime horaFim
) {
}
