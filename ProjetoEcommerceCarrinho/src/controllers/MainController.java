package controllers;

import java.util.List;

import javax.swing.JOptionPane;

import models.Carrinho;
import models.CatalogoProdutos;
import models.Permissao;
import models.Produto;
import models.Usuario;
import views.View;

public class MainController {

	protected static CatalogoProdutos catalogoProdutos = new CatalogoProdutos();
	protected static Carrinho carrinho = new Carrinho();
	
	protected static Usuario usuarioLogado;

	public static Produto[] converteListaEmArrayDeProdutos(List<Produto> listaProdutos) {
		Produto[] opcoesProduto = new Produto[listaProdutos.size()];
		listaProdutos.toArray(opcoesProduto);
		return opcoesProduto;
	}

	public static String buscaNomeNaStringDoProduto(String produto) {
		String propriedadeNome = produto.split("\n")[1];
		String nomeProduto = propriedadeNome.split(":")[1];
		System.out.println(propriedadeNome.split(":"));
		System.out.println(nomeProduto);
		return nomeProduto;
	}

	public static void mostraMenu() {
		int opcao = View.exibeMenuInicial();
		while (opcao == 0) {
			do {
				usuarioLogado = View.mostraLogin();
				if (usuarioLogado == null)
					opcao = JOptionPane.showConfirmDialog(null, "Deseja tentar novamente?", "Erro", JOptionPane.YES_NO_OPTION);
			} while (usuarioLogado == null && opcao == 0);

			boolean executando = true;
			if (usuarioLogado.getPermissao().equals(Permissao.ADMINISTRADOR)) {
				executando = AdminController.executarComoAdministrador();
			} else if (usuarioLogado.getPermissao().equals(Permissao.COMUM)) {
				executando = ComumController.executarComoComum();
			}
			if (!executando) {
				opcao = -1;
			}
		}

	}
}
