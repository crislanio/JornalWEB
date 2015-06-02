package br.ufc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Role {
	@NotNull
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
	public String getId() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setId(String l) {
		this.login = l;
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

	@Override
	public String toString() {
		return "Role [id=" + login + ", role=" + role + "]";
	}



}
