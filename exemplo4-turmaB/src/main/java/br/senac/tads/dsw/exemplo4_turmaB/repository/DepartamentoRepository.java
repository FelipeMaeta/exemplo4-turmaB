package br.senac.tads.dsw.exemplo4_turmaB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.tads.dsw.exemplo4_turmaB.model.Departamento;

public interface  DepartamentoRepository extends JpaRepository<Departamento, Long >{
    
}
