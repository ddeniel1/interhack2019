package br.com.controleDeEstoque.controle.controller.form;

import br.com.controleDeEstoque.controle.modelo.ProductManagement;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class ProdutoForm {

	@NotNull
	private Integer sku;
	
	@NotNull
	private Integer estoque;

	@NotNull
	private Double valor;

	@NotNull @NotEmpty
    private String nomeProduto;


	public ProductManagement converter(){
		return new ProductManagement(sku,valor,estoque,nomeProduto);
	}

	public ProdutoForm() {

	}

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Integer getSku() {
		return sku;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}


}
