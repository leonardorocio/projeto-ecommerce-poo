package models;

import main.Main;

public class Usuario {
	
	private int id;
	private String nome;
	private Permissao permissao;
	private Endereco endereco;
	private Carrinho carrinho;
	private String senha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Permissao getPermissao() {
		return permissao;
	}
	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public static Usuario autenticarUsuario(String usuario, String senha) {
		boolean ehUsuarioComum = Main.usuarioComum.nome.equals(usuario) && Main.usuarioComum.senha.equals(senha);
		boolean ehUsuarioAdmin = Main.usuarioAdmin.nome.equals(usuario) && Main.usuarioAdmin.senha.equals(senha);
		if (ehUsuarioAdmin) {
			return Main.usuarioAdmin;
		} else if (ehUsuarioComum) {
			return Main.usuarioComum;
		}
		return null;
	}


	public Usuario(String nome, String senha, Permissao permissao) {
		this.nome = nome;
		this.senha = senha;
		this.permissao = permissao;
	}
}
