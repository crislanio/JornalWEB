package br.ufc.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="comentario")
public class Comentario {
	@Id
	@GeneratedValue
	private long id_comentario;
	@NotNull
	private String texto;
	
	
	@ManyToOne(optional=false,cascade=CascadeType.ALL)
	@JoinColumn(name="id_autor",referencedColumnName="id_usuario")
	private Usuario autor;
	
	

	@ManyToOne(optional=false,cascade=CascadeType.ALL)
	@JoinColumn(name="id_noticia",referencedColumnName="id_noticia")
	private Noticia noticia;



	public long getId_comentario() {
		return id_comentario;
	}



	public void setId_comentario(long id_comentario) {
		this.id_comentario = id_comentario;
	}



	public String getTexto() {
		return texto;
	}



	public void setTexto(String texto) {
		this.texto = texto;
	}



	public Usuario getAutor() {
		return autor;
	}



	public void setAutor(Usuario autor) {
		this.autor = autor;
	}



	public Noticia getNoticia() {
		return noticia;
	}



	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	
	
}
