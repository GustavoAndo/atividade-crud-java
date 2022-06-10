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
		this.entrada = new Entrada();
	}

	@Override
	public void atualizar() {
		System.out.println("Início da atualização de um cliente que deseja atualizar");
		
		System.out.println("Lista de todos os clientes:");
		int i = 1;
		for (Cliente cliente : clientes) {
			System.out.println(i + " - " + cliente.nome);	
			i++;
		}
		
		System.out.println("Por favor informe o numero do cliente:");
		int numCliente = entrada.receberNumeroInteiro();
		
		Cliente cliente = clientes.get(numCliente - 1);
		
		boolean execucaoSel = true;
		while(execucaoSel) {
			
			System.out.println("1) Nome: " + cliente.nome);
			System.out.println("2) Nome social: " + cliente.nomeSocial);
			System.out.println("3) Gênero: " + cliente.genero);
			System.out.println("4) CPF: " + cliente.getCpf().getValor() + " - Data Emissão: " + cliente.getCpf().getDataEmissao());
			System.out.println("5) RG(s): ");
			for (RG rg : cliente.getRgs()) {
				System.out.println(" " + rg.getValor() + " - Data Emissão: "  + rg.getDataEmissao());
			}
			System.out.println("6) Telefone(s): ");
			for (Telefone telefone : cliente.getTelefones()) {
				System.out.println(" (" + telefone.getDdd() + ")" + telefone.getNumero());
			}
			System.out.println("7) Data de cadastro: " + cliente.getDataCadastro());
			System.out.println("0) Sair");
			
			System.out.println("Por favor informe o numero do dado que você deseja atualizar:");
			int numDado = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			switch (numDado) {
			case 0:
				System.out.println("Voltando...");
				execucaoSel = false;
				break;
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
				System.out.println("Por favor informe o novo valor do gênero (Atual: " + cliente.genero + "):");
				String genero = "";
				boolean execucaoGenero = true;
				while(execucaoGenero) {
					System.out.println("Por favor informe o gênero do cliente:");
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
						System.out.println("Gênero inválido! Verifique se você digitou corretamente!");
						}
					}
				}
				cliente.genero = genero;
				break;
			case 4:
				System.out.println("Por favor informe o novo valor de CPF (Atual: " + cliente.getCpf().getValor() + "):");
				String cpfValor = entrada.receberTexto();
				System.out.println("Por favor informe o novo valor de Data de Emissão do CPF (Atual: " + cliente.getCpf().getDataEmissao() + "):");
				String cpfData = entrada.receberTexto();
				LocalDate cpfDataFormatada = LocalDate.parse(cpfData, formato);
				CPF cpf = new CPF(cpfDataFormatada, cpfValor);
				cliente.setCpf(cpf);
				break;
			case 5:
				int j = 1; 
				for (RG rg : cliente.getRgs()) {
					System.out.println(j + " - " + rg.getValor() + " - Data Emissão: "  + rg.getDataEmissao());
					j++;
				} 
				System.out.println("Por favor informe o RG que deseja atualizar:");
				int numRg = entrada.receberNumeroInteiro();
				entrada.receberTexto();
				RG rgAtual = cliente.getRgs().get(numRg - 1);
				System.out.println("Por favor informe o novo valor do RG (Atual :" + rgAtual.getValor() + ")");
				String rgValor = entrada.receberTexto();
				System.out.println("Por favor informe o novo valor da Data de Emissão (Atual:" + rgAtual.getDataEmissao()+ ")");
				String rgData = entrada.receberTexto();
				LocalDate rgDataFormatada = LocalDate.parse(rgData, formato);
				RG rg = new RG(rgDataFormatada, rgValor);
				cliente.getRgs().set(numRg - 1, rg);
				break;
			case 6:
				int k = 1; 
				for (Telefone telefone : cliente.getTelefones()) {
					System.out.println(k + " - (" + telefone.getDdd() + ") "  + telefone.getNumero());
					k++;
				} 
				System.out.println("Por favor informe o telefone que deseja atualizar:");
				int numTelefone = entrada.receberNumeroInteiro();
				entrada.receberTexto();
				Telefone telefoneAtual = cliente.getTelefones().get(numTelefone - 1);
				System.out.println("Por favor informe o novo valor do DDD (Atual: " + telefoneAtual.getDdd() + ")");
				String telefoneDdd = entrada.receberTexto();
				System.out.println("Por favor informe o novo valor do número do telefone (Atual: " + telefoneAtual.getNumero()+ ")");
				String telefoneNumero = entrada.receberTexto();
				Telefone telefone = new Telefone(telefoneDdd, telefoneNumero);
				cliente.getTelefones().set(numTelefone - 1, telefone);
				break;
			case 7:
				System.out.println("Por favor informe o novo valor de data cadastrada:");
				String data = entrada.receberTexto();
				LocalDate dataFormatada = LocalDate.parse(data, formato);
				cliente.setDataCadastro(dataFormatada);
				break;
			default:
				System.out.println("Operação não entendida");
			}
		}
	}
}
