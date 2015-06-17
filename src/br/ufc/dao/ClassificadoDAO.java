package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
		
		System.out.println("classificado ate aqui !!");
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
	
public Classificado classificadoId(Long id){		
	    
        String hql = " SELECT c FROM Classificado c WHERE c.id_classificado = :id";  
		
		TypedQuery<Classificado> query = this.manager.createQuery(hql, Classificado.class);
		query.setParameter("id", id).getResultList();
		List<Classificado> classificados = query.getResultList();
		Classificado c = classificados.get(0);
		
		return c;
	}
	

}
