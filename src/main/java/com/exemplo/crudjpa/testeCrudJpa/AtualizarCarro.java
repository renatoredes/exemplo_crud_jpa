package com.exemplo.crudjpa.testeCrudJpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.exemplo.crudjpa.ExemploCrudJpaApiApplication;
import com.exemplo.crudjpa.domain.model.Carro;
import com.exemplo.crudjpa.infraestrutura.CrudJPA;

public class AtualizarCarro {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(ExemploCrudJpaApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CrudJPA crudJpa = applicationContext.getBean(CrudJPA.class);
		
		Carro carro = new Carro();
		carro.setId(1L);
		carro.setNome("McLaren");
		
		crudJpa.salvar(carro);
		System.out.printf("%d - %s\n", carro.getId(), carro.getNome());
	}
	
}
