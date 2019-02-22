package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	//Verifica o tempo gasto na operação
	@AroundInvoke
	public Object interceptar(InvocationContext invocationContext) throws Exception {
		long inicio = System.currentTimeMillis();

		//proceed para continuar com a execução
		Object proceed = invocationContext.proceed();
		String metodo = invocationContext.getMethod().getName();
		String classe = invocationContext.getTarget().getClass().getSimpleName();
		long tempoGasto = System.currentTimeMillis() - inicio;
		
		System.out.println(String.format("Tempo gasto: %s - %s - %d ms", classe, metodo, tempoGasto));
		
		return proceed;
	}
	
}
