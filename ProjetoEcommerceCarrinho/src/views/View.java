package views;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import models.Usuario;

public class View {
    
    public static int selecionaOpcao(String[] opcoes) {
        JComboBox menuOpcoes = new JComboBox<String>(opcoes);
        JOptionPane.showConfirmDialog(null,menuOpcoes, "O que deseja fazer",JOptionPane.OK_CANCEL_OPTION);
        return menuOpcoes.getSelectedIndex();
    }

    public static Usuario mostraLogin() {
        String nomeDeUsuario = JOptionPane.showInputDialog(null, "Digite o nome do usuário" );
        String senhaDeUsuario = JOptionPane.showInputDialog(null, "Digite a senha do usuário");
        Usuario usuarioAutenticado = Usuario.autenticarUsuario(nomeDeUsuario, senhaDeUsuario);
        if (usuarioAutenticado != null) {
            return usuarioAutenticado;
        }
        JOptionPane.showMessageDialog(null, "Usuario ou senha estão incorretos");
        return null;
    }

    public static String solicitaNome() {
        return JOptionPane.showInputDialog(null, "Digite o nome do produto");
    }

    public static double solicitaPreco() {
        return Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o preco do produto"));
    }

    public static String solicitaDescricao() {
        return JOptionPane.showInputDialog(null, "Digite a descricao do usuário");
    }

    public static int solicitaEstoque() {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade em estoque do produto: "));
    }
}