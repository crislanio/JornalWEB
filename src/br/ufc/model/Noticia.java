package br.ufc.model;

import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Noticia {
	private Long id;
	@NotNull
	@Size(min = 10)
	private String titulo;
	@NotNull
	@Size(min = 5)
	private String subtitulo;
	@NotNull
	@Size(min = 100)
	private String texto;
	@NotNull
	@Size(min = 8)
	private String autor;
	// data_noticia TIMESTAMP NOT NULL, tá certo?
	private Date data_noticia;
	private Long id_secao;

	public Noticia() {
		// TODO Auto-generated constructor stub
	}

	public Noticia(Long id, String titulo, String subtitulo, String texto,
			String autor, Date data_noticia, Long id_secao) {
		this.id = id;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.texto = texto;
		this.autor = autor;
		this.data_noticia = data_noticia;
		this.id_secao = id_secao;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
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
	 * @return the subtitulo
	 */
	public String getSubtitulo() {
		return subtitulo;
	}

	/**
	 * @param subtitulo
	 *            the subtitulo to set
	 */
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
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
	 * @return the data_noticia
	 */
	public Date getData_noticia() {
		return data_noticia;
	}

	/**
	 * @param data_noticia
	 *            the data_noticia to set
	 */
	public void setData_noticia(String data_noticia) {
		this.data_noticia = Noticia.convertStringToDate(data_noticia);
//		this.data_noticia = new Date();
	}

	/**
	 * @return the id_secao
	 */
	public Long getId_secao() {
		return id_secao;
	}

	/**
	 * @param id_secao
	 *            the id_secao to set
	 */
	public void setId_secao(Long id_secao) {
		this.id_secao = id_secao;
	}

	public static Date convertStringToDate(String strDate) {

		int day = Integer.parseInt(strDate.split("/")[0]);
		int month = Integer.parseInt(strDate.split("/")[1]);
		int year = Integer.parseInt(strDate.split("/")[2]);

		//int day = Integer.parseInt(strDate.split("-")[2]);
		//int month = Integer.parseInt(strDate.split("-")[1]);
		//int year = Integer.parseInt(strDate.split("-")[0]);

		Date date = null;

		// date = new Date
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);

		date = calendar.getTime();

		return date;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", subtitulo="
				+ subtitulo + ", texto=" + texto + ", autor=" + autor
				+ ", data_noticia=" + data_noticia + ", id_secao=" + id_secao
				+ "]";
	}

}
