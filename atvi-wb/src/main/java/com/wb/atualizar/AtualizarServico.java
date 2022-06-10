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
			System.out.println("3) Gênero indicado: " + servico.genero);
			System.out.println("4) Quantidade de vezes consumido: " + servico.getQuantidadeConsumido());
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
			case 3:
				System.out.println("Por favor informe o novo valor do gênero (Atual: " + servico.genero + "):");
				String genero = "";
				boolean execucaoGenero = true;
				while(execucaoGenero) {
					System.out.println("Por favor informe o gênero do cliente:");
					System.out.println("1 - Maculino");
					System.out.println("2 - Feminino");
					int generoNum = entrada.receberNumeroInteiro();
					entrada.receberTexto();
					if (generoNum == 1) {
						genero = "Masculino";
						execucaoGenero = false;
					} else {
						if (generoNum == 2) {
							genero = "Feminino";
							execucaoGenero = false;
						}
						else {
						System.out.println("Gênero inválido! Verifique se você digitou corretamente!");
						}
					}
				}
				servico.genero = genero;
				break;
			case 4:
				System.out.println("Por favor informe o novo valor de quantidade de vezes consumido (Atual: " + servico.getQuantidadeConsumido() + "):");
				int quantidade = entrada.receberNumeroInteiro();
				servico.setQuantidadeConsumido(quantidade);
				break;
			default:
				System.out.println("Operação não entendida");
			}
		}
	}
}
