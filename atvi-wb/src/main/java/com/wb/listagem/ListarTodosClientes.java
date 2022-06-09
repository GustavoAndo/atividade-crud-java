package com.wb.listagem;

import java.util.List;

import com.wb.io.Contador;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.RG;
import com.wb.modelo.Servico;
import com.wb.modelo.Telefone;

public class ListarTodosClientes extends Listagem {
	private List<Cliente> clientes;
	private Contador contador;

	public ListarTodosClientes(List<Cliente> clientes) {
		this.clientes = clientes;
		this.contador = new Contador();
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os clientes:");
		System.out.println("--------------------------------------");
		for (Cliente cliente : clientes) {
			System.out.println("Nome: " + cliente.nome);
			System.out.println("Nome social: " + cliente.nomeSocial);
			System.out.println("G�nero: " + cliente.genero);
			System.out.println("CPF: " + cliente.getCpf().getValor() + " - Data Emiss�o: " + cliente.getCpf().getDataEmissao());
			System.out.println("RG(s): ");
			for (RG rg : cliente.getRgs()) {
				System.out.println(" " + rg.getValor() + " - Data Emiss�o: "  + rg.getDataEmissao());
			}
			System.out.println("Telefone(s): ");
			for (Telefone telefone : cliente.getTelefones()) {
				System.out.println(" (" + telefone.getDdd() + ")" + telefone.getNumero());
			}
			System.out.println("Servi�o(s) Consumido(s): ");
			if (contador.contarServicos(cliente.getServicosConsumidos()) == 0) {
				System.out.println(" Este cliente n�o possui servi�os consumidos.");
			} else {
				for (Servico servico : cliente.getServicosConsumidos()){
					System.out.println(" " + servico.nome + " - Valor do Servi�o: " + servico.valor);
				}
			}
			System.out.println("Produto(s) Consumido(s): ");
			if (contador.contarProdutos(cliente.getProdutosConsumidos()) == 0) {
				System.out.println(" Este cliente n�o possui produtos consumidos.");
			} else {
				for (Produto produto : cliente.getProdutosConsumidos()){
					System.out.println(" " + produto.nome + " - Valor do Produto: " + produto.valor);
				}
			}
			System.out.println("Data de cadastro: " + cliente.getDataCadastro());
			System.out.println("--------------------------------------");
		}
	}

}
