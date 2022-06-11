package com.wb.atualizar;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class AtualizarProduto extends Atualizacao {
	private List<Produto> produtos;
	private Entrada entrada;

	public AtualizarProduto(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void atualizar() {
		System.out.println("Início da atualização de um produto");
		
		System.out.println("Lista de todos os produtos:");
		int i = 1;
		for (Produto produto : produtos) {
			System.out.println(i + " - " + produto.nome);	
			i++;
		}
		
		System.out.println("Por favor informe o numero do produto que deseja atualizar:");
		int numProduto = entrada.receberNumeroInteiro();
		
		Produto produto = produtos.get(numProduto - 1);
		
		boolean execucaoSel = true;
		while(execucaoSel) {
			
			System.out.println("1) Nome: " + produto.nome);
			System.out.println("2) Valor: " + produto.valor);
			System.out.println("0) Sair");
	
			System.out.println("Por favor informe o numero do dado que você deseja atualizar:");
			int numDado = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			
			switch (numDado) {
			case 0:
				System.out.println("Voltando...");
				execucaoSel = false;
				break;
			case 1:
				System.out.println("Por favor informe o novo valor do nome (Atual: " + produto.nome + "):");
				String nome = entrada.receberTexto();
				produto.nome = nome;
				break;
			case 2:
				System.out.println("Por favor informe o novo valor (Atual: " + produto.valor + "):");
				double valor = entrada.receberNumeroDouble();
				produto.valor = valor;
				break;
			default:
				System.out.println("Operação não entendida");
			}
		}
	}
}
