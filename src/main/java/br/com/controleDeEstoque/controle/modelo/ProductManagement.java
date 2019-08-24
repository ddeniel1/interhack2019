package br.com.controleDeEstoque.controle.modelo;

import br.com.controleDeEstoque.controle.controller.dto.EstoqueDto;
import br.com.controleDeEstoque.controle.repository.ProductManagementRepository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="PRODUCT_MANAGEMENT")
@SequenceGenerator(name = "PROD_SEQ", sequenceName = "SQ_PRODUTO", initialValue = 1, allocationSize = 1)
public class ProductManagement implements Serializable {

	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROD_SEQ")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Long id;

	@Column(name = "SKU")
	private Integer sku;


	@Column(name = "VALOR")
	private Double valor;

	@Column(name = "ESTOQUE")
	private Integer estoque;

	@Column(name = "NOME_PRODUTO")
    private String nome;

	public ProductManagement() {
	}

	public ProductManagement(Integer sku, Double valor, Integer estoque, String nome) {
		this.sku = sku;
		this.valor = valor;
		this.estoque = estoque;
		this.nome = nome;
	}
	public EstoqueLegacy converter(ProductManagementRepository product) {
		System.out.println(id);

		ProductManagement produto = product.getOne(id);

		return new EstoqueLegacy(id,produto.getSku(), produto.getEstoque(), produto.getNome());
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSku() {
		return sku;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
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
		ProductManagement other = (ProductManagement) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!(getId()==other.getId()))
			return false;
		return true;
	}


    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}
