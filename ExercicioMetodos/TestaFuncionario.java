public class TestaFuncionario {
    public static void main(String[] args) {
        
        //Criando os dois objetos e atribuindo valores
        Funcionario f1 = new Funcionario();
        f1.nome = "Alex";
        f1.salario = 2500.00;

        Funcionario f2 = new Funcionario();
        f2.nome = "Lívia";
        f2.salario = 3000.00;

        // Testando o método de consulta
        System.out.println("=== DADOS INICIAIS ===");
        f1.consultaDados();
        f2.consultaDados();

        // Testando o aumento de salário
        System.out.println("=== APÓS O AUMENTO ===");
        f1.aumentaSalario(350.00); 
        f1.consultaDados(); 
    }
}