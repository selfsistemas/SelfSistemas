package com.selfsistemas.self01.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.selfsistemas.self01.connection.ConnectionUtil;
import com.selfsistemas.self01.model.Contato;
import com.selfsistemas.self01.repository.ContatoRepositorio;

@ManagedBean
@RequestScoped
public class ContatoBean {

	private Contato contato;
	
	@PostConstruct
	public void post(){
		
	}
	
	public void enviar(){
		Session session = openSession();
		session.beginTransaction();
		
		ContatoRepositorio repositorio = new ContatoRepositorio(session);
		
		repositorio.insert(contato);
		
		commitOrRollback(session, session.getTransaction());
		
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


	/*GETS E SETS*/
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	 
	
	
}
