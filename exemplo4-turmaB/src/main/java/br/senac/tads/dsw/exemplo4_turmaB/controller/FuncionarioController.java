package br.senac.tads.dsw.exemplo4_turmaB.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.senac.tads.dsw.exemplo4_turmaB.model.Funcionario;
import br.senac.tads.dsw.exemplo4_turmaB.repository.FuncionarioRepository;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/funcionarios") 
public class FuncionarioController {

    private final FuncionarioRepository repository;

    public FuncionarioController(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping 
    public List<Funcionario> listarTodos(){ 
        return repository.findAll(); 
    }

    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario criar (@RequestBody @Valid Funcionario Funcionario){
        return repository.save(Funcionario);
    }

    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id, 
                                @RequestBody @Valid Funcionario FuncionarioAtualizado){ 
                                    return repository.findById(id)
                                    .map(FuncionarioExistente -> {
                                        FuncionarioExistente.setNome(FuncionarioAtualizado.getNome());
                                        FuncionarioExistente.setDataContratacao(FuncionarioAtualizado.getDataContratacao());
                                        FuncionarioExistente.setTrabalhoRemoto(FuncionarioAtualizado.getTrabalhoRemoto());
                                        FuncionarioExistente.setDepartamento(FuncionarioAtualizado.getDepartamento());
                                        return repository.save(FuncionarioExistente);
                                    })
                                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));   
                                }
@DeleteMapping("/{id}")
@ResponseStatus (HttpStatus.NO_CONTENT)
public void apagar(@PathVariable Long id){
    if(!repository.existsById(id)){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    repository.deleteById(id);
}

    
}
