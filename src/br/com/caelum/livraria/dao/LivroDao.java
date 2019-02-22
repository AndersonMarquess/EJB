package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Livro;

//Transforma em EJB
@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salva(Livro livro) {
		entityManager.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		return entityManager.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();
	}
	
}
