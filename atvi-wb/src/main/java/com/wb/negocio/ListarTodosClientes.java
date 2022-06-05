package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class ListarTodosClientes extends Listagem {
	private List<Cliente> clientes;

	public ListarTodosClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os clientes:");
		for (Cliente cliente : clientes) {
			System.out.println("Nome: " + cliente.nome);
			System.out.println("Nome social: " + cliente.nomeSocial);
			System.out.println("CPF: " + cliente.getCpf().getValor() + " - Data Emiss�o: " + cliente.getCpf().getDataEmissao());
			System.out.println("RG(s): ");
			for (RG rg : cliente.getRgs()) {
				System.out.println(" " + rg.getValor() + " - Data Emiss�o: "  + rg.getDataEmissao());
			}
			System.out.println("Telefone(s): ");
			for (Telefone telefone : cliente.getTelefones()) {
				System.out.println(" (" + telefone.getDdd() + ")" + telefone.getNumero());
			}
			System.out.println("Data de cadastro: " + cliente.getDataCadastro());
			System.out.println("--------------------------------------");
		}
	}
}
