package models;

import java.util.ArrayList;
import java.util.List;

public class Carrinho implements ListaDeProdutos {
	
	List<Produto> listaProdutos = new ArrayList<>();
	double total;
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	@Override
	public void adicionarProduto(Produto produto) {
		this.listaProdutos.add(produto);
	}

	@Override
	public void removerProduto(int id) {
		
	}

	@Override
	public void alterarProduto(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> mostrarProdutos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
