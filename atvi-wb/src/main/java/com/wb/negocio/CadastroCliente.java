package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private Entrada entrada;

	public CadastroCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("Início do cadastro do cliente");
		System.out.println("Por favor informe o nome do cliente:");
		String nome = entrada.receberTexto();
		
		System.out.println("Por favor informe o nome social do cliente:");
		String nomeSocial = entrada.receberTexto();
		
		boolean execucaoGenero = true;
		String genero = "";
		while(execucaoGenero) {
			System.out.println("Por favor informe o gênero do cliente - Masculino ou Feminino:");
			genero = entrada.receberTexto();
			if (genero.equals("Masculino") || genero.equals("Feminino")) {
				execucaoGenero = false;
			} else {
				System.out.println("Gênero inválido! Verifique se você digitou corretamente!");
			}
		}
		
		System.out.println("Por favor informe o número do cpf:");
		String valor = entrada.receberTexto();
		
		System.out.println("Por favor informe a data de emissão do cpf, no padrão dd/mm/yyyy:");
		String data = entrada.receberTexto();
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao = LocalDate.parse(data, formato);
		
		CPF cpf = new CPF(dataEmissao, valor);
		
		Cliente cliente = new Cliente(nome, nomeSocial, cpf, genero);
		
		boolean execucaoRg = true;
		while (execucaoRg) {
			System.out.println("Por favor informe o número do RG:");
			String valorRg = entrada.receberTexto();
			
			System.out.println("Por favor informe a data de emissão do RG, no padrão dd/mm/yyyy:");
			String dataRg = entrada.receberTexto();
			
			LocalDate dataEmissaoRg = LocalDate.parse(dataRg, formato);
			
			RG rg = new RG(dataEmissaoRg, valorRg);
			
			cliente.getRgs().add(rg);
			
			boolean execucaoContinuarRg = true;
			while (execucaoContinuarRg) {
				System.out.println("Deseja adicionar outro rg?");
				System.out.println("1 - Sim");
				System.out.println("2 - Não");
				int continuarRg =entrada.receberNumeroInteiro();
				entrada.receberTexto();
				
				switch(continuarRg) {
				case 1:
					execucaoContinuarRg = false;
					break;
				case 2:
					execucaoContinuarRg = false;
					execucaoRg = false;
					break;
				default:
					System.out.println("Operação não entendida");
				}
			}
		}
		
		boolean execucaoTel = true;
		while (execucaoTel) {
			System.out.println("Por favor informe o número do DDD:");
			String ddd = entrada.receberTexto();
			
			System.out.println("Por favor informe o número de Telefone:");
			String numero = entrada.receberTexto();
			
			Telefone telefone = new Telefone(ddd, numero);
			
			cliente.getTelefones().add(telefone);
			
			boolean execucaoContinuarTel = true;
			while (execucaoContinuarTel) {
				System.out.println("Deseja adicionar outro telefone?");
				System.out.println("1 - Sim");
				System.out.println("2 - Não");
				int continuarTel = entrada.receberNumeroInteiro();
				entrada.receberTexto();
				
				switch(continuarTel) {
				case 1:
					execucaoContinuarTel = false;
					break;
				case 2:
					execucaoContinuarTel = false;
					execucaoTel = false;
					break;
				default:
					System.out.println("Operação não entendida");
				}
			}
		}
		
		this.clientes.add(cliente);
	}
}