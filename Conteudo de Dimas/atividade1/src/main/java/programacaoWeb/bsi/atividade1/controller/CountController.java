package programacaoWeb.bsi.atividade1.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Diogo Alves
 */

@RestController
@RequestMapping("count")
public class CountController {
    private int count = 0;
    
    @RequestMapping(path="/get", method=RequestMethod.GET)
    public int getCount(){
        return count;
    }
    
    @RequestMapping(path ="/post", method = RequestMethod.GET)
    public String postCount(){
        count++;
        return "Sucesso!";
    }
    
    @RequestMapping(path = "/put", method = RequestMethod.GET)
    public String putCount(){
        count = 0;
        return "Sucesso!";
    }
    
    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteCount(){
        count--;
        return "Sucesso!";
    }
    
    @RequestMapping(path = "/add/{value}", method = RequestMethod.GET)
    public String addCount(@PathVariable("value") int value){
        count += value;
        return "Sucesso ao adicionar o valor "+value;
    }
}
