package controllers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import models.Carrinho;
import models.CatalogoProdutos;
import models.Permissao;
import models.Produto;
import models.ProdutoCatalogo;
import models.Usuario;
import views.View;

public class Controller {

	private static CatalogoProdutos catalogoProdutos = new CatalogoProdutos();
	private static Carrinho carrinho = null;
	private static String[] opcoes = { "Adicionar Produto", "Remover Produto", "Alterar Produto", "Mostrar Produtos",
			"Alterar Usuário", "Sair do Programa" };

	public static String[] converteListaEmArrayDeNomesDeProdutos(List<Produto> listaProdutos) {
		List<String> listaNomeStrings = listaProdutos.stream().map(Produto::getName)
				.collect(Collectors.toList());
		String[] opcoesProduto = new String[listaNomeStrings.size()];
		listaNomeStrings.toArray(opcoesProduto);
		return opcoesProduto;
	}

	public static Usuario loopingLogin() {
		Usuario usuario;
		do {
			usuario = View.mostraLogin();
		} while (usuario == null);
		return usuario;
	}

	public static void mostraMenu() {
		Usuario usuario = Controller.loopingLogin();

		if (usuario.getPermissao().equals(Permissao.ADMINISTRADOR)) {
			int opcao;
			do {
				opcao = View.selecionaOpcao(opcoes);
				String[] opcoesProduto = converteListaEmArrayDeNomesDeProdutos(
						Controller.catalogoProdutos.getListaDeProdutos());
				switch (opcao) {
					case 0:
						ProdutoCatalogo novoProdutoCatalogo = new ProdutoCatalogo(
								View.solicitaNome(), View.solicitaDescricao(), View.solicitaPreco(),
								View.solicitaEstoque());
						Controller.catalogoProdutos.adicionarProduto(novoProdutoCatalogo);
						JOptionPane.showMessageDialog(null, novoProdutoCatalogo.mostrarProduto());
						break;
					case 1:
						if (opcoesProduto.length > 0) {
							int indiceARemover = View.selecionaOpcao(opcoesProduto);
							Controller.catalogoProdutos.removerProduto(indiceARemover);
							JOptionPane.showMessageDialog(null, "Produto deletado com sucesso");
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao remover o produto");
						}
						break;
					case 2:
						if (opcoesProduto.length > 0) {
							int indiceARemover = View.selecionaOpcao(opcoesProduto);
							Controller.catalogoProdutos.removerProduto(indiceARemover);
							JOptionPane.showMessageDialog(null, "Produto deletado com sucesso");
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao alterar o produto");
						}
						break;
					case 3:
						int deveFiltrar = JOptionPane.showConfirmDialog(null, "Deseja filtrar os produtos por termo?");
						System.out.println(deveFiltrar);						
						if (deveFiltrar == 0) {
							String termo = JOptionPane.showInputDialog(null, "Digite o termo para filtrar");
							List<Produto> produtosFiltrados = Controller.catalogoProdutos.filtrarProdutos(termo);
							produtosFiltrados.stream().map(Produto::mostrarProduto).forEach((produto) -> JOptionPane.showMessageDialog(null, produto));
						} else {
							Controller.catalogoProdutos.mostrarProdutos().forEach((produto) -> JOptionPane.showMessageDialog(null, produto));
						}
						break;
					case 4:
						usuario = Controller.loopingLogin();
						break;
				}
			} while (opcao >= 0 && opcao < 6);
		} if (usuario.getPermissao().equals(Permissao.COMUM)) {

		}
	}
}
