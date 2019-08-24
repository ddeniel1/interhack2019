package com.herokuapp.interhack2019.controller.dto;

import com.herokuapp.interhack2019.modelo.EstoqueLegacy;
import com.herokuapp.interhack2019.modelo.ProductManagement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class EstoqueDto {

	private Long id;
	private Integer sku;
	private LocalDateTime data = LocalDateTime.now();
	private Integer qntdEstoque;
	private Double valor;
	private String nomeProduto;

	public EstoqueDto(EstoqueLegacy estoque) {
		this.id = estoque.getId();
		this.sku = estoque.getSku();
		this.data = estoque.getData();
		this.qntdEstoque = estoque.getEstoque();
	}
	public EstoqueDto(ProductManagement estoque) {
		this.id = estoque.getId();
		this.sku = estoque.getSku();
		this.qntdEstoque = estoque.getEstoque();
		this.valor = estoque.getValor();
		this.nomeProduto = estoque.getNome();
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Integer getSku() {
		return sku;
	}

	public Integer getQntdEstoque() {
		return qntdEstoque;
	}

	public Double getValor() {
		return valor;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public static List<EstoqueDto> converter(List<ProductManagement> estoque) {
		return estoque.stream().map(EstoqueDto::new).collect(Collectors.toList());
	}
    public static List<EstoqueDto> converter(ProductManagement estoque) {
        List<EstoqueDto> lista = new ArrayList<>();
        EstoqueDto aux = new EstoqueDto(estoque);
        lista.add(aux);
        return lista;
    }


}
