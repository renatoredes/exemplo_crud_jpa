# Exemplo Crud JPA
Este é um código de CRUD utilizando conceitos de JPA e anotações Spring
1. clone o repositório `git clone https://github.com/renatoredes/exemplo_crud_jpa`

* SQL
`
insert into carro (nome) values ('Ferrari');
insert into carro (nome) values ('Jaguar');

`

* Classe de Crud.

`

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

`
