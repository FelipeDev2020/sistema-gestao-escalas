package com.projeto.escala_funcionarios.controller;

import com.projeto.escala_funcionarios.dto.EscalaRequestDTO;
import com.projeto.escala_funcionarios.dto.FuncionarioRequestDTO;
import com.projeto.escala_funcionarios.dto.TurnoRequestDTO;
import com.projeto.escala_funcionarios.repository.FuncionarioRepository;
import com.projeto.escala_funcionarios.repository.EscalaRepository;
import com.projeto.escala_funcionarios.repository.TurnoRepository;
import com.projeto.escala_funcionarios.service.EscalaService;
import com.projeto.escala_funcionarios.service.FuncionarioService;
import com.projeto.escala_funcionarios.service.TurnoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class PageController {

    private final FuncionarioService funcionarioService;
    private final TurnoService turnoService;
    private final EscalaService escalaService;
    private final FuncionarioRepository funcionarioRepository;
    private final TurnoRepository turnoRepository;

    // CONSTRUTOR UNIFICADO:
    public PageController(FuncionarioService funcionarioService,
                          TurnoService turnoService,
                          EscalaService escalaService,
                          FuncionarioRepository funcionarioRepository,
                          TurnoRepository turnoRepository) {
        this.funcionarioService = funcionarioService;
        this.turnoService = turnoService;
        this.escalaService = escalaService;
        this.funcionarioRepository = funcionarioRepository;
        this.turnoRepository = turnoRepository;
    }

    // --- FUNCIONÁRIOS ---
    @GetMapping("/funcionarios/novo")
    public String formFuncionario(Model model) {
        model.addAttribute("funcionarioDTO", new FuncionarioRequestDTO(null, null, null));
        return "funcionario-form";
    }

    @PostMapping("/funcionarios/salvar")
    public String salvarFuncionario(@ModelAttribute FuncionarioRequestDTO dto) {
        funcionarioService.cadastrarFuncionario(dto);
        return "redirect:/ui/funcionarios/novo";
    }

    // --- TURNOS ---
    @GetMapping("/turnos/novo")
    public String formTurno(Model model) {
        // Atenção aqui: O nome do atributo é "turnoDTO"
        model.addAttribute("turnoDTO", new TurnoRequestDTO(null, null, null));
        return "turno-form"; // O arquivo TEM que ser turno-form.html
    }

    @PostMapping("/turnos/salvar")
    public String salvarTurno(@ModelAttribute TurnoRequestDTO dto) {
        turnoService.CadastrarTurno(dto);
        return "redirect:/ui/turnos/novo";
    }

    // --- ESCALAS ---
    @GetMapping("/escalas/novo")
    public String formEscala(Model model) {
        model.addAttribute("escalaDTO", new EscalaRequestDTO(null, null, null));

        // Carregando as listas para os Dropdowns
        model.addAttribute("listaFuncionarios", funcionarioRepository.findAll());
        model.addAttribute("listaTurnos", turnoRepository.findAll());

        return "escala-form";
    }

    @PostMapping("/escalas/salvar")
    public String salvarEscala(@ModelAttribute EscalaRequestDTO dto) {
        escalaService.cadastrar(dto);
        return "redirect:/ui/escalas/novo";
    }

    @GetMapping("/escalas")
    public String listarEscalas(Model model) {
        // Busca todas as escalas do banco
        model.addAttribute("listaEscalas", escalaService.listarTodas());
        // OBS: Se você não criou o metodo no Service, chame o repository direto por enquanto:
        // model.addAttribute("listaEscalas", escalaRepository.findAll());

        return "escala-lista"; // Vai procurar o arquivo escala-lista.html
    }
}