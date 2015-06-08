package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.ufc.model.Secao;


@Repository
@Transactional
public class SecaoDAO  {
	
	@PersistenceContext
	private EntityManager manager;
	
	

	public void add(Secao secao) {
		// TODO Auto-generated method stub
		System.out.println("AQui!");
		this.manager.persist(secao);
	}

	public void deletar(Secao secao) {
		// TODO Auto-generated method stub
		Secao secao2 =  buscar(secao);
		
		
		this.manager.remove(secao2);
		
		
	}

	public void alterar(Secao secao) {
		// TODO Auto-generated method stub
		
		
		this.manager.merge(secao);
		
		
	}

	public List<Secao> listar() {
		String hql = "select s from Secao s";
		
		return this.manager.createQuery(hql,Secao.class).getResultList();
	}

	public Secao buscar(Secao secao) {
		// TODO Auto-generated method stub
		Secao secao2 = this.manager.find(Secao.class, secao.getId_secao() );
		return secao2;
	}
	
	

}
