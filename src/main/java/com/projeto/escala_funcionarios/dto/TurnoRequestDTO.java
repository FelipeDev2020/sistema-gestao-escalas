package com.projeto.escala_funcionarios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record TurnoRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotNull(message = "O horário de inicio é obrigatório")
        LocalTime horaInicio,

        @NotNull(message = "O horário de fim é obrigatório")
        LocalTime horaFim
) {
}
