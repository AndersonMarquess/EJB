package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@WebService
@Stateless
public class LivrariaWS {

	@Inject 
	private LivroDao livroDao;
	
	//http://localhost:8080/livraria/LivrariaWS?wsdl
	@WebResult(name="livros")//anotação para deixar a resposta mais expressiva
	public List<Livro> getLivrosPorNome(@WebParam(name="titulo") String nome) {
		return livroDao.findLivrosPorNome(nome);
	}
}
