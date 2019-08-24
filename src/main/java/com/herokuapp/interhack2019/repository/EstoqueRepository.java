package com.herokuapp.interhack2019.repository;

import com.herokuapp.interhack2019.modelo.EstoqueLegacy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<EstoqueLegacy, Long> {

	//@Query("select all from ESTOQUE p where p.SKU = sku")
	List<EstoqueLegacy> findBySku(Integer sku);

}
