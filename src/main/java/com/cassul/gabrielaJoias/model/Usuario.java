package com.cassul.gabrielaJoias.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

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
	
}
