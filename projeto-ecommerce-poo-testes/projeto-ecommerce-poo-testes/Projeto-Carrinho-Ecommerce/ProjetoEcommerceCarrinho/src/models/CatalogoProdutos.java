package models;


import java.util.List;
import java.util.stream.Collectors;

public class CatalogoProdutos extends ListaDeProdutos {

	public boolean produtoTemTermo(Produto produto, String termo) {
		return produto.getName().contains(termo) || produto.getDescricao().contains(termo);
	}

	public List<Produto> filtrarProdutos(String termo) {
		return this.getListaDeProdutos().stream().filter((produto) -> produtoTemTermo(produto, termo)).collect(Collectors.toList());
	}
}
