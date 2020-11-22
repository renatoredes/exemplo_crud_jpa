package com.exemplo.crudjpa.infraestrutura;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.exemplo.crudjpa.domain.model.Carro;


@Component
public class CrudJPA {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Carro> listar() {
		return manager.createQuery("from Carro", Carro.class)
				.getResultList();
	}
	
	public Carro buscar(Long id) {
		return manager.find(Carro.class, id);
	}
	
	@Transactional
	public Carro salvar(Carro carro) {
		return manager.merge(carro);
	}
	
	@Transactional
	public void remover(Carro carro) {
		carro = buscar(carro.getId());
		manager.remove(carro);
	}
}
