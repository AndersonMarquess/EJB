package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Autor;

//Transforma em para ser gerenciado pelo container EJB
//Thread safe, o proprio ejb cria outra instancia caso esta esteja ocupada.
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)//permite uso do begin e commit para controle manual das transacoes
@Interceptors({LogInterceptador.class})//Usado para informar que esta classe faz uso do interceptor
//@TransactionManagement(TransactionManagementType.CONTAINER)//default
public class AutorDao {

	//Necessario para o contexto de persistencia
	@PersistenceContext
	private EntityManager entityManager;
	//Necessario para o gerenciamento manual das transações
	@Inject
	private UserTransaction transacao;

	//É chamado após a criação da Injeção de dependência, Callback
	@PostConstruct
	void aposCriacao() {
		System.out.println(getClass().getSimpleName()+" foi criado com sucesso");
	}
	
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)//default com tipo Container
	public void salva(Autor autor) {
		try {
			transacao.begin();
			entityManager.persist(autor);
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Autor> todosAutores() {
		return entityManager.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return entityManager.find(Autor.class, autorId);
	}
	
}
