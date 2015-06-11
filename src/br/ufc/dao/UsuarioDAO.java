package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Usuario;

@Repository
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}
	

	
	public void add(Usuario usuario) {
		// TODO Auto-generated method stub
		System.out.println("chega ou n"+ usuario.getNome());
		this.manager.persist(usuario);	
		
	}

	public void deletar(Usuario usuario) {
		// TODO Auto-generated method stub
//		Usuario u2 =  buscar(usuario);
		System.out.println("buscar usuario remove "+usuario);
	
		Usuario usuarioRef = this.manager.find(Usuario.class, usuario.getId_usuario());
		this.manager.remove(usuarioRef);
		
//		this.manager.remove(u2);
	
		
	}

	public void alterar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	
		this.manager.merge(usuario);
	
		
		
		
	}

	public List<Usuario> listar() {
		String hql = "select u from Usuario u";
		return this.manager.createQuery(hql,Usuario.class).getResultList();
	}

	public Usuario buscar(Usuario usuario) {
		// TODO Auto-generated method stub
		Usuario usuario2 = this.manager.find(Usuario.class, usuario.getId_usuario());
		return usuario2;
	}


	public Usuario buscarPorLogin2(Usuario usuario) {
		String hql = "select u from Usuario u where u.login='"+usuario.getLogin()+"'";
		return (Usuario) this.manager.createQuery(hql,Usuario.class).getResultList().get(0);
	}
	public Usuario buscarPorLogin(Usuario usuario){
		String hql = "SELECT u FROM Usuario u WHERE u.login='" + usuario.getLogin()+"'";
		List<?> resp = this.manager.createQuery(hql).getResultList();
		if(!resp.isEmpty())
			return (Usuario) this.manager.createQuery(hql).getResultList().get(0);
		return null;
	}

}
