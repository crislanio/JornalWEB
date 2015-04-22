package br.ufc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Secao {
	@NotNull
	private long id;
	@NotNull
	@Size(min = 5)
	private String titulo;
	@NotNull
	@Size(min = 10)
	private String descricao;

	public Secao() {
		// TODO Auto-generated constructor stub
	}

	public Secao(long id, String titulo, String descricao) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Secao [id=" + id + ", titulo=" + titulo + ", descricao="
				+ descricao + "]";
	}

}
