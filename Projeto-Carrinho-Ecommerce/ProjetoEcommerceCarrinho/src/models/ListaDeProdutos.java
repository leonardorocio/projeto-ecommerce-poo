package models;

import java.util.List;

public interface ListaDeProdutos {
	
	void adicionarProduto(Produto produto);
	
	default int buscaProduto(List<Produto> listaProdutos, int id) {
		int counter = 0;
		for (Produto produto: listaProdutos) {
			if (produto.getId() == id) {
				break;
			}
			counter++;
		}
		return counter;
	}
	
	void removerProduto(int id);
	
	void alterarProduto(Produto produto);
	
	List<String> mostrarProdutos();
	// mostrar
}
