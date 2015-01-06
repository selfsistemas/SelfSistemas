package maven04.bean;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import maven04.factory.ConnectionUtil;
import maven04.model.Produto;
import maven04.model.ProdutoCategoria;
import maven04.repositorio.ProdutoRepositorio;

@ManagedBean
public class IndexBean {

	
	public void teste(){
		
		Session session = openSession();
		session.beginTransaction();
		ProdutoRepositorio rep = new ProdutoRepositorio(session);
		
		List<Produto> produtos = rep.findOfertas();
		
		for (Produto p : produtos) {
			System.out.println(p.getIdProduto()+"- "+p.getNome()+" "+p.getProdutoCategoria().getDescricao());
		}
		
		commitOrRollback(session, session.getTransaction());
		
		session = openSession();
		session.beginTransaction();
		rep = new ProdutoRepositorio(session);
		
		produtos = rep.findOfertas();
		
		for (Produto p : produtos) {
			System.out.println(p.getIdProduto()+"- "+p.getNome());
		}
		
		
	}
	private Session openSession(){
		return ConnectionUtil.getSessionFactory().openSession();
	}
	private void commitOrRollback(Session session,Transaction transaction){
		try{
			ConnectionUtil.commitTransaction(transaction);
		}catch(Exception e){
			ConnectionUtil.rollbackTransaction(transaction);
			ConnectionUtil.closeSession(session);
		}
	}
	
}
