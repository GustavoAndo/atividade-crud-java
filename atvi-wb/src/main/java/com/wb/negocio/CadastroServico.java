package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;

public class CadastroServico extends Cadastro{
	private List<Servico> servicos;
	private Entrada entrada;

	public CadastroServico(List<Servico> servicos) {
		this.servicos = servicos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("Início do cadastro do serviço");
		
		System.out.println("Por favor informe o nome do serviço:");
		String nome = entrada.receberTexto();
		
		System.out.println("Por favor informe o valor do serviço:");
		double valor = entrada.receberNumeroDouble();
		entrada.receberTexto();
		
		boolean execucaoGenero = true;
		String genero = "";
		while(execucaoGenero) {
			System.out.println("Por favor informe para qual gênero é indicado o serviço, Masculino ou Feminino:");
			genero = entrada.receberTexto();
			if (genero.equals("Masculino") || genero.equals("Feminino")) {
				execucaoGenero = false;
			} else {
				System.out.println("Gênero inválido! Verifique se você digitou corretamente!");
			}
		}
		
		Servico servico = new Servico(nome, genero, valor, 0);
		this.servicos.add(servico);
	}
	
}
