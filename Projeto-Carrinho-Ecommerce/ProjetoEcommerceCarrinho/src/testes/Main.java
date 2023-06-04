package testes;

import models.*;

import java.util.List;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        CatalogoProdutos catalogoProdutos = new CatalogoProdutos();
        Produto produtoCatologo1 = new ProdutoCatalogo();
        Produto produtoCatologo2 = new ProdutoCatalogo();
        Produto produtoCatologo3 = new ProdutoCatalogo();
        Produto produtoCatologo4 = new ProdutoCatalogo();
        produtoCatologo1.setName("Teste1");
        produtoCatologo2.setName("Teste2");
        produtoCatologo3.setName("Teste3");
        produtoCatologo4.setName("Teste4");

        catalogoProdutos.adicionarProduto(produtoCatologo1);
        catalogoProdutos.adicionarProduto(produtoCatologo2);
        catalogoProdutos.adicionarProduto(produtoCatologo3);
        catalogoProdutos.removerProduto(produtoCatologo2.getId());
//        List<Produto> produtos = Arrays.asList(produtoCatologo1, produtoCatologo2, produtoCatologo3, produtoCatologo4);
//        catalogoProdutos.setListaDeProdutos(produtos);
        catalogoProdutos.mostrarProdutos().forEach(System.out::println);

        System.out.println("Carrinho:\n");
        Carrinho carrinho = new Carrinho();
        Produto produtoCarrinho1 = new ProdutoCarrinho();
        Produto produtoCarrinho2 = new ProdutoCarrinho();
        Produto produtoCarrinho3 = new ProdutoCarrinho();
        Produto produtoCarrinho4 = new ProdutoCarrinho();
        produtoCarrinho1.setName("Teste1");
        produtoCarrinho2.setName("Teste2");
        produtoCarrinho3.setName("Teste3");
        produtoCarrinho4.setName("Teste4");

        List<Produto> produtosCar = Arrays.asList(produtoCarrinho1, produtoCarrinho2, produtoCarrinho3, produtoCarrinho4);
        carrinho.setListaDeProdutos(produtosCar);
        carrinho.mostrarProdutos().forEach(System.out::println);
    }
}
