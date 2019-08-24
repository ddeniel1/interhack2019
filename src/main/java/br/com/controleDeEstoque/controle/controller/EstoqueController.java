package br.com.controleDeEstoque.controle.controller;

import br.com.controleDeEstoque.controle.modelo.EstoqueLegacy;
import br.com.controleDeEstoque.controle.controller.dto.EstoqueDto;
import br.com.controleDeEstoque.controle.controller.form.ProdutoForm;
import br.com.controleDeEstoque.controle.modelo.ProductManagement;
import br.com.controleDeEstoque.controle.repository.EstoqueRepository;
import br.com.controleDeEstoque.controle.repository.ProductManagementRepository;
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







