package com.wb.negocio;

import java.util.List;

import com.wb.cadastro.Cadastro;
import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Servico;

public class AdicionarServico extends Cadastro {
	private List<Cliente> clientes;
	private List<Servico> servicos;
	private Entrada entrada;

	public AdicionarServico(List<Cliente> clientes, List<Servico> servicos) {
		this.clientes = clientes;
		this.servicos = servicos;
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
		
		System.out.println("Lista de todos os serviços:");
		int j = 1;
		for (Servico servico : servicos) {
			System.out.println(j + ") " + servico.nome);	
			j++;
		}
		
		System.out.println("Por favor informe o número do serviço a ser adicionado:");
		int numServico = entrada.receberNumeroInteiro();
		
		Servico servico = servicos.get(numServico - 1);
		
		cliente.getServicosConsumidos().add(servico);
		servico.setQuantidadeConsumido(servico.getQuantidadeConsumido() + 1);
	}
	
}
