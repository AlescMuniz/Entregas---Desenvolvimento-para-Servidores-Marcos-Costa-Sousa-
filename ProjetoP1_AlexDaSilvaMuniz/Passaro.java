// Passaro HERDA de Animal (herança)
public class Passaro extends Animal {

    // Atributo específico do passaro - privado (encapsulamento)
    private String corDasPenas;

    // ========================
    // GETTER E SETTER
    // ========================

    public String getCorDasPenas() {
        return corDasPenas;
    }

    public void setCorDasPenas(String corDasPenas) {
        this.corDasPenas = corDasPenas;
    }

    // ========================
    // MÉTODOS
    // ========================

    // REESCRITA DE MÉTODO - sobrescreve o emitirSom() da classe Animal
    @Override
    public void emitirSom() {
        System.out.println(getNome() + " faz: Piu piu!");
    }

    // REESCRITA DE MÉTODO - sobrescreve o mostrarDados() da classe Animal
    @Override
    public void mostrarDados() {
        // Chama o mostrarDados() da classe mãe (Animal) primeiro
        super.mostrarDados();
        // Depois adiciona as informações específicas do passaro
        System.out.println("Cor das penas: " + this.corDasPenas);
    }

    // SOBRECARGA DE MÉTODO - cantar() sem parâmetro
    public void cantar() {
        System.out.println(getNome() + " está cantando!");
    }

    // SOBRECARGA DE MÉTODO - cantar() com parâmetro (mesmo nome, parâmetros diferentes)
    public void cantar(String musica) {
        System.out.println(getNome() + " está cantando: " + musica);
    }
}