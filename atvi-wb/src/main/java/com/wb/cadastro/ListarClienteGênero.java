package com.wb.cadastro;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.RG;
import com.wb.modelo.Servico;
import com.wb.modelo.Telefone;

public class ListarClienteGênero extends Listagem {
	private List<Cliente> clientes;
	private Entrada entrada;

	public ListarClienteGênero(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}
	
	@Override
	public void listar() {	
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
				System.out.println("CPF: " + cliente.getCpf().getValor() + " - Data Emissão: " + cliente.getCpf().getDataEmissao());
				System.out.println("RG(s): ");
				for (RG rg : cliente.getRgs()) {
					System.out.println(" " + rg.getValor() + " - Data Emissão: "  + rg.getDataEmissao());
				}
				System.out.println("Telefone(s): ");
				for (Telefone telefone : cliente.getTelefones()) {
					System.out.println(" (" + telefone.getDdd() + ")" + telefone.getNumero());
				}
				System.out.println("Serviço(s) Consumido(s): ");
				if (cliente.getServicosConsumidos().size() == 0) {
					System.out.println(" Este cliente não possui serviços consumidos.");
				} else {
					for (Servico servico : cliente.getServicosConsumidos()){
						System.out.println(" " + servico.nome + " - Valor do Serviço: " + servico.valor);
					}
				}
				System.out.println("Produto(s) Consumido(s): ");
				if (cliente.getProdutosConsumidos().size() == 0) {
					System.out.println(" Este cliente não possui produtos consumidos.");
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
}
