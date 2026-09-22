package br.senac.tads.dsw.exemplo4_turmaB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.tads.dsw.exemplo4_turmaB.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
}
