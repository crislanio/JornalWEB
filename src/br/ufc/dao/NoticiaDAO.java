package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.model.Noticia;
import br.ufc.model.Secao;

@Repository
@Transactional
public class NoticiaDAO {

	@PersistenceContext
	private EntityManager manager;

	public NoticiaDAO() {

	}

	public Noticia getNoticiaId(Long id){
		return this.manager.find(Noticia.class, id);
	}

	public void add(Noticia noticia) {
		System.out.println("chega ou nao > " + noticia.getTitulo());
		this.manager.persist(noticia);

	}

	public void deletar(Noticia noticia) {
		Noticia noticia2 = buscar(noticia);
		this.manager.remove(noticia2);

	}

	public void alterar(Noticia noticia) {
		this.manager.merge(noticia);

	}

	public List<Noticia> listar() {
		String hql = "select n from Noticia n";
		return this.manager.createQuery(hql, Noticia.class).getResultList();
	}

	public Noticia buscar(Noticia noticia) {
		Noticia not2 = this.manager.find(Noticia.class,
				noticia.getId_noticia());
		return not2;
	}
	public Noticia getNoticia(Long id){
		return this.manager.find(Noticia.class, id);
	}

}
