package maven04.repositorio;

import java.util.List;

import maven04.factory.ConnectionUtil;
import maven04.model.Produto;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProdutoRepositorio {

	private Session session;
	
	public ProdutoRepositorio(Session session) {
		this.session = session;
		
	}
	
	public void insert(Produto produto){
			session.persist(produto);
	}
	
	public List<Produto> findOfertas(){
		Query query = this.session.createQuery("SELECT p FROM Produto p").setCacheable(true);
		return query.list();
	}
	
}
