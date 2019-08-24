package com.herokuapp.interhack2019.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="ESTOQUE")
@SequenceGenerator(name = "ESTOQUE_SEQ", sequenceName = "SEQ_EST", allocationSize = 1)
public class EstoqueLegacy implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTOQUE_SEQ")
	private Long id;

	@Column(name="SKU")
	private Integer sku;

	@Column(name="PRODUTO")
	private String produto;

	@Column(name="DATA")
	private LocalDateTime data = LocalDateTime.now();

	@Column(name = "nEstoque")
	private Integer estoque;


	public EstoqueLegacy() {
	}
	
	public EstoqueLegacy(Long id,Integer sku, Integer estoque, String nome) {
		this.id = id;
		this.sku = sku;
		this.estoque = estoque;
		this.produto = nome;
	}

	public static EstoqueLegacy converter(ProductManagement produto) {
		return new EstoqueLegacy(produto.getId(),produto.getSku(), produto.getEstoque(), produto.getNome());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstoqueLegacy other = (EstoqueLegacy) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

    public Integer getSku() {
        return sku;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setId(Long id) {
		this.id = id;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getData() {
		return data;
	}

}
