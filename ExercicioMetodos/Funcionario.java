public class Funcionario {
    //Atributos
    String nome;
    double salario;

    //Método para aumentar o salário
    void aumentaSalario(double valorDoAumento) {
        this.salario += valorDoAumento; 
    }

    // Método para consultar os dados
    void consultaDados() {
        System.out.println("Nome do Funcionário: " + this.nome);
        System.out.println("Salário Atual: R$ " + this.salario);
        System.out.println("---------------------------");
    }
}