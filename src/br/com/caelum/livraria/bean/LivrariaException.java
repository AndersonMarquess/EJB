package br.com.caelum.livraria.bean;

import javax.ejb.ApplicationException;

//Por padrão Runtime exception/system exception (unchecked) dispara rollback.
//Para obtermos o mesmo coportamento com exceções do tipo checked/Application exception, usamos a anotação abaixo: 
@ApplicationException(rollback=true)
public class LivrariaException extends Exception{
	private static final long serialVersionUID = 1L;

}
