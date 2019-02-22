package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

//Transforma em EJB
@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Usuario buscaPeloLogin(String login) {
		String sql = "SELECT u FROM Usuario u WHERE u.login = :pLogin";
		
		return (Usuario) entityManager.createQuery(sql)
				.setParameter("pLogin", login).getSingleResult();
	}
	
}
