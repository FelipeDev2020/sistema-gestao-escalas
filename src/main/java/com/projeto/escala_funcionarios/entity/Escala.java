package com.projeto.escala_funcionarios.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "escalas",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_escala_funcionario_dia",
                        columnNames = {"funcionario_id", "dia"}
                )
        }
)
public class Escala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O funcionario é obrigatório")
    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    @NotNull(message = "O Turno é obrigatório")
    @ManyToOne
    @JoinColumn(name = "turno_id", nullable = false)
    private Turno turno;

    @NotNull(message = "A data da escala é obrigatória")
    @Column(nullable = false)
    private LocalDate dia;

}
