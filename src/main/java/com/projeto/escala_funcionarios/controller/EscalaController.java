package com.projeto.escala_funcionarios.controller;

import com.projeto.escala_funcionarios.dto.EscalaRequestDTO;
import com.projeto.escala_funcionarios.dto.EscalaResponseDTO;
import com.projeto.escala_funcionarios.entity.Escala;
import com.projeto.escala_funcionarios.service.EscalaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/escalas")
public class EscalaController {
    private final EscalaService service;

    public EscalaController(EscalaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EscalaResponseDTO> cadastrar(@RequestBody @Valid EscalaRequestDTO dto){
        EscalaResponseDTO novaEscala = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEscala);
    }
}
