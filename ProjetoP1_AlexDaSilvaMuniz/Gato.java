// Gato HERDA de Animal (herança)
public class Gato extends Animal {

    // Atributo específico do gato - privado (encapsulamento)
    private boolean ehCaseiro;

    // ========================
    // GETTER E SETTER
    // ========================

    public boolean isEhCaseiro() {
        return ehCaseiro;
    }

    public void setEhCaseiro(boolean ehCaseiro) {
        this.ehCaseiro = ehCaseiro;
    }

    // ========================
    // MÉTODOS
    // ========================

    // REESCRITA DE MÉTODO - sobrescreve o emitirSom() da classe Animal
    @Override
    public void emitirSom() {
        System.out.println(getNome() + " faz: Miau!");
    }

    // REESCRITA DE MÉTODO - sobrescreve o mostrarDados() da classe Animal
    @Override
    public void mostrarDados() {
        // Chama o mostrarDados() da classe mãe (Animal) primeiro
        super.mostrarDados();
        // Depois adiciona as informações específicas do gato
        if (this.ehCaseiro) {
            System.out.println("Tipo: Gato caseiro");
        } else {
            System.out.println("Tipo: Gato de rua");
        }
    }

    // SOBRECARGA DE MÉTODO - dormir() sem parâmetro
    public void dormir() {
        System.out.println(getNome() + " está dormindo...");
    }

    // SOBRECARGA DE MÉTODO - dormir() com parâmetro (mesmo nome, parâmetros diferentes)
    public void dormir(int horas) {
        System.out.println(getNome() + " está dormindo por " + horas + " horas.");
    }
}