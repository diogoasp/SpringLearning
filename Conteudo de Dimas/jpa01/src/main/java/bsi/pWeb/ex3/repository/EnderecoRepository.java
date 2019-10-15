package bsi.pWeb.ex3.repository;

import bsi.pWeb.ex3.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
