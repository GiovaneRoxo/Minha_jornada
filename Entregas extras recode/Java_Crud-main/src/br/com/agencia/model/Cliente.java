package br.com.agencia.model;

import java.util.Date;

public class Cliente {

	private int id;
	private String nome;
	private String nome_meio;
	private String nome_final;
	private int idade;
	private Date dataCadastro;
	private String usuario;
	private String senha;

	public String getNomeFinal() {
		return nome_final;
	}

	public void setNomeFinal(String nome_final) {
		this.nome_final = nome_final;
	}

	public String getNomeMeio() {
		return nome_meio;
	}

	public void setNomeMeio(String nome_meio) {
		this.nome_meio = nome_meio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}	
}
