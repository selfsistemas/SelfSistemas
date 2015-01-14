package com.selfsistemas.self01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Contato {

	@Id
	@GeneratedValue
	@Column(name="id_contato")
	private long idContato;
	private String nome;
	private String email;
	@Column(columnDefinition="TEXT")
	private String mensagem;
	@Column(name="data_hora")
	private String dataHora;
	private boolean enviado;
	public long getIdContato() {
		return idContato;
	}
	public void setIdContato(long idContato) {
		this.idContato = idContato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	public boolean isEnviado() {
		return enviado;
	}
	public void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}
	
	
	
}
