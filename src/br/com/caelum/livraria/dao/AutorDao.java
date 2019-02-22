package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

//Transforma em para ser gerenciado pelo container EJB
//Thread safe, o proprio ejb cria outra instancia caso esta esteja ocupada.
@Stateless
public class AutorDao {

	//Necessario para o contexto de persistencia
	@PersistenceContext
	private EntityManager entityManager;

	//É chamado após a criação da Injeção de dependência, Callback
	@PostConstruct
	void aposCriacao() {
		System.out.println(getClass().getSimpleName()+" foi criado com sucesso");
	}
	
	
	public void salva(Autor autor) {
		entityManager.persist(autor);
	}
	
	public List<Autor> todosAutores() {
		return entityManager.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return entityManager.find(Autor.class, autorId);
	}
	
}
