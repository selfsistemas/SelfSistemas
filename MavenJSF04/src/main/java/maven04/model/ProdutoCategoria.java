package maven04.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "produto_categoria")
@NamedQuery(name="produtoCategoria.findAll",query="SELECT p FROM ProdutoCategoria p")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class ProdutoCategoria {
	
	@Id
	@GeneratedValue
	@Column(name = "id_produto_categoria")
	private long idProdutoCategoria;
	
	private String descricao;
	
	
	
	public long getIdProdutoCategoria() {
		return idProdutoCategoria;
	}
	public void setIdProdutoCategoria(long idProdutoCategoria) {
		this.idProdutoCategoria = idProdutoCategoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
