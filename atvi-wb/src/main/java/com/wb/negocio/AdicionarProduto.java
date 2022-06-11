package com.wb.negocio;

import java.util.List;

import com.wb.cadastro.Cadastro;
import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;

public class AdicionarProduto extends Cadastro{
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private Entrada entrada;

	public AdicionarProduto(List<Cliente> clientes, List<Produto> produtos) {
		this.clientes = clientes;
		this.produtos = produtos;
		this.entrada = new Entrada();
	}
	
	@Override
	public void cadastrar() {
		System.out.println("Lista de todos os clientes:");
		int i = 1;
		for (Cliente cliente : clientes) {
			System.out.println(i + ") " + cliente.nome);	
			i++;
		}
		
		System.out.println("Por favor informe o número do cliente:");
		int numCliente = entrada.receberNumeroInteiro(); 
		
		Cliente cliente = clientes.get(numCliente - 1);
		
		System.out.println("Lista de todos os produtos:");
		int j = 1;
		for (Produto produto : produtos) {
			System.out.println(j + ") " + produto.nome);	
			j++;
		}
		
		System.out.println("Por favor informe o número do serviço a ser adicionado");
		int numProduto = entrada.receberNumeroInteiro();
		
		Produto produto = produtos.get(numProduto - 1);
		
		cliente.getProdutosConsumidos().add(produto);
	}
}
