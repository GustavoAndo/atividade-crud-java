package com.wb.excluir;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class ExcluirProduto extends Exclusao{
	private List<Produto> produtos;
	private Entrada entrada;

	public ExcluirProduto(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void excluir() {
		System.out.println("Início da exclusão de um servico");
				
		System.out.println("Lista de todos os servicos:");
		int i = 1;
		for (Produto produto : produtos) {
			System.out.println(i + " - " + produto.nome);	
			i++;
		}
		
		System.out.println("Por favor informe o numero do produto:");
		int numProduto = entrada.receberNumeroInteiro();
		
		this.produtos.remove(numProduto - 1);
		System.out.println("Produto excluído com sucesso!");
	}
	
}
