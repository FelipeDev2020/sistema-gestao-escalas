package com.projeto.escala_funcionarios.infra;

import com.projeto.escala_funcionarios.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(IllegalArgumentException e) {
        ErrorDTO errorResponse = new ErrorDTO(
                e.getMessage(), // "E-mail já cadastrado..."
                HttpStatus.CONFLICT.value(), // 409
                LocalDateTime.now()
        );
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }
    // BONUS: Captura erros gerais inesperados para não vazar stack trace nunca mais
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGeneralException(Exception e) {

        ErrorDTO errorResponse = new ErrorDTO(
                "Ocorreu um erro interno no servidor.", // Mensagem genérica para segurança
                HttpStatus.INTERNAL_SERVER_ERROR.value(), // 500
                LocalDateTime.now()
        );
        // Aqui você logaria o erro real no console para o desenvolvedor ver
        e.printStackTrace();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }
}
