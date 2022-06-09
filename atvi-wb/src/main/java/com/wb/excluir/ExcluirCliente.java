package com.wb.excluir;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;

public class ExcluirCliente extends Exclusao{
	private List<Cliente> clientes;
	private Entrada entrada;

	public ExcluirCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void excluir() {
		System.out.println("Início da exclusão de um cliente");
				
		System.out.println("Lista de todos os clientes:");
		int i = 1;
		for (Cliente cliente : clientes) {
			System.out.println(i + " - " + cliente.nome);	
			i++;
		}
		
		System.out.println("Por favor informe o numero do cliente:");
		int numCliente = entrada.receberNumeroInteiro();
		
		this.clientes.remove(numCliente - 1);
		System.out.println("Cliente excluído com sucesso!");
	}
}
