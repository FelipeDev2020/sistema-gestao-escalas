package com.projeto.escala_funcionarios.service;

import com.projeto.escala_funcionarios.dto.TurnoRequestDTO;
import com.projeto.escala_funcionarios.entity.Turno;
import com.projeto.escala_funcionarios.repository.TurnoRepository;
import org.springframework.stereotype.Service;

@Service
public class TurnoService {
    private final TurnoRepository repository;

    public TurnoService(TurnoRepository repository){
        this.repository = repository;
    }

    public Turno CadastrarTurno(TurnoRequestDTO dto){
        if(repository.existsByNome(dto.nome())){
            throw new IllegalArgumentException("Nome já cadastrado: " + dto.nome());
        }

        Turno turno = new Turno();

        turno.setNome(dto.nome());
        turno.setHoraInicio(dto.horaInicio());
        turno.setHoraFim(dto.horaFim());

        return repository.save(turno);
    }
}
