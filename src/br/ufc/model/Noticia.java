package br.ufc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="noticia")
public class Noticia {
	
	@Id
	@GeneratedValue
	@Column(name="id_noticia", nullable=false)
	private long id_noticia;
	@NotNull
	@Size(min = 10)
	private String titulo;
	@NotNull
	@Size(min = 5)
	private String subtitulo;
	@NotNull
	@Size(min = 50)
	private String texto;
	private Date data_noticia;
	
	//private long id_sec;  // tem que colocar pra pegar a categoria
  	

	@ManyToOne(optional=false)
	@JoinColumn(name="id_autor",referencedColumnName="id_usuario")
	private Usuario autor;

	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_secao",referencedColumnName="id_secao")
	private Secao secao;
	
	
	@OneToMany(mappedBy="noticia",targetEntity=Comentario.class,cascade=CascadeType.ALL)
	private List<Comentario> comentarios;


	public long getId_noticia() {
		return id_noticia;
	}


	public void setId_noticia(long id_noticia) {
		this.id_noticia = id_noticia;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getSubtitulo() {
		return subtitulo;
	}


	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public Date getData_noticia() {
		return data_noticia;
	}


	public void setData_noticia(Date data_noticia) {
		this.data_noticia = data_noticia;
	}


	public Usuario getAutor() {
		return autor;
	}


	public void setAutor(Usuario autor) {
		this.autor = autor;
	}


	public Secao getSecao() {
		return secao;
	}


	public void setSecao(Secao secao) {
		this.secao = secao;
	}


	public List<Comentario> getComentarios() {
		return comentarios;
	}


	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
	
}
