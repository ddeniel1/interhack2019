package com.herokuapp.interhack2019.controller;

import com.herokuapp.interhack2019.modelo.EstoqueLegacy;
import com.herokuapp.interhack2019.controller.dto.EstoqueDto;
import com.herokuapp.interhack2019.controller.form.ProdutoForm;
import com.herokuapp.interhack2019.modelo.ProductManagement;
import com.herokuapp.interhack2019.repository.EstoqueRepository;
import com.herokuapp.interhack2019.repository.ProductManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueRepository estoqueRepository;

	@Autowired
	private ProductManagementRepository productManagementRepository;
	
	@GetMapping
	public List<EstoqueDto> lista(Integer sku) {
		if (sku == null) {
			List<ProductManagement> estoque = productManagementRepository.findAll();
			return EstoqueDto.converter(estoque);
		} else {
			ProductManagement estoque = productManagementRepository.findBySku(sku);

			return EstoqueDto.converter(estoque);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<EstoqueDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
		ProductManagement product = form.converter();
		productManagementRepository.save(product);
		EstoqueLegacy estoque = product.converter(productManagementRepository);
		estoqueRepository.save(estoque);


		URI uri = uriBuilder.path("/estoque/{id}").buildAndExpand(estoque.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstoqueDto(estoque));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstoqueDto> detalhar(@PathVariable Long id) {
		Optional<ProductManagement> estoque = productManagementRepository.findById(id);
		if (estoque.isPresent()) {
			return ResponseEntity.ok(new EstoqueDto(estoque.get()));
		}
		
		return ResponseEntity.notFound().build();
	}

	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<ProductManagement> optional = productManagementRepository.findById(id);
		if (optional.isPresent()) {
			estoqueRepository.save(EstoqueLegacy.converter( productManagementRepository.findById(id).get()));
			productManagementRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}







