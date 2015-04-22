package br.ufc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Role {
	@NotNull
	@Size(min = 8)
	private String login;
	@NotNull
	private String role;

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(String login, String role) {
		this.login = login;
		this.role = role;
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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [login=" + login + ", role=" + role + "]";
	}

}
