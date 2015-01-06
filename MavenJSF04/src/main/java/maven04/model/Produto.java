package maven04.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@NamedQueries({
	@NamedQuery(name="produto.findOfertas",query="SELECT p FROM Produto p"
			+ " WHERE p.oferta = TRUE")
	
})
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)

public class Produto {
	@Id
	@GeneratedValue
	@Column(name = "id_produto")
	private long idProduto;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private ProdutoCategoria produtoCategoria;
	
	@Column(nullable=false)
	private String nome;
	private String descricao;
	private String marca;
	
	private BigDecimal preco;
	
	@Column(name = "path_imagem",nullable=true) 
	private String pathImagem;
	
	private boolean oferta;

	
	
	
	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public ProdutoCategoria getProdutoCategoria() {
		return produtoCategoria;
	}

	public void setProdutoCategoria(ProdutoCategoria produtoCategoria) {
		this.produtoCategoria = produtoCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
		
	}

	public String getPathImagem() {
		return pathImagem;
	}

	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
	}

	public boolean isOferta() {
		return oferta;
	}

	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}
	
	
	
	
}
