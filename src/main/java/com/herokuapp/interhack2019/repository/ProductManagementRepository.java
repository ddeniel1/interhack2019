package com.herokuapp.interhack2019.repository;

import com.herokuapp.interhack2019.modelo.ProductManagement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductManagementRepository extends JpaRepository<ProductManagement, Long> {


	//@Query("select all from PRODUCT_MANAGEMENT p where p.SKU = sku")
	ProductManagement findBySku(Integer sku);

}
