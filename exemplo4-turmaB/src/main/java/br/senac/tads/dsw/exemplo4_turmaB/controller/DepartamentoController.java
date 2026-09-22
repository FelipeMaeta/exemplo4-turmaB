package br.senac.tads.dsw.exemplo4_turmaB.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.senac.tads.dsw.exemplo4_turmaB.model.Departamento;
import br.senac.tads.dsw.exemplo4_turmaB.repository.DepartamentoRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/departamentos") 

public class DepartamentoController {

    private final DepartamentoRepository repository;

    public DepartamentoController(DepartamentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping 
    public List<Departamento> listarTodos(){ 
        return repository.findAll(); // Retorna 200 OK por padrão
    }

    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento criar (@RequestBody @Valid Departamento departamento){
        return repository.save(departamento);
    }
    

}
