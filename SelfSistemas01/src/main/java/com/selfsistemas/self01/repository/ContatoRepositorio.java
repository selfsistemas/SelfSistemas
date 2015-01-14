package com.selfsistemas.self01.repository;

import org.hibernate.Session;

import com.selfsistemas.self01.model.Contato;

public class ContatoRepositorio {
	
	private Session session;
	
	public ContatoRepositorio(Session session) {
		this.session = session;
	}
	
	public void insert(Contato contato){
		session.persist(contato);
	}
	
	
}
