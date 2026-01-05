package com.projeto.escala_funcionarios.controller;

import com.projeto.escala_funcionarios.dto.FuncionarioRequestDTO;
import com.projeto.escala_funcionarios.entity.Funcionario;
import com.projeto.escala_funcionarios.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Funcionario> cadastrar(@RequestBody @Valid FuncionarioRequestDTO dto){
        Funcionario novoFuncionario = service.cadastrarFuncionario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }
}
