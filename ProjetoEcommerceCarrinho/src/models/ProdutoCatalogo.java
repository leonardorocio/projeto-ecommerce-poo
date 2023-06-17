package models;

public class ProdutoCatalogo extends Produto {
	
	private static int idAtual = 0;

	private int estoque;

	public ProdutoCatalogo() {
		super();
	}

	public ProdutoCatalogo(String nome, String descricao, double preco, int estoque) {
		super(nome, descricao, preco);
		this.estoque = estoque;
		this.setId(idAtual++);
	}

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

