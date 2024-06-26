package com.cassul.gabrielaJoias.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@NotBlank
	@Column(name = "USERNAME", nullable = false)
	private String username;
	
	@NotBlank
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@NotBlank
	@Column(name = "SENHA", nullable = false)
	private String senha;
	
	@NotBlank
	@Column(name = "ROLE", nullable = true)
	private String role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
