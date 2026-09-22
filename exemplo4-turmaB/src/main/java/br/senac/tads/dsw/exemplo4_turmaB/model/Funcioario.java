package br.senac.tads.dsw.exemplo4_turmaB.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity 
public class Funcioario {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    //formato ano-mês-dia (sem horário)
    @PastOrPresent 
    private LocalDate dataContratacao;

    @NotNull 
    private Boolean trabalhoRemoto;

    @ManyToOne 
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
    
}
