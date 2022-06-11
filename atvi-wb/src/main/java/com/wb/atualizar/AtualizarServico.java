package com.wb.atualizar;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;

public class AtualizarServico extends Atualizacao{
	private List<Servico> servicos;
	private Entrada entrada;

	public AtualizarServico(List<Servico> servicos) {
		this.servicos = servicos;
		this.entrada = new Entrada();
	}

	@Override
	public void atualizar() {
		System.out.println("Início da atualização de um serviço");
		
		System.out.println("Lista de todos os serviços:");
		int i = 1;
		for (Servico servico : servicos) {
			System.out.println(i + " - " + servico.nome);	
			i++;
		}
		
		System.out.println("Por favor informe o numero do serviço que deseja atualizar:");
		int numServico = entrada.receberNumeroInteiro();
		
		Servico servico = servicos.get(numServico - 1);
		
		boolean execucaoSel = true;
		while(execucaoSel) {
			
			System.out.println("1) Nome: " + servico.nome);
			System.out.println("2) Valor: " + servico.valor);
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
				System.out.println("Por favor informe o novo valor do nome (Atual: " + servico.nome + "):");
				String nome = entrada.receberTexto();
				servico.nome = nome;
				break;
			case 2:
				System.out.println("Por favor informe o novo valor (Atual: " + servico.valor + "):");
				double valor = entrada.receberNumeroDouble();
				servico.valor = valor;
				break;
			default:
				System.out.println("Operação não entendida");
			}
		}
	}
}
