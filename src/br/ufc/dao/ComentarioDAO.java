package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.model.Comentario;
import br.ufc.model.Noticia;


@Repository
@Transactional
public class ComentarioDAO {

	@PersistenceContext
	private EntityManager manager;
	/**
	 * Construtor Padrão
	 */
	public ComentarioDAO() {
	}
	
	public void add(Comentario comentario) {
		System.out.println("Teste Comentar DAO");
		this.manager.persist(comentario);
	}

	public void deletar(Comentario comentario) {
		Comentario coment2 =  buscar(comentario);
		this.manager.remove(coment2);
	}

	public void alterar(Comentario comentario) {
		this.manager.merge(comentario);
	}

	public List<Comentario> listar() {
		String hql = "select c from Comentario c";
		return this.manager.createQuery(hql,Comentario.class).getResultList();
	}
		
	public Comentario buscar(Comentario comentario) {
		Comentario coment2 = this.manager.find(Comentario.class, comentario.getId_comentario());
		return coment2;
	}

	public List<Comentario> comentarios(long id_noticia){
        
		String hql = " SELECT c FROM Comentario c WHERE c.noticia.id_noticia = :id_noticia";  
		
		TypedQuery<Comentario> query = this.manager.createQuery(hql, Comentario.class);
		query.setParameter("id_noticia", id_noticia);
		List<Comentario> comentarios = query.getResultList();
		
		return comentarios;
	}

	
}
