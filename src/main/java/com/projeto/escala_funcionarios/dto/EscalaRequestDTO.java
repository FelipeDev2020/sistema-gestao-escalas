package com.projeto.escala_funcionarios.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EscalaRequestDTO(
        @NotNull(message = "O ID do funcionario é obrigatório")
        Long funcionarioId,

        @NotNull(message = "O ID do turno é obrigatório")
        Long turnoId,

        @NotNull(message = "A data é obrigatório")
        LocalDate data

) {
}
