package models;

public abstract class Produto {

	private int id;
	private double preco;
	private String name;
	private String descricao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Produto() {
		
	}

	public Produto(String nome, String descricao, double preco) {
		this.name = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	public abstract String mostrarProduto();
	
}
