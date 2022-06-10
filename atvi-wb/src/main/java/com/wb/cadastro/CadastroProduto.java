package com.wb.cadastro;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class CadastroProduto extends Cadastro{
	private List<Produto> produtos;
	private Entrada entrada;

	public CadastroProduto(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("In�cio do cadastro do produto");
		
		System.out.println("Por favor informe o nome do produto:");
		String nome = entrada.receberTexto();
		
		System.out.println("Por favor informe o valor do produto:");
		double valor = entrada.receberNumeroDouble();
		entrada.receberTexto();
		
		boolean execucaoGenero = true;
		String genero = "";
		while(execucaoGenero) {
			System.out.println("Por favor informe o g�nero do cliente:");
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
				System.out.println("G�nero inv�lido! Verifique se voc� digitou corretamente!");
				}
			}
		}
		
		Produto produto = new Produto(nome, genero, valor, 0);
		
		this.produtos.add(produto);
		System.out.println("Produto cadastrado com sucesso!");
	}
}
