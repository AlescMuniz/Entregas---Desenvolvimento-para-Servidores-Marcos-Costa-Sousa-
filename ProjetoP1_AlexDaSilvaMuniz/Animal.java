public class Animal {

    // Atributos privados - encapsulamento
    private String nome;
    private String especie;
    private int idade;

    // ========================
    // GETTERS E SETTERS
    // ========================

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // ========================
    // MÉTODOS
    // ========================

    // Método que será reescrito nas subclasses (reescrita de método)
    public void emitirSom() {
        System.out.println("O animal faz um som...");
    }

    // Método para mostrar os dados do animal - também será reescrito
    public void mostrarDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Espécie: " + this.especie);
        System.out.println("Idade: " + this.idade + " anos");
    }
}
