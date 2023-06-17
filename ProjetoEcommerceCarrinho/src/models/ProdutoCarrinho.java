package models;

public class ProdutoCarrinho extends Produto {
	
	private int quantidade;

	public ProdutoCarrinho() {
		super();
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String mostrarProduto() {
		return String.format("Id: %d\nNome: %s\nDescrição: %s\nPreço: %.2f\nQuantidade Selecionada: %d\n",
				this.getId(), this.getName(), this.getDescricao(), this.getPreco(), this.getQuantidade());
	}

	public ProdutoCarrinho(Produto produto, int quantidade) {
		super(produto.getName(), produto.getDescricao(), produto.getPreco());
		this.setId(produto.getId());
		this.quantidade = quantidade;
	}
}
