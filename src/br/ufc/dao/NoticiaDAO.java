package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.ufc.model.Noticia;

@Repository
@Transactional
public class NoticiaDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public NoticiaDAO() {
		// TODO Auto-generated constructor stub
	}

	public void add(Noticia noticia) {
		// TODO Auto-generated method stub
		
		
		this.manager.persist(noticia);
				
		
	}

	public void deletar(Noticia noticia) {
		// TODO Auto-generated method stub
		Noticia noticia2 =  buscar(noticia);
		this.manager.remove(noticia2);
		
		
	}

	public void alterar(Noticia noticia) {
		// TODO Auto-generated method stub
		this.manager.merge(noticia);		
		
	}

	public List<Noticia> listar() {
		String hql = "select n from Noticia n";
		return this.manager.createQuery(hql,Noticia.class).getResultList();
	}

	public Noticia buscar(Noticia noticia) {
		// TODO Auto-generated method stub
		Noticia noticia2 = this.manager.find(Noticia.class,noticia.getId_noticia());
		return noticia2;
	}

	
}
