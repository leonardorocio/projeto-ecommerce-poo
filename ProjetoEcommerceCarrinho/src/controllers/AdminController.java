package controllers;

import views.View;
import models.*;
import java.util.List;

public class AdminController extends MainController {

    private static final String[] OPCOES_STRINGS = { "Adicionar Produto ao Catálogo", "Remover Produto do Catálogo",
            "Alterar Produto do Catálogo", "Mostrar Produtos do Catálogo",
            "Alterar Usuário", "Sair do Programa" };

    public static boolean executarComoAdministrador() {
        int opcao;
        boolean executando = true, trocandoUsuario = false;
        do {
            opcao = View.selecionaOpcao(OPCOES_STRINGS);
            Produto[] opcoesObjetos = MainController
                    .converteListaEmArrayDeProdutos(MainController.catalogoProdutos.getListaDeProdutos());
            switch (opcao) {
                case 0:
                    String nome = View.solicitaNome();
                    String descricao = View.solicitaDescricao();
                    double preco = View.solicitaPreco();
                    int estoque = View.solicitaEstoque();
                    if (nome != null && descricao != null && preco != -1 && estoque != -1) {
                        ProdutoCatalogo novoProdutoCatalogo = new ProdutoCatalogo(
                                nome, descricao, preco,
                                estoque);
                        MainController.catalogoProdutos.adicionarProduto(novoProdutoCatalogo);
                        View.mostrarMensagem(novoProdutoCatalogo.mostrarProduto(), novoProdutoCatalogo.getName());
                    }
                    break;
                case 1:
                    if (opcoesObjetos.length > 0) {
                        Produto produtoARemover = View.selecionaOpcao(opcoesObjetos);
                        if (produtoARemover != null) {
                            MainController.catalogoProdutos.removerProduto(produtoARemover);
                            View.mostrarMensagem("Produto deletado do catálogo com sucesso", "OK");
                        }
                    } else {
                        View.mostrarMensagem("Erro ao deletar produto do catálogo", "Erro");
                    }
                    break;
                case 2:
                    if (opcoesObjetos.length > 0) {
                        ProdutoCatalogo produtoAEditar = (ProdutoCatalogo) View.selecionaOpcao(opcoesObjetos);
                        int propriedadeAEditar = View.selecionaPropriedadeProduto();
                        if (produtoAEditar != null && propriedadeAEditar != -1) {
                            switch (propriedadeAEditar) {
                                case 0:
                                    String novoNome = View.solicitaNome();
                                    produtoAEditar.setName(novoNome.isEmpty() ? produtoAEditar.getName() : novoNome);
                                    break;
                                case 1:
                                    double novoPreco = View.solicitaPreco();
                                    produtoAEditar.setPreco(novoPreco != 0 ? produtoAEditar.getPreco() : novoPreco);
                                    break;
                                case 2:
                                    String novoDescricao = View.solicitaDescricao();
                                    produtoAEditar.setDescricao(
                                            novoDescricao.isEmpty() ? produtoAEditar.getDescricao() : novoDescricao);
                                    break;
                                case 3:
                                    int novoEstoque = View.solicitaEstoque();
                                    produtoAEditar.setEstoque(novoEstoque);
                                    break;
                            }
                            MainController.catalogoProdutos.alterarProduto(produtoAEditar);
                            View.mostrarMensagem("Produto alterado do catálogo com sucesso", "OK");
                        }
                    } else {
                        View.mostrarMensagem("Erro ao alterar produto do catálogo", "Erro");
                    }
                    break;
                case 3:
                    if (opcoesObjetos.length > 0) {

                        int deveFiltrar = View.confirmaOpcao("Deseja filtrar produtos por termo?");
                        if (deveFiltrar == 0) {
                            String termo = View.solicitaTermoDeBusca();
                            List<Produto> produtosFiltrados = MainController.catalogoProdutos.filtrarProdutos(termo);
                            produtosFiltrados.stream().map(Produto::mostrarProduto)
                                    .forEach((produto) -> View.mostrarMensagem(produto,
                                            MainController.buscaNomeNaStringDoProduto(produto)));
                        } else if (deveFiltrar == 1) {
                            MainController.catalogoProdutos.mostrarProdutos()
                                    .forEach((produto) -> View.mostrarMensagem(produto,
                                            MainController.buscaNomeNaStringDoProduto(produto)));
                        }
                    } else {
                        View.mostrarMensagem("Catálogo vazio!", "Erro");
                    }
                    break;
                case 4:
                    trocandoUsuario = true;
                    break;
                case 5:
                    executando = false;
                    break;
            }
        } while ((opcao >= 0 && opcao < 6) && executando && !trocandoUsuario);
        return executando;
    }

}
