package br.ufc.model;

import java.util.Date;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="classificado")
public class Classificado {
	@Id
	@GeneratedValue
	@Column(name="id_classificado", nullable=false)
	private long id_classificado;
	@NotNull
	@Size(min = 10)
	private String texto;
	private String telefone;
	@NotNull
	@Size(min = 5)
	private String titulo;
	private float preco;
	private float melhor_oferta;
	private Date data_oferta;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY,optional=true)
	@JoinColumn(name="id_autor",referencedColumnName="id_usuario")
	private Usuario autor;



	public long getId_classificado() {
		return id_classificado;
	}



	public void setId_classificado(long id_classificado) {
		this.id_classificado = id_classificado;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getTexto() {
		return texto;
	}



	public void setTexto(String texto) {
		this.texto = texto;
	}



	public float getPreco() {
		return preco;
	}



	public void setPreco(float preco) {
		this.preco = preco;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public float getMelhor_oferta() {
		return melhor_oferta;
	}



	public void setMelhor_oferta(float melhor_oferta) {
		this.melhor_oferta = melhor_oferta;
	}



	public Date getData_oferta() {
		return data_oferta;
	}



	public void setData_oferta(Date data_oferta) {
		this.data_oferta = data_oferta;
	}



	public Usuario getAutor() {
		return autor;
	}



	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
	
	
}
