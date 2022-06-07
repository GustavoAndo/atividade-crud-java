package com.wb;

import com.wb.io.Contador;
import com.wb.io.Entrada;
import com.wb.modelo.Empresa;
import com.wb.negocio.AdicionarProduto;
import com.wb.negocio.AdicionarServico;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroCliente;
import com.wb.negocio.CadastroProduto;
import com.wb.negocio.CadastroServico;
import com.wb.negocio.ExcluirCliente;
import com.wb.negocio.ExcluirProduto;
import com.wb.negocio.ExcluirServico;
import com.wb.negocio.Exclusao;
import com.wb.negocio.Listagem;
import com.wb.negocio.ListarTodosClientes;
import com.wb.negocio.ListarTodosProdutos;
import com.wb.negocio.ListarTodosServicos;

public class App {
	public static void main(String[] args) {
		System.out.println("Bem-vindo ao cadastro de clientes do Grupo World Beauty");
		Empresa empresa = new Empresa();
		Contador contador = new Contador();
		boolean execucao = true;
		while (execucao) {
			
			System.out.println("O que deseja consultar:");
			System.out.println("1 - Controle de Clientes");
			System.out.println("2 - Controle de Serviços");
			System.out.println("3 - Controle de Produtos");
			System.out.println("4 - Outras funções");
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
					System.out.println("3 - Atualizar dados de um cliente");
					System.out.println("4 - Excluir cliente");
					System.out.println("5 - Adicionar um serviço consumido");
					System.out.println("6 - Adicionar um produto consumido");
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
						if (contador.contarClientes(empresa.getClientes()) == 0) {
							System.out.println("Não há clientes cadastrados!");
							break;
						}
						Listagem listagemClientes = new ListarTodosClientes(empresa.getClientes());
						listagemClientes.listar();
						break;
					case 4:
						if (contador.contarClientes(empresa.getClientes()) == 0) {
							System.out.println("Não há clientes cadastrados!");
							break;
						}
						Exclusao excluirCliente = new ExcluirCliente(empresa.getClientes());
						excluirCliente.excluir();
						break;
					case 5:
						if (contador.contarClientes(empresa.getClientes()) == 0) {
							System.out.println("Não há clientes cadastrados! Cadastre um cliente para cadastrar os seus serviços consumidos");
							break;
						}
						if (contador.contarServicos(empresa.getServicos()) == 0) {
							System.out.println("Não há serviços cadastrados! Cadastre um serviço para adicioná-los como consumidos pelo cliente");
							break;
						}
						Cadastro adicionarServico = new AdicionarServico(empresa.getClientes(), empresa.getServicos());
						adicionarServico.cadastrar();
						break;
					case 6:
						if (contador.contarClientes(empresa.getClientes()) == 0) {
							System.out.println("Não há clientes cadastrados! Cadastre um cliente para cadastrar os seus serviços consumidos");
							break;
						}
						if (contador.contarProdutos(empresa.getProdutos()) == 0) {
							System.out.println("Não há produto cadastrados! Cadastre um produto para adicioná-los como consumidos pelo cliente");
							break;
						}
						Cadastro adicionarProduto = new AdicionarProduto(empresa.getClientes(), empresa.getProdutos());
						adicionarProduto.cadastrar();
						break;
					default:
						System.out.println("Operação não entendida");
					}
				}
				break;
				
			case 2:
				boolean execucao2 = true;
				while (execucao2) {
					System.out.println("Que tipo de operação você deseja fazer:");
					System.out.println("1 - Cadastrar serviço");
					System.out.println("2 - Listar todos os serviços");
					System.out.println("3 - Atualizar dados de um serviço");
					System.out.println("4 - Excluir serviço");
					System.out.println("0 - Voltar para tela inicial");
					
					Entrada entrada2 = new Entrada();
					int operacao2 = entrada2.receberNumeroInteiro();
					
					switch(operacao2) {
					case 0:
						execucao2 = false;
						System.out.println("Voltando para tela inicial...\n");
						break;
					case 1:
						Cadastro cadastroServico = new CadastroServico(empresa.getServicos());
						cadastroServico.cadastrar();
						break;
					case 2:
						if (contador.contarServicos(empresa.getServicos()) == 0) {
							System.out.println("Não há serviços cadastrados!");
							break;
						}
						Listagem listagemServicos = new ListarTodosServicos(empresa.getServicos());
						listagemServicos.listar();
						break;
					case 4:
						if (contador.contarServicos(empresa.getServicos()) == 0) {
							System.out.println("Não há serviços cadastrados!");
							break;
						}
						Exclusao excluirServico = new ExcluirServico(empresa.getServicos());
						excluirServico.excluir();
						break;
					default:
						System.out.println("Operação não entendida");
					}
				}
				break;
				
			case 3:
				boolean execucao3 = true;
				while (execucao3) {
					System.out.println("Que tipo de operação você deseja fazer:");
					System.out.println("1 - Cadastrar produto");
					System.out.println("2 - Listar todos os produtos");
					System.out.println("3 - Atualizar dados de um produto");
					System.out.println("4 - Excluir produto");
					System.out.println("0 - Voltar para tela inicial");
					
					Entrada entrada3 = new Entrada();
					int operacao3 = entrada3.receberNumeroInteiro();
					
					switch(operacao3) {
					case 0:
						execucao3 = false;
						System.out.println("Voltando para tela inicial...\n");
						break;
					case 1:
						Cadastro cadastroProduto = new CadastroProduto(empresa.getProdutos());
						cadastroProduto.cadastrar();
						break;
					case 2:
						if (contador.contarProdutos(empresa.getProdutos()) == 0) {
							System.out.println("Não há produto cadastrados!");
							break;
						}
						Listagem listagemProdutos = new ListarTodosProdutos(empresa.getProdutos());
						listagemProdutos.listar();
						break;
					case 4:
						if (contador.contarProdutos(empresa.getProdutos()) == 0) {
							System.out.println("Não há produto cadastrados!");
							break;
						}
						Exclusao excluirProduto = new ExcluirProduto(empresa.getProdutos());
						excluirProduto.excluir();
						break;
					default:
						System.out.println("Operação não entendida");
					}
				}
				break;
				
			default:
				System.out.println("Operação não entendida\n");
			}
		}
	}
}