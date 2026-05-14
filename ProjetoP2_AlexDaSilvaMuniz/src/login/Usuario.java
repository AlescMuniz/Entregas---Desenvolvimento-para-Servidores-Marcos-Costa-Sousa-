package login;

import java.sql.SQLException; // Tratar as exceções no banco de dados

/**
 * Classe que representa o Usuário do sistema.
 * Contém atributos, getters/setters e métodos de verificação e cadastro.
 */
public class Usuario {

    // Criação dos atributos privados da classe
    private String  usuario;
    private String  nome;
    private String  senha;

    // Atributos que armazenarão o retorno do banco de dados
    private boolean resultUsuario;
    private boolean resultCadastro;
    private boolean resultadoPadraoSenha;

    // =========================================================
    // Getters e Setters
    // =========================================================

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // =========================================================
    // Método que verifica o tamanho mínimo da senha (mínimo 10 caracteres)
    // =========================================================
    public boolean verificaPadraoSenha(String senha) {
        if (senha.length() < 10) {
            resultadoPadraoSenha = false;
        } else {
            resultadoPadraoSenha = true;
        }
        return resultadoPadraoSenha;
    }

    // =========================================================
    // Método de verificação da autenticidade do usuario (Login)
    // Recebe usuario E senha - valida login
    // =========================================================
    public boolean verificaUsuario(String usuario, String senha) {
        // Fazer a instância da conexão com o banco de dados
        Conexao banco = new Conexao();

        try {
            // Abro a conexão com o banco de dados
            banco.abrirConexao();

            // Criando parâmetro de retorno
            banco.stmt = banco.con.createStatement();

            // Executando a consulta no banco de dados
            banco.resultset =
                banco.stmt.executeQuery(
                    "SELECT * FROM usuario "
                    + "WHERE usuario = '" + usuario + "'"
                    + " AND senha = md5('" + senha + "')"
                );

            // Verificando se existe retorno de dados no banco
            if (banco.resultset.next()) {
                // Caso tenha
                resultUsuario = true;

                // Setters em Nome e Usuario
                setNome(banco.resultset.getString(1));
                setUsuario(banco.resultset.getString(2));

            } else {
                // Caso não tenha
                resultUsuario = false;
            }

            banco.fecharConexao(); // fecha nossa conexão com o banco de dados

        } catch (SQLException ec) {
            System.out.println("Erro ao consultar usuário " + ec.getMessage());
        }

        return resultUsuario;
    }

    // =========================================================
    // Método de verificação do usuário (Cadastro) - SOBRECARGA
    // Recebe apenas o usuario - verifica duplicidade
    // =========================================================
    public boolean verificaUsuario(String usuario) {
        // Fazer a instância da conexão com o banco de dados
        Conexao banco = new Conexao();

        try {
            // Criando parâmetro de retorno
            banco.stmt = banco.con.createStatement();

            // Executando a consulta no banco de dados (somente usuario)
            banco.resultset =
                banco.stmt.executeQuery(
                    "SELECT * FROM usuario "
                    + "WHERE usuario = '" + usuario + "'"
                );

            // Verificando se existe retorno de dados no banco
            if (banco.resultset.next()) {
                // Caso tenha - usuário já existe
                resultUsuario = true;
            } else {
                // Caso não tenha - usuário livre
                resultUsuario = false;
            }

            banco.fecharConexao(); // fecha nossa conexão com o banco de dados

        } catch (SQLException ec) {
            System.out.println("Erro ao consultar usuário " + ec.getMessage());
        }

        return resultUsuario;
    }

    // =========================================================
    // Método para cadastro de usuário no banco (INSERT)
    // =========================================================
    public boolean cadastraUsuario(String nome, String usuario, String senha) {
        // Fazer a instância da conexão com o banco de dados
        Conexao banco = new Conexao();

        try {
            // Abertura da conexão com o banco de dados
            banco.abrirConexao();

            // Criando parâmetro de retorno
            banco.stmt = banco.con.createStatement();

            // Executando a inserção dos dados
            banco.stmt.execute(
                "INSERT INTO usuario (nome, usuario, senha)"
                + " VALUES ('" + nome + "','" + usuario + "', md5('"
                + senha + "'))"
            );

            resultCadastro = true;

        } catch (SQLException ec) {
            System.out.println("Erro ao inserir o usuário " + ec.getMessage());
            resultCadastro = false;
        }

        return resultCadastro;
    }
}
