package com.wb.io;

import java.util.List;

import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.Servico;

public class Contador {
	
	public int contarClientes(List <Cliente> clientes) {
		 int contador = 0;
		 for (Cliente cliente : clientes) {
			 if (cliente != null) {
				 contador ++;
			 }
		 } 
		 return contador;
	}
	
	public int contarServicos(List<Servico> servicos){
		 int contador = 0;
		 for (Servico servico : servicos) {
			 if (servico != null) {
				 contador ++;
			 }
		 } 
		 return contador;
	}
	
	public int contarProdutos(List <Produto> produtos) {
		 int contador = 0;
		 for (Produto produto : produtos) {
			 if (produto != null) {
				 contador ++;
			 }
		 } 
		 return contador;
	}
}
