package bsi.pWeb.ex3.controller;

import bsi.pWeb.ex3.model.Funcionario;
import bsi.pWeb.ex3.repository.FuncionarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository repo;
    
    @RequestMapping(path = "/funcionarios", method = RequestMethod.GET)
    public List<Funcionario> getFuncionarios(){
        return repo.findAll();
    }
    
    @RequestMapping(path = "/funcionarios/{id}", method = RequestMethod.GET)
    public Optional<Funcionario> getFuncionario(@PathVariable("id") Long id){
        return repo.findById(id);
    }
    
    @RequestMapping(path = "/funcionarios", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addFuncionario(@RequestBody Funcionario p){
        repo.save(p);
    }
    
    @RequestMapping(path = "/funcionarios/{id}", method = RequestMethod.PUT)
    public void altFuncionario(@PathVariable Long id, @RequestBody Funcionario p){
        p.setId(id);
        repo.save(p);
    }
    
    @RequestMapping(path = "/funcionarios/{id}", method = RequestMethod.DELETE)
    public String delFuncionario(@PathVariable("id") Long id){
         if(repo.findById(id) != null){
            repo.deleteById(id);
            return "Excluído com sucesso!";
        }else{
            return "Funcionário não encontrado.";
        }
    }
}
