package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoProdutos implements ListaDeProdutos {

	List<Produto> listaProdutos = new ArrayList<>();

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
		int posicaoId = this.buscaProduto(this.listaProdutos, id);
		this.listaProdutos.remove(posicaoId);
	}

	@Override
	public void alterarProduto(Produto produto) {
		int posicaoId = this.buscaProduto(this.listaProdutos, produto.getId());
		this.listaProdutos.set(posicaoId, produto);
	}

	@Override
	public List<String> mostrarProdutos() {
		// TODO Auto-generated method stub
		List<String> mostraProdutos = new ArrayList<>();
		for (Produto produto: this.listaProdutos) {
			mostraProdutos.add(produto.mostrarProduto());
		}
		return mostraProdutos;
	}
	
}
