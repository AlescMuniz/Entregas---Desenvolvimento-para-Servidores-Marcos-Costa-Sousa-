package login;

/**
 * Tela de Login do sistema.
 * Contém campos de usuário e senha, botões Entrar e Cadastrar.
 */

// Importações de todas as bibliotecas que estou utilizando na classe
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends JFrame {

    // tela Objeto JPanel (tela em si)
    private final JPanel panelTela;

    // txtusuario Objeto JTextField (campo na tela)
    private final JTextField txtUsuario;

    // pswSenha Objeto JPasswordField (campo na tela)
    private final JPasswordField pswSenha;

    // validar se o usuario é correto
    private boolean usuarioValido;

    // Método construtor
    public TelaLogin() {
        // coloca o objeto na referencia do centro da tela
        setLocationRelativeTo(null);

        // não permite que o objeto seja expandido
        setResizable(false);

        // coloca titulo na caixa JFrame
        setTitle("Login - Senac");

        // Quando clicado no X eu encerro todo o programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // define posionamento e tamanho
        //    x    y  width height
        setBounds(500, 200, 426, 212);

        // Crio um objeto JPanel e atribuo ele a variável tela
        panelTela = new JPanel();

        // Define a cor de fundo do JPanel (tela)
        panelTela.setBackground(SystemColor.gray);
        setContentPane(panelTela);

        // Vou utilizar o meu panel sem utilizar o padrão
        panelTela.setLayout(null);

        // Adicionando elementos na tela:
        // Criando um objeto do tipo JLabel e atribuindo o valor ao atributo
        JLabel lblIdentificacao = new JLabel("IDENTIFICAÇÃO");

        // Localização na tela
        lblIdentificacao.setBounds(144, 0, 160, 39);

        // Definindo a Fonte
        lblIdentificacao.setFont(new Font("Arial", 3, 19));

        // Adicionando o meu label ao meu Panel
        panelTela.add(lblIdentificacao);

        // Identificação e Posicionamento dos labels
        JLabel lblUsuario = new JLabel("Usuário");
        lblUsuario.setBounds(24, 65, 70, 15);
        panelTela.add(lblUsuario);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(24, 92, 70, 15);
        panelTela.add(lblSenha);

        // Identificação e Posicionamento dos texts fields
        txtUsuario = new JTextField();
        txtUsuario.setBounds(112, 63, 219, 19);
        panelTela.add(txtUsuario);
        txtUsuario.setColumns(10);

        pswSenha = new JPasswordField();
        pswSenha.setBounds(112, 90, 219, 19);
        panelTela.add(pswSenha);

        // Identificação e Posicionamento dos botões
        JButton btnEntrar    = new JButton("Entrar");
        btnEntrar.setBounds(200, 136, 117, 25);
        panelTela.add(btnEntrar);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(50, 136, 117, 25);
        panelTela.add(btnCadastrar);

        // =====================================================
        // Ação no botão de entrar no sistema
        // =====================================================
        btnEntrar.addActionListener((ActionEvent e) -> {
            // Instancio a classe usuario
            Usuario usu = new Usuario();

            // Utilizo o setter de usuario e senha
            usu.setUsuario(txtUsuario.getText());
            usu.setSenha(pswSenha.getText());

            if ("".equals(txtUsuario.getText())) {
                // Vamos dar uma mensagem na tela
                JOptionPane.showMessageDialog(null,
                        "Campo usuário precisa ser informado!",
                        "Atenção",
                        JOptionPane.ERROR_MESSAGE);
                // Voltar o cursor para o campo txtUsuario
                txtUsuario.grabFocus();

            } else if ("".equals(pswSenha.getText())) {
                // Vamos dar uma mensagem na tela
                JOptionPane.showMessageDialog(null,
                        "Campo senha precisa ser informado!",
                        "Atenção",
                        JOptionPane.ERROR_MESSAGE);
                // Voltar o cursor para o campo senha
                pswSenha.grabFocus();

            } else {
                // Verifico se o usuário consta no banco de dados
                usuarioValido = usu.verificaUsuario(usu.getUsuario(),
                        usu.getSenha());

                if (usuarioValido == true) {
                    // Usuário e senha bateram no banco, estão corretos
                    JOptionPane.showMessageDialog(null,
                            "Usuário válido em nossa base de dados",
                            "Atenção",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Usuário e senha bateram no banco, estão incorretos
                    JOptionPane.showMessageDialog(null,
                            "Usuário inválido ou inexistente",
                            "Atenção",
                            JOptionPane.ERROR_MESSAGE);

                    // Método para limpar os texto
                    limpaText();

                    // Mando o foco para o campo usuário
                    txtUsuario.grabFocus();
                }
            }
        });

        // =====================================================
        // Ação no botão Cadastrar – abre a tela de cadastro
        // =====================================================
        btnCadastrar.addActionListener((ActionEvent e) -> {
            // Instancio a classe TelaCadastro
            TelaCadastro tCadastro = new TelaCadastro();
            tCadastro.abreTela();
            dispose(); // Fecha a tela de login
        });
    }

    // Método que abre a tela
    public void abreTela() {
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    }

    // Método que limpa os campos de usuário e senha
    public void limpaText() {
        txtUsuario.setText("");
        pswSenha.setText("");
    }
}
