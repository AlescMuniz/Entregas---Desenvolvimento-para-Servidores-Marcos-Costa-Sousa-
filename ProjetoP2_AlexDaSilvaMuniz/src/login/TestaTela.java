package login;

import javax.swing.JFrame;

/**
 * Classe Main para testar a exibição da TelaLogin.
 */
public class TestaTela extends JFrame {

    public static void main(String[] args) {
        // Instância da classe TelaLogin
        TelaLogin t = new TelaLogin();

        // Método de chamada do método construtor e abertura de tela
        t.abreTela();
    }
}
