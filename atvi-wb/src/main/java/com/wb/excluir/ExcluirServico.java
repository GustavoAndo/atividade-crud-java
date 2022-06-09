package com.wb.excluir;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;

public class ExcluirServico extends Exclusao {
	private List<Servico> servicos;
	private Entrada entrada;

	public ExcluirServico(List<Servico> servicos) {
		this.servicos = servicos;
		this.entrada = new Entrada();
	}

	@Override
	public void excluir() {
		System.out.println("In�cio da exclus�o de um servi�o");
				
		System.out.println("Lista de todos os servi�os:");
		int i = 1;
		for (Servico servico : servicos) {
			System.out.println(i + " - " + servico.nome);	
			i++;
		}
		
		System.out.println("Por favor informe o numero do servi�o:");
		int numServico = entrada.receberNumeroInteiro();
		
		this.servicos.remove(numServico - 1);
		System.out.println("Servi�o exclu�do com sucesso!");
	}
	
}
