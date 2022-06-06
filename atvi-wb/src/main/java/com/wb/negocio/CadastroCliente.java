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
		System.out.println("In�cio do cadastro do cliente");
		System.out.println("Por favor informe o nome do cliente:");
		String nome = entrada.receberTexto();
		
		System.out.println("Por favor informe o nome social do cliente:");
		String nomeSocial = entrada.receberTexto();
		
		boolean execucaoGenero = true;
		String genero = "";
		while(execucaoGenero) {
			System.out.println("Por favor informe o g�nero do cliente - Masculino ou Feminino:");
			genero = entrada.receberTexto();
			if (genero.equals("Masculino") || genero.equals("Feminino")) {
				execucaoGenero = false;
			} else {
				System.out.println("G�nero inv�lido! Verifique se voc� digitou corretamente!");
			}
		}
		
		System.out.println("Por favor informe o n�mero do cpf:");
		String valor = entrada.receberTexto();
		
		System.out.println("Por favor informe a data de emiss�o do cpf, no padr�o dd/mm/yyyy:");
		String data = entrada.receberTexto();
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao = LocalDate.parse(data, formato);
		
		CPF cpf = new CPF(dataEmissao, valor);
		
		Cliente cliente = new Cliente(nome, nomeSocial, cpf, genero);
		
		boolean execucaoRg = true;
		while (execucaoRg) {
			System.out.println("Por favor informe o n�mero do RG:");
			String valorRg = entrada.receberTexto();
			
			System.out.println("Por favor informe a data de emiss�o do RG, no padr�o dd/mm/yyyy:");
			String dataRg = entrada.receberTexto();
			
			LocalDate dataEmissaoRg = LocalDate.parse(dataRg, formato);
			
			RG rg = new RG(dataEmissaoRg, valorRg);
			
			cliente.getRgs().add(rg);
			
			boolean execucaoContinuarRg = true;
			while (execucaoContinuarRg) {
				System.out.println("Deseja adicionar outro rg?");
				System.out.println("1 - Sim");
				System.out.println("2 - N�o");
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
					System.out.println("Opera��o n�o entendida");
				}
			}
		}
		
		boolean execucaoTel = true;
		while (execucaoTel) {
			System.out.println("Por favor informe o n�mero do DDD:");
			String ddd = entrada.receberTexto();
			
			System.out.println("Por favor informe o n�mero de Telefone:");
			String numero = entrada.receberTexto();
			
			Telefone telefone = new Telefone(ddd, numero);
			
			cliente.getTelefones().add(telefone);
			
			boolean execucaoContinuarTel = true;
			while (execucaoContinuarTel) {
				System.out.println("Deseja adicionar outro telefone?");
				System.out.println("1 - Sim");
				System.out.println("2 - N�o");
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
					System.out.println("Opera��o n�o entendida");
				}
			}
		}
		
		this.clientes.add(cliente);
	}
}