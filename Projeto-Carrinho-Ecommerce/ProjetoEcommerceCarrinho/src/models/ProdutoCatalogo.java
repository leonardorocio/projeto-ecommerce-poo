package models;

public class ProdutoCatalogo extends Produto {
	
	private int estoque;

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	@Override
	public String mostrarProduto() {
		return String.format("Id: %d\nNome: %s\nDescrição: %s\nPreço: %.2f\nQuantidade Disponível: %d\n",
				this.getId(), this.getName(), this.getDescricao(), this.getPrice(), this.getEstoque());
	}
	
	
	
}

