package main;

import models.*;
import controllers.MainController;

public class Main {
    public static Usuario usuarioComum = new Usuario("comum", "comum123", Permissao.COMUM, new Carrinho());
    public static Usuario usuarioAdmin = new Usuario("admin", "admin123", Permissao.ADMINISTRADOR);

    public static void main(String[] args) {
        MainController.mostraMenu();
    }
}
