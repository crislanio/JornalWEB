package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.ufc.model.Comentario;


@Repository
@Transactional
public class ComentarioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public ComentarioDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void add(Comentario comentario) {
		// TODO Auto-generated method stub
		
		
		this.manager.persist(comentario);
				
		
	}

	public void deletar(Comentario comentario) {
		// TODO Auto-generated method stub
		Comentario comentario2 =  buscar(comentario);
		

		this.manager.remove(comentario2);

		
	}

	public void alterar(Comentario comentario) {
		// TODO Auto-generated method stub
		
	
		this.manager.merge(comentario);
	
		
		
		
	}

	public List<Comentario> listar() {
		String hql = "select c from Comentario c";
		return this.manager.createQuery(hql,Comentario.class).getResultList();
	}

	public Comentario buscar(Comentario comentario) {
		// TODO Auto-generated method stub
		Comentario comentario2 = this.manager.find(Comentario.class, comentario.getId_comentario());
		return comentario2;
	}

	

	
}
