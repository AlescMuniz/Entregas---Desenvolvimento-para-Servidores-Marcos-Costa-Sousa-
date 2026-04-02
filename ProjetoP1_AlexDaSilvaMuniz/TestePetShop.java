// Classe principal - ponto de entrada do programa
public class TestePetShop {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   BEM-VINDO AO SISTEMA PETSHOP!       ");
        System.out.println("========================================");


        // TESTANDO A CLASSE CACHORRO
  
        System.out.println("\n-------- CACHORRO --------");

        Cachorro c1 = new Cachorro();

        // Usando os SETTERS para atribuir valores
        c1.setNome("Rex");
        c1.setEspecie("Cachorro");
        c1.setIdade(3);
        c1.setRaca("Labrador");
        c1.setNomeDoDono("João");

        // Chamando MOSTRAR DADOS (método reescrito)
        c1.mostrarDados();

        // Chamando EMITIR SOM (método reescrito)
        c1.emitirSom();

        // SOBRECARGA - brincar sem parâmetro
        c1.brincar();

        // SOBRECARGA - brincar com parâmetro
        c1.brincar("bolinha");


        // TESTANDO A CLASSE GATO

        System.out.println("\n-------- GATO --------");

        Gato g1 = new Gato();

        // Usando os SETTERS para atribuir valores
        g1.setNome("Mimi");
        g1.setEspecie("Gato");
        g1.setIdade(2);
        g1.setEhCaseiro(true);

        // Chamando MOSTRAR DADOS (método reescrito)
        g1.mostrarDados();

        // Chamando EMITIR SOM (método reescrito)
        g1.emitirSom();

        // SOBRECARGA - dormir sem parâmetro
        g1.dormir();

        // SOBRECARGA - dormir com parâmetro
        g1.dormir(8);


        // TESTANDO A CLASSE PASSARO

        System.out.println("\n-------- PASSARO --------");

        Passaro p1 = new Passaro();

        // Usando os SETTERS para atribuir valores
        p1.setNome("Piu");
        p1.setEspecie("Papagaio");
        p1.setIdade(1);
        p1.setCorDasPenas("Verde");

        // Chamando MOSTRAR DADOS (método reescrito)
        p1.mostrarDados();

        // Chamando EMITIR SOM (método reescrito)
        p1.emitirSom();

        // SOBRECARGA - cantar sem parâmetro
        p1.cantar();

        // SOBRECARGA - cantar com parâmetro
        p1.cantar("Parabens pra voce");


        // USANDO OS GETTERS para ler valores

        System.out.println("\n-------- USANDO GETTERS --------");
        System.out.println("Nome do cachorro: " + c1.getNome());
        System.out.println("Raça do cachorro: " + c1.getRaca());
        System.out.println("Idade do gato: " + g1.getIdade());
        System.out.println("Cor das penas do passaro: " + p1.getCorDasPenas());

        System.out.println("\n========================================");
        System.out.println("         FIM DO SISTEMA PETSHOP         ");
        System.out.println("========================================");
    }
}