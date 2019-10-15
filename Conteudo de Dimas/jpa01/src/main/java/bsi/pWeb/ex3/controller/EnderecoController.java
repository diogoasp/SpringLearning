package bsi.pWeb.ex3.controller;

import bsi.pWeb.ex3.model.Endereco;
import bsi.pWeb.ex3.repository.EnderecoRepository;
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
public class EnderecoController {
    @Autowired
    private EnderecoRepository repo;
    
    @RequestMapping(path = "/enderecos", method = RequestMethod.GET)
    public List<Endereco> getEnderecos(){
        return repo.findAll();
    }
    
    @RequestMapping(path = "/enderecos/{id}", method = RequestMethod.GET)
    public Optional<Endereco> getEndereco(@PathVariable("id") Long id){
        return repo.findById(id);
    }
    
    @RequestMapping(path = "/enderecos", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addEndereco(@RequestBody Endereco p){
        repo.save(p);
    }
    
    @RequestMapping(path = "/enderecos/{id}", method = RequestMethod.PUT)
    public void altEndereco(@PathVariable Long id, @RequestBody Endereco p){
        p.setId(id);
        repo.save(p);
    }
    
    @RequestMapping(path = "/enderecos/{id}", method = RequestMethod.DELETE)
    public String delEndereco(@PathVariable("id") Long id){
        if(repo.findById(id) != null){
            repo.deleteById(id);
            return "Excluído com sucesso!";
        }else{
            return "Endereço não encontrado.";
        }
        
    }
}
