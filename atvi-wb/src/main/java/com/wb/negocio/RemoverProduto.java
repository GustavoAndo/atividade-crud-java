package com.wb.negocio;

import java.util.List;

import com.wb.excluir.Exclusao;
import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;

public class RemoverProduto extends Exclusao{
	private List<Cliente> clientes;
	private Entrada entrada;

	public RemoverProduto(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}
	
	@Override
	public void excluir() {
		System.out.println("Lista de todos os clientes:");
		int i = 1;
		for (Cliente cliente : clientes) {
			System.out.println(i + ") " + cliente.nome);	
			i++;
		}
		boolean execucaoCliente = true;
		while(execucaoCliente) {
		
			System.out.println("Por favor informe o número do cliente (Digite 0 para sair)");
			int numCliente = entrada.receberNumeroInteiro(); 
			
			if(numCliente == 0) {
				break;
			}
			
			Cliente cliente = clientes.get(numCliente - 1);
			
			if(cliente.getProdutosConsumidos().size() == 0) {
				System.out.println("Não há produtos consumidos por este cliente");
			} else {
				System.out.println("Lista de todos os produtos deste cliente:");
				int j = 1;
				for (Produto produto : cliente.getProdutosConsumidos()) {
					System.out.println(j + ") " + produto.nome);	
					j++;
				}
				
				System.out.println("Por favor informe o número do produto a ser removido:");
				int numProduto = entrada.receberNumeroInteiro();
				
				cliente.getProdutosConsumidos().remove(numProduto - 1);
				execucaoCliente = false;
			}
		}
	}	
}
