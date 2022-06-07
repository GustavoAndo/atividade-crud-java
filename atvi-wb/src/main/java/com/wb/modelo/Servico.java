package com.wb.modelo;

public class Servico {
	public String nome;
	public String genero;
	public double valor;
	private int quantidadeConsumido;
	
	public Servico(String nome, String genero, double valor, int quantidadeConsumido) {
		this.nome = nome;
		this.genero = genero;
		this.valor = valor;
		this.quantidadeConsumido = quantidadeConsumido;
	}

	public int getQuantidadeConsumido() {
		return quantidadeConsumido;
	}

	public void setQuantidadeConsumido(int quantidadeConsumido) {
		this.quantidadeConsumido = quantidadeConsumido;
	}
	
}