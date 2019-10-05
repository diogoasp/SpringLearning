package programacaoWeb.bsi.atividade2.controller;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import programacaoWeb.bsi.atividade2.model.Pessoa;

@RestController
@RequestMapping("atividade2")
public class PessoasController {
   
    private ArrayList<Pessoa> lp = new ArrayList<>();
    
    @RequestMapping(path = "/clientes", method = RequestMethod.GET)
    public ArrayList<Pessoa> getListaClientes(){
        return lp;
    }
    
    @RequestMapping(path = "/clientes/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Pessoa getCliente(@PathVariable("nome") String nome){
        for(Pessoa p : lp){
            if(p.getNome().equalsIgnoreCase(nome))
                return p;
        }
        return null;
    }

    @RequestMapping(path = "/clientes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void postCliente(@RequestBody Pessoa pessoa){
        lp.add(pessoa);
    }
    
    @RequestMapping(path = "/clientes/{nome}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void putCliente(@PathVariable("nome") String nome, @RequestBody Pessoa pessoa){
        lp.stream().filter((p) -> (p.getNome().equalsIgnoreCase(nome))).map((p) -> {
            return p;
        }).forEachOrdered((p) -> {
            lp.set(lp.indexOf(p), pessoa);
        });
    }
    
    @RequestMapping(path = "/clientes/{nome}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteCliente(@PathVariable("nome") String nome){
        for(Pessoa p : lp){
            if(p.getNome().equalsIgnoreCase(nome)){
                lp.remove(p);
                break;
            }
        }
    }
}
