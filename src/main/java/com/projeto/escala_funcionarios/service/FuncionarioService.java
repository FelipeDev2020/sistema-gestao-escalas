package com.projeto.escala_funcionarios.service;

import com.projeto.escala_funcionarios.dto.FuncionarioRequestDTO;
import com.projeto.escala_funcionarios.entity.Funcionario;
import com.projeto.escala_funcionarios.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    // Injeção via construtor (Correto)
    public FuncionarioService(FuncionarioRepository repository){
        this.repository = repository;
    }

    // Alterei o retorno para Funcionario. O ideal seria um FuncionarioResponseDTO,
    // mas para o MVP vamos retornar a entidade criada.
    public Funcionario cadastrarFuncionario(FuncionarioRequestDTO dto) {

        // Regra de Negócio 1: Validação de duplicidade
        if(repository.existsByEmail(dto.email())){
            throw new IllegalArgumentException("E-mail já cadastrado: " + dto.email());
        }

        // Conversão DTO -> Entidade (Mapeamento Manual)
        Funcionario funcionario = new Funcionario();

        // ATENÇÃO: Usamos SETTERS aqui, não acesso direto.
        funcionario.setNome(dto.nome());  // Pega do Record (dto.nome()) e joga na Entidade
        funcionario.setCargo(dto.cargo());
        funcionario.setEmail(dto.email());

        // O ID é gerado pelo banco, então não setamos.

        return repository.save(funcionario);
    }
}