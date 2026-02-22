import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("bem vindo a biblioteca");
        System.out.println("digite o seu nome");
        String nome = sc.nextLine();

        System.out.println("\nQual é o seu tipo de usuário?");
        System.out.println("1 - Estudante (até 3 livros)");
        System.out.println("2 - Professor (até 5 livros)");
        System.out.println("3 - Visitante (até 2 livros)");
        int opcao = sc.nextInt();

        int limiteLivros;
        String tipoUsuario;

        switch (opcao) {
            case 1:
                limiteLivros = 3;
                tipoUsuario = "Estudante";
                break;
            case 2:
                limiteLivros = 5;
                tipoUsuario = "Professor";
                break;
            case 3:
                limiteLivros = 2;
                tipoUsuario = "Visitante";
                break;
            default:
                System.out.println("Opção inválida! Considerando Visitante.");
                limiteLivros = 2;
                tipoUsuario = "Visitante";
        }


        System.out.println("quantos livros voce quer ?");
        int quantidade = sc.nextInt();

        if (quantidade > limiteLivros) {
            System.out.println("Desculpe " + nome + ", o perfil " + tipoUsuario + " permite apenas " + limiteLivros + " livros.");
        } else {
            System.out.println("esses sao os generos de livros que tenho....");
            System.out.println("1-romance");
            System.out.println("2- Técnico ");
            System.out.println("3-Infantil");
        }

        for (int i = 1; i <= quantidade; i++) {
            System.out.println("quantidade de livros");
            System.out.println("1-romanca");
            System.out.println("2-TECNICO");
            System.out.println("3-infantil");
            int genero = sc.nextInt();

            switch (genero) {
                case 1:
                    System.out.println("voce tem 10 dias para devolver o livros");
                    break;
                case 2:
                    System.out.println("voce tem 14 dias para devolver o livros");
                    break;
                case 3:
                    System.out.println("voce tem 12 dias para devolver o livros");
                    break;
                default:
                    System.out.println("genero invalido");
                    break;
            }
        }

        System.out.println("digite se o livros esta danificado(sim/nao)");
        String respostaDanificado = sc.next();
        if (respostaDanificado.equalsIgnoreCase("sim")) {
            System.out.println("tem que pagar a multa");
        } else {
            System.out.println("nao tem multa");
        }

        System.out.println("O livro está danificado? (sim/nao)");
        String livroDanificado = sc.next();  // ← Agora é String

        if (livroDanificado.equalsIgnoreCase("sim")) {  // ← equalsIgnoreCase funciona!
            double totalTaxas = 15.0;
            System.out.println("Taxa de dano: R$ 15,00");
        } else {
            System.out.println("Livro em boas condições!");
        }


        boolean temMulta = false;
        double totalTaxas = 0.0;


        if (opcao == 1 && !temMulta && totalTaxas > 0) {
            System.out.println(" Isenção para estudante sem multas!");
            totalTaxas = 0.0;



        }

        System.out.println("\n==============================");
        System.out.println("Usuário: " + nome);
        System.out.println("Tipo: " + tipoUsuario);
        System.out.println("Livros emprestados: " + quantidade);
        System.out.printf("Total de taxas: R$ %.2f%n", totalTaxas);
        System.out.println("==============================");
        System.out.println("Obrigado por usar a biblioteca!");

        sc.close();

    }
}
