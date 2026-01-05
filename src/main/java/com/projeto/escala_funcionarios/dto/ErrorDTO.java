package com.projeto.escala_funcionarios.dto;

import java.time.LocalDateTime;

public record ErrorDTO(
        String message,
        int status,
        LocalDateTime timestamp
) {
}
