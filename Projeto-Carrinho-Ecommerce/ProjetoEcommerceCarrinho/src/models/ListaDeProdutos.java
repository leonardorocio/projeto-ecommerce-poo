package models;

import java.util.ArrayList;
import java.util.List;

public abstract class ListaDeProdutos {

	private List<Produto> listaDeProdutos = new ArrayList<>();

	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

	public void adicionarProduto(Produto produto) {
		this.listaDeProdutos.add(produto);
	}
	
	 int buscaProduto(int id) {
		int counter = 0;
		for (Produto produto: this.listaDeProdutos) {
			if (produto.getId() == id) {
				break;
			}
			counter++;
		}
		return counter;
	}

	public void removerProduto(int id) {
		int posicaoId = this.buscaProduto(id);
		this.listaDeProdutos.remove(posicaoId);
	}

	public void alterarProduto(Produto produto) {
		int posicaoId = this.buscaProduto(produto.getId());
		this.listaDeProdutos.set(posicaoId, produto);
	}

	public List<String> mostrarProdutos() {
		List<String> mostraProdutos = new ArrayList<>();
		for (Produto produto: this.listaDeProdutos) {
			mostraProdutos.add(produto.mostrarProduto());
		}
		return mostraProdutos;
	}
}
