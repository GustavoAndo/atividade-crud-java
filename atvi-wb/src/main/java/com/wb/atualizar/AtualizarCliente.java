package com.wb.atualizar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class AtualizarCliente extends Atualizacao{
	private List<Cliente> clientes;
	private Entrada entrada;

	public AtualizarCliente(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void atualizar() {
		System.out.println("In�cio da exclus�o de um cliente");
		
		System.out.println("Lista de todos os clientes:");
		int i = 1;
		for (Cliente cliente : clientes) {
			System.out.println(i + " - " + cliente.nome);	
			i++;
		}
		
		System.out.println("Por favor informe o numero do cliente:");
		int numCliente = entrada.receberNumeroInteiro();
		
		Cliente cliente = clientes.get(numCliente);
		
		System.out.println("1) Nome: " + cliente.nome);
		System.out.println("2) Nome social: " + cliente.nomeSocial);
		System.out.println("3) G�nero: " + cliente.genero);
		System.out.println("4) CPF: " + cliente.getCpf().getValor() + " - Data Emiss�o: " + cliente.getCpf().getDataEmissao());
		System.out.println("5) RG(s): ");
		for (RG rg : cliente.getRgs()) {
			System.out.println(" " + rg.getValor() + " - Data Emiss�o: "  + rg.getDataEmissao());
		}
		System.out.println("6) Telefone(s): ");
		for (Telefone telefone : cliente.getTelefones()) {
			System.out.println(" (" + telefone.getDdd() + ")" + telefone.getNumero());
		}
		System.out.println("7) Data de cadastro: " + cliente.getDataCadastro());
		
		System.out.println("Por favor informe o numero do dado que voc� deseja atualizar:");
		int numDado = entrada.receberNumeroInteiro();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		switch (numDado) {
		case 1:
			System.out.println("Por favor informe o novo valor do nome (Atual: " + cliente.nome + "):");
			String nome = entrada.receberTexto();
			cliente.nome = nome;
			break;
		case 2:
			System.out.println("Por favor informe o novo valor do nome social (Atual: " + cliente.nomeSocial + "):");
			String nomeSocial = entrada.receberTexto();
			cliente.nomeSocial = nomeSocial;
			break;
		case 3:
			System.out.println("Por favor informe o novo valor do g�nero (Atual: " + cliente.genero + "):");
			String genero = entrada.receberTexto();
			cliente.genero = genero;
			break;
		case 4:
			System.out.println("Por favor informe o novo valor de CPF (Atual: " + cliente.getCpf().getValor() + "):");
			String cpfValor = entrada.receberTexto();
			System.out.println("Por favor informe o novo valor de Data de Emiss�o do CPF (Atual: " + cliente.getCpf().getDataEmissao() + "):");
			String cpfData = entrada.receberTexto();
			LocalDate cpfDataFormatada = LocalDate.parse(cpfData, formato);
			CPF cpf = new CPF(cpfDataFormatada, cpfValor);
			cliente.setCpf(cpf);
			break;
		case 5:
			int j = 1; 
			for (RG rg : cliente.getRgs()) {
				System.out.println(j + " - " + rg.getValor() + " - Data Emiss�o: "  + rg.getDataEmissao());
				j++;
			} 
			System.out.println("Por favor informe o RG que deseja atualizar:");
			int numRg = entrada.receberNumeroInteiro();
			RG rgAtual = cliente.getRgs().get(numRg);
			System.out.println("Por favor informe o novo valor do RG (Atual :" + rgAtual.getValor() + ")");
			String rgValor = entrada.receberTexto();
			System.out.println("Por favor informe o novo valor da Data de Emiss�o (Atual:" + rgAtual.getDataEmissao()+ ")");
			String rgData = entrada.receberTexto();
			LocalDate rgDataFormatada = LocalDate.parse(rgData, formato);
			RG rg = new RG(rgDataFormatada, rgValor);
			cliente.getRgs().set(numRg, rg);
			break;
		case 6:
			break;
		case 7:
			break;
		default:
			
		}

	}
}
