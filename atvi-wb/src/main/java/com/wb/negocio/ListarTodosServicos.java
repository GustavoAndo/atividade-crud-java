package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Servico;

public class ListarTodosServicos extends Listagem {
	private List<Servico> servicos;

	public ListarTodosServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os serviços:");
		System.out.println("--------------------------------------");
		for (Servico servico : servicos) {
			System.out.println("Nome: " + servico.nome);
			System.out.println("Valor: " + servico.valor);
			System.out.println("Gênero: " + servico.genero);
			System.out.println("Quantidade de vezes consumidos: " + servico.getQuantidadeConsumido());
			System.out.println("--------------------------------------");
		}
	}
}
