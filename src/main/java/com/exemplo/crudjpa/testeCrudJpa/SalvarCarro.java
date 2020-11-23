package com.exemplo.crudjpa.testeCrudJpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.exemplo.crudjpa.ExemploCrudJpaApiApplication;
import com.exemplo.crudjpa.domain.model.Carro;
import com.exemplo.crudjpa.infraestrutura.CrudJPA;

public class SalvarCarro {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(ExemploCrudJpaApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CrudJPA crudJpa = applicationContext.getBean(CrudJPA.class);
		
		Carro carro1 = new Carro();
		carro1.setNome("Ferrari-01");
		
		Carro carro2 = new Carro();
		carro2.setNome("Jaguar");
		
		carro1 = crudJpa.salvar(carro1);
		carro2 = crudJpa.salvar(carro2);
		
		System.out.printf("%d - %s\n", carro1.getId(), carro1.getNome());
		System.out.printf("%d - %s\n", carro2.getId(), carro2.getNome());
	}
	
}
