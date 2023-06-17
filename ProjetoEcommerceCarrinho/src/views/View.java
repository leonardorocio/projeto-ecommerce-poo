package views;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import models.Produto;
import models.Usuario;

public class View {

    public static int exibeMenuInicial() {
        return JOptionPane.showConfirmDialog(null, "Deseja utilizar o sistema de catalogo e carrinho?",
                "Carrinho de compras", JOptionPane.OK_CANCEL_OPTION);
    }

    public static int selecionaOpcao(String[] opcoes) {
        JComboBox menuOpcoes = new JComboBox<String>(opcoes);
        int opcaoBotaoJanela = JOptionPane.showConfirmDialog(null, menuOpcoes, "O que deseja fazer?",
                JOptionPane.OK_CANCEL_OPTION);
        if (opcaoBotaoJanela != 0) {
            return -1;
        }
        return menuOpcoes.getSelectedIndex();
    }

    public static int confirmaOpcao(String mensagem) {
        return JOptionPane
                .showConfirmDialog(null, mensagem,
                        "Confirmação", JOptionPane.YES_NO_OPTION);
    }

    public static Produto selecionaOpcao(Produto[] opcoes) {
        JComboBox menuOpcoes = new JComboBox<Produto>(opcoes);
        int opcaoBotaoJanela = JOptionPane.showConfirmDialog(null, menuOpcoes, "O que deseja fazer?",
                JOptionPane.OK_CANCEL_OPTION);
        if (opcaoBotaoJanela != 0) {
            return null;
        }
        return (Produto) menuOpcoes.getSelectedItem();
    }

    public static void mostrarMensagem(Object message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.CLOSED_OPTION);
    }

    public static Usuario mostraLogin() {
        String nomeDeUsuario = JOptionPane.showInputDialog(null, "Digite o nome do usuário: ");
        String senhaDeUsuario = JOptionPane.showInputDialog(null, "Digite a senha do usuário: ");
        Usuario usuarioAutenticado = Usuario.autenticarUsuario(nomeDeUsuario, senhaDeUsuario);
        if (usuarioAutenticado != null) {
            return usuarioAutenticado;
        }
        View.mostrarMensagem("Usuário ou senha incorretos", "Erro");
        return null;
    }

    public static String solicitaNome() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto");
        return nome != null && !nome.isEmpty() ? nome : null;
    }

    public static String solicitaTermoDeBusca() {
        String termo = JOptionPane.showInputDialog(null, "Digite o termo do produto");
        return termo != null && !termo.isEmpty() ? termo : null;
    }

    public static double solicitaPreco() {
        String precoString = JOptionPane.showInputDialog(null, "Digite o preço do produto");
        boolean ehNulo = precoString == null || precoString.isEmpty() ? true : false;
        // precoString.chars().boxed().map(e -> )
        return ehNulo ? -1 : Double.parseDouble(precoString);
    }

    public static String solicitaDescricao() {
        String descricao = JOptionPane.showInputDialog(null, "Digite a descrição do produto");
        return descricao != null && !descricao.isEmpty() ? descricao : null;
    }

    public static int solicitaEstoque() {
        String estoqueString = JOptionPane.showInputDialog(null, "Digite a quantidade em estoque do produto: ");
        boolean ehNulo = estoqueString == null || estoqueString.isEmpty() ? true : false;
        return ehNulo ? -1 : Integer.parseInt(estoqueString);
    }

    public static int solicitaQuantidade() {
        String quantidadeString = JOptionPane.showInputDialog(null, "Digite a quantidade do produto desejada: ");
        boolean ehNulo = quantidadeString == null || quantidadeString.isEmpty() ? true : false;
        return ehNulo ? -1 : Integer.parseInt(quantidadeString);
    }

    public static int selecionaPropriedadeProduto() {
        String[] propriedades = { "Nome", "Preço", "Descrição", "Estoque" };
        JComboBox propriedadesBox = new JComboBox<String>(propriedades);
        int opcaoBotaoJanela = JOptionPane.showConfirmDialog(propriedadesBox, propriedadesBox,
                "Selecione a propriedade do produto",
                JOptionPane.OK_CANCEL_OPTION);
        if (opcaoBotaoJanela != 0) {
            return -1;
        }
        return propriedadesBox.getSelectedIndex();
    }

}