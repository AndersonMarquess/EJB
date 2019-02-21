package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;

//Transforma em para ser gerenciado pelo container EJB
//Thread safe, o proprio ejb cria outra instancia caso esta esteja ocupada.
@Stateless
public class AutorDao {

	@Inject
	private Banco banco;

	//É chamado após a criação da Injeção de dependência, Callback
	@PostConstruct
	void aposCriacao() {
		System.out.println(getClass().getSimpleName()+" foi criado com sucesso");
	}
	
	
	public void salva(Autor autor) {
		banco.save(autor);
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}
