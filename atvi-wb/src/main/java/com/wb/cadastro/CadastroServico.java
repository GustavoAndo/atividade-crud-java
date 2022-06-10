package com.wb.cadastro;

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
		System.out.println("In�cio do cadastro do servi�o");
		
		System.out.println("Por favor informe o nome do servi�o:");
		String nome = entrada.receberTexto();
		
		System.out.println("Por favor informe o valor do servi�o:");
		double valor = entrada.receberNumeroDouble();
		entrada.receberTexto();
		
		boolean execucaoGenero = true;
		String genero = "";
		while(execucaoGenero) {
			System.out.println("Por favor informe o g�nero do cliente:");
			System.out.println("1 - Masculino");
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
				System.out.println("G�nero inv�lido! Verifique se voc� digitou corretamente!");
				}
			}
		}
		
		Servico servico = new Servico(nome, genero, valor, 0);
		this.servicos.add(servico);
		System.out.println("Servi�o cadastrado com sucesso!");

	}
	
}
