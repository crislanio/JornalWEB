package br.ufc.model.teste;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Comentario {
	private long id;
	@NotNull
	private long noticia; // ? int ou tá errado
	@NotNull
	@Size(min = 8)
	private String autor;
	@NotNull
	@Size(min = 10)
	private String texto;

	public Comentario() {
		// TODO Auto-generated constructor stub
	}

	public Comentario(long id, long noticia, String autor, String texto) {
		this.id = id;
		this.noticia = noticia;
		this.autor = autor;
		this.texto = texto;
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
	 * @return the noticia
	 */
	public long getNoticia() {
		return noticia;
	}

	/**
	 * @param noticia
	 *            the noticia to set
	 */
	public void setNoticia(long noticia) {
		this.noticia = noticia;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor
	 *            the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comentario [id=" + id + ", noticia=" + noticia + ", autor="
				+ autor + ", texto=" + texto + "]";
	}

}
