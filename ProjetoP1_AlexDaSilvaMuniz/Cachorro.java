// Cachorro HERDA de Animal (herança)
public class Cachorro extends Animal {

    // Atributos específicos de cachorro - privados (encapsulamento)
    private String raca;
    private String nomeDoDono;

    // ========================
    // GETTERS E SETTERS
    // ========================

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getNomeDoDono() {
        return nomeDoDono;
    }

    public void setNomeDoDono(String nomeDoDono) {
        this.nomeDoDono = nomeDoDono;
    }

    // ========================
    // MÉTODOS
    // ========================

    // REESCRITA DE MÉTODO - sobrescreve o emitirSom() da classe Animal
    @Override
    public void emitirSom() {
        System.out.println(getNome() + " faz: Au Au!");
    }

    // REESCRITA DE MÉTODO - sobrescreve o mostrarDados() da classe Animal
    @Override
    public void mostrarDados() {
        // Chama o mostrarDados() da classe mãe (Animal) primeiro
        super.mostrarDados();
        // Depois adiciona as informações específicas do cachorro
        System.out.println("Raça: " + this.raca);
        System.out.println("Dono: " + this.nomeDoDono);
    }

    // SOBRECARGA DE MÉTODO - brincar() sem parâmetro
    public void brincar() {
        System.out.println(getNome() + " está brincando sozinho!");
    }

    // SOBRECARGA DE MÉTODO - brincar() com parâmetro (mesmo nome, parâmetros diferentes)
    public void brincar(String brinquedo) {
        System.out.println(getNome() + " está brincando com: " + brinquedo);
    }
}