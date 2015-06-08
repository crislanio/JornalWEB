package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue
	@Column(name="id_role")
	private long id_role;
	@NotNull
	@Column(name="papel")
	private String papel;
	
	
	
	@ManyToMany(mappedBy="roles", fetch = FetchType.LAZY)
	private List<Usuario> usuarios;



	public long getId_role() {
		return id_role;
	}



	public void setId_role(long id_role) {
		this.id_role = id_role;
	}



	public String getPapel() {
		return papel;
	}



	public void setPapel(String papel) {
		this.papel = papel;
	}



	public List<Usuario> getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
