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
		System.out.println("In�cio da exclus�o de um cliente");
				
		System.out.println("Lista de todos os clientes:");
		int i = 1;
		for (Cliente cliente : clientes) {
			System.out.println(i + " - " + cliente.nome);	
			i++;
		}
		
		int numCliente = 0;
		while (true) {
			System.out.println("Por favor informe o numero do cliente:");
			numCliente = entrada.receberNumeroInteiro();
			if (numCliente > 0 && numCliente <= clientes.size()) {
				break;
			}
			System.out.println("N�mero de cliente inv�lido! Verifique se o n�mero inserido est� correto.");
		}
		
		this.clientes.remove(numCliente - 1);
		System.out.println("Cliente exclu�do com sucesso!");
	}
}