package com.projeto.escala_funcionarios.controller;

import com.projeto.escala_funcionarios.dto.TurnoRequestDTO;
import com.projeto.escala_funcionarios.entity.Turno;
import com.projeto.escala_funcionarios.service.TurnoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private final TurnoService service;

    public TurnoController(TurnoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Turno> CadastrarTurno(@RequestBody @Valid TurnoRequestDTO dto){
        Turno novoTurno = service.CadastrarTurno(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTurno);
    }

}
