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
	
	public int buscaProdutoIndex(int id) {
		int counter = 0;
		for (Produto produto: this.listaDeProdutos) {
			if (produto.getId() == id) {
				break;
			}
			counter++;
		}
		return counter;
	}

	public Produto buscaProduto(int id) {
		return this.getListaDeProdutos().stream().filter(e -> e.getId() == id).findFirst().get();
	}

	public void removerProduto(Produto produto) {
		this.listaDeProdutos.remove(produto);
	}

	public void alterarProduto(Produto produto) {
		int posicaoId = this.buscaProdutoIndex(produto.getId());
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
