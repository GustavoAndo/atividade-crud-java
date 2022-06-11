package com.wb.listagem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.QuantidadeServico;
import com.wb.modelo.Servico;

public class ListarMaisConsumidos extends Listagem {
	private Empresa empresa;
	private Entrada entrada;

	public ListarMaisConsumidos(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	@Override
	public void listar() {
		boolean execucaoConsumido = true;
		while(execucaoConsumido) {
			System.out.println("Deseja mostrar serviços ou produtos mais consumidos?");
			System.out.println("1 - Serviços");
			System.out.println("2 - Produtos");
			int consumidoNum = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			List <QuantidadeServico> quantidadeTodosServicos = new ArrayList<>();
			if (consumidoNum == 1) {
				for (Servico servico : empresa.getServicos()) {
					int quantidade = 0;
					for (Cliente cliente : empresa.getClientes()) {
						for (Servico servicoCliente : cliente.getServicosConsumidos()) {
							if(servico == servicoCliente) {
								quantidade++;
							}
						}
					}
					QuantidadeServico quantidadeServico = new QuantidadeServico(servico, quantidade);
					quantidadeTodosServicos.add(quantidadeServico);
				}
				Collections.sort(quantidadeTodosServicos, new Comparator<QuantidadeServico>() {
					  @Override
					  public int compare(QuantidadeServico qs1, QuantidadeServico qs2) {
					    return qs2.getQuantidadeConsumido().compareTo(qs1.getQuantidadeConsumido());
					  }
					});
				execucaoConsumido = false;
				for (QuantidadeServico quantidadeServico : quantidadeTodosServicos) {
					System.out.println(quantidadeServico.servico.nome);
					System.out.println(quantidadeServico.getQuantidadeConsumido());
				}
			} else {
				if (consumidoNum == 2) {

					execucaoConsumido = false;
				}
				else {
					System.out.println("Valor inválido! Verifique se você digitou corretamente!");
				}
			}
		}

	}
}
