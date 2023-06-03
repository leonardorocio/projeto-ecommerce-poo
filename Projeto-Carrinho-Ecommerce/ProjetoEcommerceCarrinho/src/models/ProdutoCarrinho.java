package models;

public class ProdutoCarrinho extends Produto {
	
	private int quantidade;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String mostrarProduto() {
		return String.format("Id: %d\nNome: %s\nDescrição: %s\nPreço: %.2f\nQuantidade Selecionada: %d\n",
				this.getId(), this.getName(), this.getDescricao(), this.getPrice(), this.getQuantidade());
	}
}
