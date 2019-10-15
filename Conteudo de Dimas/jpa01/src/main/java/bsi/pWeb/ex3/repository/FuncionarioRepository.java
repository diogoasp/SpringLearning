package bsi.pWeb.ex3.repository;

import bsi.pWeb.ex3.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
}
