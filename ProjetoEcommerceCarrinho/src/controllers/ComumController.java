package controllers;

import views.*;
import models.*;

public class ComumController extends MainController {

    private static final String[] OPCOES = { "Adicionar Produto ao Carrinho", "Remover Produto do Carrinho",
            "Alterar Quantidade de Produto", "Mostrar Produtos no Carrinho",
            "Limpa Carrinho", "Finalizar Compra",
            "Alterar Usuário", "Sair do Programa" };

    public static boolean executarComoComum() {
        int opcao;
        boolean executando = true, trocandoUsuario = false;
        do {
            opcao = View.selecionaOpcao(OPCOES);
            Produto[] opcoesObjetos = MainController
                    .converteListaEmArrayDeProdutos(MainController.catalogoProdutos.getListaDeProdutos());
            Produto[] produtosCarrinho = MainController
                    .converteListaEmArrayDeProdutos(MainController.carrinho.getListaDeProdutos());

            switch (opcao) {
                case 0:
                    Produto produtoEscolhido = View.selecionaOpcao(opcoesObjetos);
                    ProdutoCatalogo produtoEscolhidoCatalogo = (ProdutoCatalogo) produtoEscolhido;
                    int quantidadeDesejada = View.solicitaQuantidade();
                    if (quantidadeDesejada != -1 && produtoEscolhido != null) {
                        if (quantidadeDesejada <= produtoEscolhidoCatalogo.getEstoque()) {
                            ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(produtoEscolhido, quantidadeDesejada);
                            MainController.carrinho.adicionarProduto(produtoCarrinho);

                            MainController.carrinho.alterarTotal(produtoEscolhido.getPreco() * quantidadeDesejada);
                            View.mostrarMensagem(produtoCarrinho.mostrarProduto(), produtoCarrinho.getName());
                        } else {
                            View.mostrarMensagem(String.format(
                                    "Não é possível adicionar mais do que tem no estoque (%d disponíveis)",
                                    produtoEscolhidoCatalogo.getEstoque()), "Erro");
                        }
                    }
                    break;
                case 1:
                    if (produtosCarrinho.length > 0) {
                        Produto produtoARemover = View.selecionaOpcao(produtosCarrinho);
                        ProdutoCarrinho produtoARemoverDoCarrinho = (ProdutoCarrinho) produtoARemover;
                        MainController.carrinho.removerProduto(produtoARemover);
                        MainController.carrinho.alterarTotal(-produtoARemover.getPreco() * produtoARemoverDoCarrinho.getQuantidade());
                        View.mostrarMensagem("Produto removido do carrinho com sucesso", "OK");
                    } else {
                        View.mostrarMensagem("Carrinho Vazio!", "Erro");
                    }
                    break;
                case 2:
                    if (produtosCarrinho.length > 0) {
                        Produto produtoAEditar = View.selecionaOpcao(produtosCarrinho);
                        ProdutoCatalogo produtoCatalogo = (ProdutoCatalogo) MainController.catalogoProdutos.buscaProduto(produtoAEditar.getId());
                        int quantidadeAlterada = View.solicitaQuantidade();
                        if (produtoAEditar != null && quantidadeAlterada != -1) {

                            if (quantidadeAlterada > produtoCatalogo.getEstoque()) {
                                View.mostrarMensagem(String.format(
                                        "Não é possível adicionar mais do que tem no estoque (%d disponíveis)",
                                        produtoCatalogo.getEstoque()), "Erro");
                            } else if (quantidadeAlterada <= 0) {
                                MainController.carrinho.removerProduto(produtoAEditar);
                            } else {
                                ProdutoCarrinho produtoCarrinho = (ProdutoCarrinho) produtoAEditar;
                                int quantidadeAnterior = produtoCarrinho.getQuantidade();
                                produtoCarrinho.setQuantidade(quantidadeAlterada);
                                MainController.carrinho.alterarTotal((quantidadeAlterada - quantidadeAnterior) * produtoCarrinho.getPreco());
                                MainController.carrinho.alterarProduto(produtoCarrinho);
                                View.mostrarMensagem("Produto alterado com sucesso", "OK");
                            }
                        }
                    } else {
                        View.mostrarMensagem("Carrinho Vazio!", "Erro");
                    }
                    break;
                case 3:
                    if (produtosCarrinho.length > 0) {
                        MainController.carrinho.mostrarProdutos()
                                .forEach((produto) -> View.mostrarMensagem(produto,
                                        MainController.buscaNomeNaStringDoProduto(produto)));
                    } else {
                        View.mostrarMensagem("Carrinho Vazio!", "Erro");
                    }
                    break;
                case 4:
                    if (produtosCarrinho.length > 0) {
                        int apagarCarrinho = View.confirmaOpcao("Deseja realmente apagar o carrinho?");
                        if (apagarCarrinho == 0) {
                            MainController.carrinho.limpaCarrinho();
                        }
                    } else {
                        View.mostrarMensagem("Carrinho Vazio!", "Erro");
                    }
                    break;
                case 5:
                    if (produtosCarrinho.length > 0) {
                        View.confirmaOpcao(String.format("O valor total da compra é %.2f. Deseja finalizar?",
                                MainController.carrinho.getTotal()));
                        MainController.carrinho.limpaCarrinho();
                    } else {
                        View.mostrarMensagem("Carrinho Vazio!", "Erro");
                    }
                    break;
                case 6:
                    trocandoUsuario = true;
                    break;
                case 7:
                    executando = false;
                    break;
            }
        } while ((opcao >= 0 && opcao < 8) && executando && !trocandoUsuario);
        return executando;
    }
}
