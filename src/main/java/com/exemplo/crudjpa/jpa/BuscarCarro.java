package com.exemplo.crudjpa.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.exemplo.crudjpa.ExemploCrudJpaApiApplication;
import com.exemplo.crudjpa.domain.model.Carro;
import com.exemplo.crudjpa.infraestrutura.CrudJPA;

public class BuscarCarro {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(ExemploCrudJpaApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CrudJPA crudJpa = applicationContext.getBean(CrudJPA.class);
		
		Carro carro = crudJpa.buscar(1L);
		
		System.out.println(carro.getNome());
	}
	
}
