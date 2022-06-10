package com.wb;

import com.wb.atualizar.Atualizacao;
import com.wb.atualizar.AtualizarCliente;
import com.wb.atualizar.AtualizarProduto;
import com.wb.atualizar.AtualizarServico;
import com.wb.cadastro.Cadastro;
import com.wb.cadastro.CadastroCliente;
import com.wb.cadastro.CadastroProduto;
import com.wb.cadastro.CadastroServico;
import com.wb.cadastro.ListarClienteGênero;
import com.wb.excluir.ExcluirCliente;
import com.wb.excluir.ExcluirProduto;
import com.wb.excluir.ExcluirServico;
import com.wb.excluir.Exclusao;
import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.listagem.ListarTodosClientes;
import com.wb.listagem.ListarTodosProdutos;
import com.wb.listagem.ListarTodosServicos;
import com.wb.modelo.Empresa;
import com.wb.negocio.AdicionarProduto;
import com.wb.negocio.AdicionarServico;
import com.wb.negocio.RemoverProduto;
import com.wb.negocio.RemoverServico;

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
					System.out.println("7 - Remover um serviço consumido");
					System.out.println("8 - Remover um produto consumido");
					System.out.println("0 - Voltar para tela inicial");
					
					Entrada entrada1 = new Entrada();
					int operacao1 = entrada1.receberNumeroInteiro();
					
					switch(operacao1) {
					case 0:
						execucao1 = false;
						System.out.println("Voltando para tela inicial...");
						break;
					case 1:
						Cadastro cadastroCliente = new CadastroCliente(empresa.getClientes());
						cadastroCliente.cadastrar();
						break;
					case 2:
						if (empresa.getClientes().size() == 0) {
							System.out.println("Não há clientes cadastrados!");
							break;
						}
						Listagem listagemClientes = new ListarTodosClientes(empresa.getClientes());
						listagemClientes.listar();
						break;
					case 3:
						if (empresa.getClientes().size() == 0) {
							System.out.println("Não há clientes cadastrados!");
							break;
						}
						Atualizacao atualizarClientes = new AtualizarCliente(empresa.getClientes());
						atualizarClientes.atualizar();
						break;
					case 4:
						if (empresa.getClientes().size() == 0) {
							System.out.println("Não há clientes cadastrados!");
							break;
						}
						Exclusao excluirCliente = new ExcluirCliente(empresa.getClientes());
						excluirCliente.excluir();
						break;
					case 5:
						if (empresa.getClientes().size() == 0) {
							System.out.println("Não há clientes cadastrados! Cadastre um cliente para cadastrar os seus serviços consumidos");
							break;
						}
						if ((empresa.getServicos().size()) == 0) {
							System.out.println("Não há serviços cadastrados! Cadastre um serviço para adicioná-los como consumidos pelo cliente");
							break;
						}
						Cadastro adicionarServico = new AdicionarServico(empresa.getClientes(), empresa.getServicos());
						adicionarServico.cadastrar();
						break;
					case 6:
						if (empresa.getClientes().size() == 0) {
							System.out.println("Não há clientes cadastrados! Cadastre um cliente para cadastrar os seus serviços consumidos");
							break;
						}
						if (empresa.getProdutos().size() == 0) {
							System.out.println("Não há produto cadastrados! Cadastre um produto para adicioná-los como consumidos pelo cliente");
							break;
						}
						Cadastro adicionarProduto = new AdicionarProduto(empresa.getClientes(), empresa.getProdutos());
						adicionarProduto.cadastrar();
						break;
					case 7:
						if (empresa.getClientes().size() == 0) {
							System.out.println("Não há clientes cadastrados! Cadastre um cliente para cadastrar os seus serviços consumidos");
							break;
						}
						if ((empresa.getServicos().size()) == 0) {
							System.out.println("Não há serviços cadastrados! Cadastre um serviço para adicioná-los como consumidos pelo cliente");
							break;
						}
						Exclusao removerServico = new RemoverServico(empresa.getClientes(), empresa.getServicos());
						removerServico.excluir();
						break;
					case 8:
						if (empresa.getClientes().size() == 0) {
							System.out.println("Não há clientes cadastrados! Cadastre um cliente para cadastrar os seus serviços consumidos");
							break;
						}
						if (empresa.getProdutos().size() == 0) {
							System.out.println("Não há produtos cadastrados! Cadastre um produto para adicioná-los como consumidos pelo cliente");
							break;
						}
						Exclusao removerProduto = new RemoverProduto(empresa.getClientes(), empresa.getProdutos());
						removerProduto.excluir();
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
						System.out.println("Voltando para tela inicial...");
						break;
					case 1:
						Cadastro cadastroServico = new CadastroServico(empresa.getServicos());
						cadastroServico.cadastrar();
						break;
					case 2:
						if (empresa.getServicos().size() == 0) {
							System.out.println("Não há serviços cadastrados!");
							break;
						}
						Listagem listagemServicos = new ListarTodosServicos(empresa.getServicos());
						listagemServicos.listar();
						break;
					case 3:
						if (empresa.getServicos().size() == 0) {
							System.out.println("Não há serviços cadastrados!");
							break;
						}
						Atualizacao atualizarServico = new AtualizarServico(empresa.getServicos());
						atualizarServico.atualizar();
						break;
					case 4:
						if (empresa.getServicos().size() == 0) {
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
						System.out.println("Voltando para tela inicial...");
						break;
					case 1:
						Cadastro cadastroProduto = new CadastroProduto(empresa.getProdutos());
						cadastroProduto.cadastrar();
						break;
					case 2:
						if (empresa.getProdutos().size() == 0) {
							System.out.println("Não há produto cadastrados!");
							break;
						}
						Listagem listagemProdutos = new ListarTodosProdutos(empresa.getProdutos());
						listagemProdutos.listar();
						break;
					case 3:
						if (empresa.getProdutos().size() == 0) {
							System.out.println("Não há produto cadastrados!");
							break;
						}
						Atualizacao atualizarProduto = new AtualizarProduto(empresa.getProdutos());
						atualizarProduto.atualizar();
						break;
					case 4:
						if (empresa.getProdutos().size() == 0) {
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
				
			case 4:
				boolean execucao4 = true;
				while (execucao4) {
					System.out.println("Que tipo de operação você deseja fazer:");
					System.out.println("1 - Listar todos clientes por gênero");
					System.out.println("2 - Serviços ou produtos mais consumidos por gênero");
					System.out.println("3 - Seviços ou produtos mais consumidos (em geral)");
					System.out.println("4 - 10 clientes que mais consumiram serviços ou produtos");
					System.out.println("5 - 10 clientes que menos consumiram serviços ou produtos");
					System.out.println("6 - 5 clientes que mais consumiram em valor");
					System.out.println("0 - Voltar para tela inicial");
					
					Entrada entrada4 = new Entrada();
					int operacao4 = entrada4.receberNumeroInteiro();
					
					switch(operacao4) {
					case 0:
						execucao4 = false;
						System.out.println("Voltando para tela inicial...");
						break;
					case 1:
						if (empresa.getClientes().size() == 0) {
							System.out.println("Não há clientes cadastrados!");
							break;
						}
						Listagem listarClienteGênero = new ListarClienteGênero(empresa.getClientes());
						listarClienteGênero.listar();
						break;
					default:
						System.out.println("Operação não entendida");
					}
				}
			}
		}
	}
}