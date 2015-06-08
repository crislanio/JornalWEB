package br.ufc.model.teste;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Jornalista extends Usuario {
	@NotNull
	@Size(min = 8)
	private String login;
	@NotNull
	@Size(min = 5)
	private String nome;
	@NotNull
	private String email;
	@NotNull
	@Size(min = 6)
	private String senha;

	public Jornalista() {
		// TODO Auto-generated constructor stub
	}

	public Jornalista(String login, String nome, String email, String senha) {
		this.login = login;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario [login=" + login + ", senha=" + senha + ", nome="
				+ nome + ", email=" + email + "]";
	}

}
