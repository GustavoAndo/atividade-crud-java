package com.wb.listagem;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.QuantidadeProduto;
import com.wb.modelo.QuantidadeServico;
import com.wb.modelo.RG;
import com.wb.modelo.Servico;
import com.wb.modelo.Telefone;

public class ListarClienteGenero extends Listagem {
	private List<Cliente> clientes;
	private Entrada entrada;

	public ListarClienteGenero(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}
	
	@Override
	public void listar() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String genero = "";
		boolean execucaoGenero = true;
		while(execucaoGenero) {
			System.out.println("Por qual gênero você deseja listar?");
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
		System.out.println("Lista de todos os clientes do gênero " + genero.toLowerCase() + ":");
		System.out.println("--------------------------------------");
		for (Cliente cliente : clientes) {
			if (cliente.genero.equals(genero)) {
				System.out.println("Nome: " + cliente.nome);
				System.out.println("Nome social: " + cliente.nomeSocial);
				System.out.println("Gênero: " + cliente.genero);
				System.out.println("CPF: " + cliente.getCpf().getValor() + " - Data Emissão: " + cliente.getCpf().getDataEmissao().format(formato));
				System.out.println("RG(s): ");
				for (RG rg : cliente.getRgs()) {
					System.out.println(" " + rg.getValor() + " - Data Emissão: "  + rg.getDataEmissao().format(formato));
				}
				System.out.println("Telefone(s): ");
				for (Telefone telefone : cliente.getTelefones()) {
					System.out.println(" (" + telefone.getDdd() + ") " + telefone.getNumero());
				}
				System.out.println("Serviço(s) Consumido(s): ");
				if (cliente.getServicosConsumidos().size() == 0) {
					System.out.println(" Este cliente não possui serviços consumidos.");
				} else {
					Set<Servico> todosServicos = new HashSet<>();
					for (Servico servico : cliente.getServicosConsumidos()) {
						todosServicos.add(servico);
					}
					List<QuantidadeServico> quantidadeTodosServicos = new ArrayList<>();
					for (Servico servico : todosServicos) {
						int quantidade = 0;
						for (Servico servicoCliente : cliente.getServicosConsumidos()){
							if (servico.equals(servicoCliente)) {
								quantidade++;
							}
						}
						QuantidadeServico quantidadeServico = new QuantidadeServico(servico, quantidade);
						quantidadeTodosServicos.add(quantidadeServico);		
					}
					for (QuantidadeServico quantidadeServico : quantidadeTodosServicos) {
						System.out.println(" " + quantidadeServico.servico.nome + 
								" - Quantidade consumido: " +  quantidadeServico.getQuantidadeConsumido() +
								" - Valor do Produto: " + quantidadeServico.servico.valor);
					}
				}
				System.out.println("Produto(s) Consumido(s): ");
				if (cliente.getProdutosConsumidos().size() == 0) {
					System.out.println(" Este cliente não possui produtos consumidos.");
				} else {
					Set<Produto> todosProdutos = new HashSet<>();
					for (Produto produto : cliente.getProdutosConsumidos()) {
						todosProdutos.add(produto);
					}
					List<QuantidadeProduto> quantidadeTodosProdutos = new ArrayList<>();
					for (Produto produto : todosProdutos) {
						int quantidade = 0;
						for (Produto produtoCliente : cliente.getProdutosConsumidos()){
							if (produto.equals(produtoCliente)) {
								quantidade++;
							}
						}
						QuantidadeProduto quantidadeProduto = new QuantidadeProduto(produto, quantidade);
						quantidadeTodosProdutos.add(quantidadeProduto);		
					}
					for (QuantidadeProduto quantidadeProduto : quantidadeTodosProdutos) {
						System.out.println(" " + quantidadeProduto.produto.nome + 
								" - Quantidade consumido: " +  quantidadeProduto.getQuantidadeConsumido() +
								" - Valor do Produto: " + quantidadeProduto.produto.valor);
					}
				}
				System.out.println("Data de cadastro: " + cliente.getDataCadastro().format(formato));
				System.out.println("--------------------------------------");
			}	
		}	
	}
}
