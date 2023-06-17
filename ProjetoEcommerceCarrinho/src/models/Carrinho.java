package models;

import java.util.ArrayList;

public class Carrinho extends ListaDeProdutos {

	// Aqui teriam todas as outras funções do carrinho
	double total;
	
	public double getTotal() {
		return total;
	}

	public void alterarTotal(double valor) {
		this.total += valor;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public void limpaCarrinho() {
		this.setListaDeProdutos(new ArrayList<>());
	}
}
