package login;

/**
 * Classe de teste da conexão com o banco de dados.
 * Abre a conexão, aguarda 4 segundos e fecha.
 */
public class TestaConexao {

    public static void main(String[] args) {
        Conexao c = new Conexao(); // Instanciamos o objeto c de Conexão
        c.abrirConexao();          // Chamamos o método de abertura da conexão do BD.

        try {
            Thread.sleep(4000); // Fazemos uma pausa de 4 segundos
            c.fecharConexao();  // Fechamos a conexão
        } catch (InterruptedException ex) {
            // Mensagem de saída caso haja erro
            System.out.println("Houve algum problema no teste de conexão. " + ex.getMessage());
        }
    }
}
