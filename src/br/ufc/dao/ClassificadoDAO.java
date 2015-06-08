package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificado;

@Repository
@Transactional
public class ClassificadoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public ClassificadoDAO() {
		// TODO Auto-generated constructor stub
	}

	public void add(Classificado classificado) {
		// TODO Auto-generated method stub
		
		
		this.manager.persist(classificado);
				
		
	}

	public void deletar(Classificado classificado) {
		// TODO Auto-generated method stub
		Classificado classificado2 =  buscar(classificado);
		
		
		this.manager.remove(classificado2);
		
		
	}

	public void alterar(Classificado classificado) {
		// TODO Auto-generated method stub
		
		
		this.manager.merge(classificado);
		
			
	}

	public List<Classificado> listar() {
		String hql = "select c from Classificado c";
		return this.manager.createQuery(hql,Classificado.class).getResultList();
	}

	public Classificado buscar(Classificado classificado) {
		// TODO Auto-generated method stub
		Classificado classificado2 = this.manager.find(Classificado.class, classificado.getId_classificado());
		return classificado2;
	}

}
