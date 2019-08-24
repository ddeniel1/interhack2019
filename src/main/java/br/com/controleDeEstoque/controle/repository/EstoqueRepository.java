package br.com.controleDeEstoque.controle.repository;

import br.com.controleDeEstoque.controle.modelo.EstoqueLegacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<EstoqueLegacy, Long> {

	//@Query("select all from ESTOQUE p where p.SKU = sku")
	List<EstoqueLegacy> findBySku(Integer sku);

}
