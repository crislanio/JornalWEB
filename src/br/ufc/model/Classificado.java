package br.ufc.model;

import java.sql.Timestamp;

public class Classificado {
	private long id;
	private String titulo;
	private String texto;
	private Float preco;
	private String telefone;
	private Float melhor_oferta;
	private Timestamp data_oferta;
	private String autor_oferta;

	public Classificado() {
		// TODO Auto-generated constructor stub
	}

	public Classificado(long id, String titulo, String texto, Float preco,
			String telefone, Float melhor_oferta, Timestamp data_oferta,
			String autor_oferta) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.preco = preco;
		this.telefone = telefone;
		this.melhor_oferta = melhor_oferta;
		this.data_oferta = data_oferta;
		this.autor_oferta = autor_oferta;
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
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto
	 *            the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * @return the preco
	 */
	public Float getPreco() {
		return preco;
	}

	/**
	 * @param preco
	 *            the preco to set
	 */
	public void setPreco(Float preco) {
		this.preco = preco;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the melhor_oferta
	 */
	public Float getMelhor_oferta() {
		return melhor_oferta;
	}

	/**
	 * @param melhor_oferta
	 *            the melhor_oferta to set
	 */
	public void setMelhor_oferta(Float melhor_oferta) {
		this.melhor_oferta = melhor_oferta;
	}

	/**
	 * @return the data_oferta
	 */
	public Timestamp getData_oferta() {
		return data_oferta;
	}

	/**
	 * @param data_oferta
	 *            the data_oferta to set
	 */
	public void setData_oferta(Timestamp data_oferta) {
		this.data_oferta = data_oferta;
	}

	/**
	 * @return the autor_oferta
	 */
	public String getAutor_oferta() {
		return autor_oferta;
	}

	/**
	 * @param autor_oferta
	 *            the autor_oferta to set
	 */
	public void setAutor_oferta(String autor_oferta) {
		this.autor_oferta = autor_oferta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Classificado [id=" + id + ", titulo=" + titulo + ", texto="
				+ texto + ", preco=" + preco + ", telefone=" + telefone
				+ ", melhor_oferta=" + melhor_oferta + ", data_oferta="
				+ data_oferta + ", autor_oferta=" + autor_oferta + "]";
	}

}
