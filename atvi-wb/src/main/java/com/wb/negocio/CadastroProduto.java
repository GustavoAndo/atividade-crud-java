package com.wb.negocio;

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
		System.out.println("Início do cadastro do produto");
		
		System.out.println("Por favor informe o nome do produto:");
		String nome = entrada.receberTexto();
		
		System.out.println("Por favor informe o valor do produto:");
		double valor = entrada.receberNumeroDouble();
		entrada.receberTexto();
		
		boolean execucaoGenero = true;
		String genero = "";
		while(execucaoGenero) {
			System.out.println("Por favor informe para qual gênero é indicado o produto:");
			genero = entrada.receberTexto();
			if (genero.equals("Masculino") || genero.equals("Feminino")) {
				execucaoGenero = false;
			} else {
				System.out.println("Gênero inválido! Verifique se você digitou corretamente!");
			}
		}
		
		Produto produto = new Produto(nome, genero, valor, 0);
		
		this.produtos.add(produto);
	}
}
