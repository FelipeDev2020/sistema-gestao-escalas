package com.projeto.escala_funcionarios.service;

import com.projeto.escala_funcionarios.dto.EscalaRequestDTO;
import com.projeto.escala_funcionarios.dto.EscalaResponseDTO;
import com.projeto.escala_funcionarios.entity.Escala;
import com.projeto.escala_funcionarios.entity.Funcionario;
import com.projeto.escala_funcionarios.entity.Turno;
import com.projeto.escala_funcionarios.repository.EscalaRepository;
import com.projeto.escala_funcionarios.repository.FuncionarioRepository;
import com.projeto.escala_funcionarios.repository.TurnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscalaService {

    private final EscalaRepository escalaRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final TurnoRepository turnoRepository;

    // Injeção de dependência tripla.
    public EscalaService(EscalaRepository escalaRepository,
                         FuncionarioRepository funcionarioRepository,
                         TurnoRepository turnoRepository) {
        this.escalaRepository = escalaRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.turnoRepository = turnoRepository;
    }

    public EscalaResponseDTO cadastrar(EscalaRequestDTO dto) {
        // Validação de Conflito de Horário
        if (escalaRepository.existsByFuncionarioIdAndDia(dto.funcionarioId(), dto.data())) {
            throw new IllegalArgumentException("Esse funcionário já tem escala para o dia " + dto.data());
        }

        // Buscar Entidades (Se não achar, estoura erro)
        Funcionario funcionario = funcionarioRepository.findById(dto.funcionarioId())
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));

        Turno turno = turnoRepository.findById(dto.turnoId())
                .orElseThrow(() -> new IllegalArgumentException("Turno não encontrado"));

        // Montar e Salvar
        Escala escala = new Escala();
        escala.setFuncionario(funcionario);
        escala.setTurno(turno);
        escala.setDia(dto.data());

        escalaRepository.save(escala);

        // 4. Converter para ResponseDTO
        return new EscalaResponseDTO(
                escala.getId(),
                funcionario.getNome(),
                turno.getNome(),
                escala.getDia(),
                turno.getHoraInicio(),
                turno.getHoraFim()
        );
    }

    public List<Escala> listarTodas() {
        // O findAll() já busca tudo do banco.
        // Como estamos usando Thymeleaf, retornar a Entidade direta facilita
        // o acesso a dados aninhados (ex: escala.funcionario.nome) no HTML.
        return escalaRepository.findAll();
    }
}