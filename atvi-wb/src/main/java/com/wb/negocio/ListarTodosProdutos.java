package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Produto;

public class ListarTodosProdutos extends Listagem {
	private List<Produto> produtos;

	public ListarTodosProdutos(List<Produto> produtos) {
		this.produtos= produtos;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os produtos:");
		for (Produto produto : produtos) {
			System.out.println("Nome: " + produto.nome);
			System.out.println("Valor: " + produto.valor);
			System.out.println("Gênero: " + produto.genero);
			System.out.println("Quantidade de vezes consumidos: " + produto.getQuantidadeConsumido());
			System.out.println("--------------------------------------");
		}
	}
}
