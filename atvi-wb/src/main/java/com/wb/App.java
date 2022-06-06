package com.wb;

import com.wb.io.Entrada;
import com.wb.modelo.Empresa;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroCliente;
import com.wb.negocio.CadastroProduto;
import com.wb.negocio.Listagem;
import com.wb.negocio.ListarTodosClientes;
import com.wb.negocio.ListarTodosProdutos;

public class App {
	public static void main(String[] args) {
		System.out.println("Bem-vindo ao cadastro de clientes do Grupo World Beauty");
		Empresa empresa = new Empresa();
		boolean execucao = true;
		while (execucao) {
			System.out.println("O que deseja consultar:");
			System.out.println("1 - Controle de Clientes");
			System.out.println("2 - Controle de Serviços");
			System.out.println("3 - Controle de Produtos");
			System.out.println("4 - Clientes/Serviços/Produtos populares");
			System.out.println("0 - Sair");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();

			switch (operacao) {
			case 0:
				execucao = false;
				System.out.println("Até mais!\n");
				break;
			case 1:
				boolean execucao1 = true;
				while (execucao1) {
					System.out.println("Que tipo de operação você deseja fazer:");
					System.out.println("1 - Cadastrar cliente");
					System.out.println("2 - Listar todos os clientes");
					System.out.println("0 - Voltar para tela inicial");
					
					Entrada entrada1 = new Entrada();
					int operacao1 = entrada1.receberNumeroInteiro();
					
					switch(operacao1) {
					case 0:
						execucao1 = false;
						System.out.println("Voltando para tela inicial...\n");
						break;
					case 1:
						Cadastro cadastroCliente = new CadastroCliente(empresa.getClientes());
						cadastroCliente.cadastrar();
						break;
					case 2:
						Listagem listagemClientes = new ListarTodosClientes(empresa.getClientes());
						listagemClientes.listar();
						break;
					default:
						System.out.println("Operação não entendida");
					}
				}
			case 3:
				boolean execucao2 = true;
				while (execucao2) {
					System.out.println("Que tipo de operação você deseja fazer:");
					System.out.println("1 - Cadastrar produto");
					System.out.println("2 - Listar todos os produtos");
					System.out.println("0 - Voltar para tela inicial");
					
					Entrada entrada2 = new Entrada();
					int operacao2 = entrada2.receberNumeroInteiro();
					
					switch(operacao2) {
					case 0:
						execucao1 = false;
						System.out.println("Voltando para tela inicial...\n");
						break;
					case 1:
						Cadastro cadastroProduto = new CadastroProduto(empresa.getProdutos());
						cadastroProduto.cadastrar();
						break;
					case 2:
						Listagem listagemProdutos = new ListarTodosProdutos(empresa.getProdutos());
						listagemProdutos.listar();
						break;
					default:
						System.out.println("Operação não entendida");
					}
				}
			}
		}
	}
}